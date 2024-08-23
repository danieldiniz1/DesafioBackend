package br.com.bank.service;

import br.com.bank.model.domain.UsuarioModel;

public interface UsuarioService {

    UsuarioModel buscarUsuarioPorCpf (String cpf);

    UsuarioModel criarUsuario (UsuarioModel usuarioForm);

    void ataulizarUsuario (String cpf, String nome);

    void removerUsuario (String cpf);
}
