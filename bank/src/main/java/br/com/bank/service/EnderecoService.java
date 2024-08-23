package br.com.bank.service;

import br.com.bank.model.domain.EnderecoModel;
import br.com.bank.model.form.EnderecoForm;
import jakarta.validation.constraints.NotNull;

public interface EnderecoService {

    EnderecoModel salvarEndereco (EnderecoModel enderecoModel);

}
