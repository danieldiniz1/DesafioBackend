package br.com.bank.facade.impl;

import br.com.bank.exception.UserUnactiveException;
import br.com.bank.facade.UsuarioFacade;
import br.com.bank.model.domain.EnderecoModel;
import br.com.bank.model.domain.TelefoneModel;
import br.com.bank.model.domain.UsuarioModel;
import br.com.bank.model.dto.EnderecoWSDTO;
import br.com.bank.model.dto.TelefoneWSDTO;
import br.com.bank.model.dto.UsuarioWSDTO;
import br.com.bank.model.form.EnderecoForm;
import br.com.bank.model.form.TelefoneForm;
import br.com.bank.model.form.UsuarioForm;
import br.com.bank.model.form.UsuarioUpdateForm;
import br.com.bank.service.EnderecoService;
import br.com.bank.service.TelefoneService;
import br.com.bank.service.UsuarioService;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DefaultUsuarioFacade implements UsuarioFacade {

    private final UsuarioService usuarioService;

    private final EnderecoService enderecoService;

    private final TelefoneService telefoneService;

    protected DefaultUsuarioFacade (final UsuarioService usuarioService, final EnderecoService enderecoService,
      final TelefoneService telefoneService) {

        this.usuarioService = usuarioService;
        this.enderecoService = enderecoService;
        this.telefoneService = telefoneService;
    }

    @Override
    public UsuarioWSDTO buscarClientePorCpf (final String cpf) {

        final UsuarioModel usuarioModel = usuarioService.buscarUsuarioPorCpf(cpf);
        if (Boolean.FALSE.equals(usuarioModel.getAtivo()))
            throw new UserUnactiveException("Usuário Inativo");
        return populateUser(usuarioModel);
    }

    @Override
    public UsuarioWSDTO criarUsuario (final UsuarioForm usuarioForm) {

        return populateUser(usuarioService.criarUsuario(createUserModel(usuarioForm)));
    }

    @Override
    public void ataulizarUsuario (final String cpf, final String nome) {

    }


    @Override
    public void atualizarNomeUsuario (final UsuarioUpdateForm usuarioUpdateForm) {

        usuarioService.ataulizarUsuario(usuarioUpdateForm.cpf(), usuarioUpdateForm.nome());
    }

    @Override
    public void removerUsuario (final String cpf) {
        usuarioService.removerUsuario(cpf);
    }

    private UsuarioWSDTO populateUser (final UsuarioModel user) {

        final EnderecoModel enderecoModel = user.getEnderecoList().stream()
          .filter(e -> Boolean.TRUE.equals(e.isEnderecoPrincipal())).findFirst().orElse(null);
        return new UsuarioWSDTO(user.getNome(),
                                user.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                                new TelefoneWSDTO(user.getTelefone().getDdd(), user.getTelefone().getNumero()),
                                new EnderecoWSDTO(
                                  enderecoModel != null ? enderecoModel.getCep() : "endereço nao cadastrado"));
    }

    private UsuarioModel createUserModel (final UsuarioForm usuarioForm) {

        UsuarioModel usuarioModel = UsuarioModel.valueOf();
        usuarioModel.setAtivo(usuarioForm.ativo());
        usuarioModel.setCpf(usuarioForm.cpf());
        usuarioModel.setNome(usuarioForm.nome());
        usuarioModel.setDataNascimento(
          LocalDate.parse(usuarioForm.dataNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        usuarioModel.setTelefone(telefoneService.salvarTelefone(createTelefoneModel(usuarioForm.telefone())));
        usuarioModel.getEnderecoList().add(enderecoService.salvarEndereco(createEnderecoModel(usuarioForm.endereco())));

        return usuarioModel;
    }

    private TelefoneModel createTelefoneModel (
      final @NotNull(message = "O telefone é obrigatório.") TelefoneForm telefone) {

        return TelefoneModel.valueOf(telefone);
    }

    private EnderecoModel createEnderecoModel (
      final @NotNull(message = "O endereço é obrigatório.") EnderecoForm endereco) {

        return EnderecoModel.valueOf(endereco);
    }

}
