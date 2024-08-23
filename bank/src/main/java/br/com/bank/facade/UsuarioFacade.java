package br.com.bank.facade;

import br.com.bank.model.dto.UsuarioWSDTO;
import br.com.bank.model.form.UsuarioForm;
import br.com.bank.model.form.UsuarioUpdateForm;

public interface UsuarioFacade {

    UsuarioWSDTO buscarClientePorCpf (String cpf);

    UsuarioWSDTO criarUsuario (UsuarioForm usuarioForm);

    void ataulizarUsuario (String cpf, String nome);

    void removerUsuario (String cpf);

    void atualizarNomeUsuario (UsuarioUpdateForm usuarioUpdateForm);

}
