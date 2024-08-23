package br.com.bank.service;

import br.com.bank.model.domain.TelefoneModel;
import br.com.bank.model.form.TelefoneForm;
import jakarta.validation.constraints.NotNull;

public interface TelefoneService {

    TelefoneModel salvarTelefone (TelefoneModel telefoneModel);

}
