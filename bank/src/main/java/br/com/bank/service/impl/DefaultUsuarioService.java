package br.com.bank.service.impl;

import br.com.bank.exception.ModelNotFoundException;
import br.com.bank.model.domain.UsuarioModel;
import br.com.bank.repository.UsuarioRepository;
import br.com.bank.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DefaultUsuarioService implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    protected DefaultUsuarioService (final UsuarioRepository usuarioRepository) {

        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioModel buscarUsuarioPorCpf (final String cpf) {

        return usuarioRepository.findByCpf(cpf).orElseThrow(() -> new ModelNotFoundException("Usuário não encontrado"));
    }

    @Override
    @Transactional
    public UsuarioModel criarUsuario (final UsuarioModel usuarioModel) {

        try {
            return usuarioRepository.save(usuarioModel);
        } catch (Exception e) {
            throw new ModelNotFoundException(e.getMessage());
        }
    }

    @Override
    public void ataulizarUsuario (final String cpf, final String nome) {

        final UsuarioModel usuarioModel = this.buscarUsuarioPorCpf(cpf);
        usuarioModel.setNome(nome);
        usuarioRepository.save(usuarioModel);
    }

    @Override
    public void removerUsuario (final String cpf) {

        final UsuarioModel usuarioModel = this.buscarUsuarioPorCpf(cpf);
        usuarioModel.setAtivo(Boolean.FALSE);
        usuarioRepository.save(usuarioModel);
    }

}
