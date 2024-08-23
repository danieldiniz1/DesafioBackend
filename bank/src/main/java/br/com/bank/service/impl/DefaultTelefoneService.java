package br.com.bank.service.impl;

import br.com.bank.exception.ModelSimpleSaveException;
import br.com.bank.model.domain.TelefoneModel;
import br.com.bank.repository.TelefoneRepository;
import br.com.bank.service.TelefoneService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DefaultTelefoneService implements TelefoneService {

    private final TelefoneRepository telefoneRepository;

    public DefaultTelefoneService(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

    @Override
    @Transactional
    public TelefoneModel salvarTelefone (final TelefoneModel telefoneModel) {
        try {
            return telefoneRepository.save(telefoneModel);
        }
        catch (Exception e) {
            throw new ModelSimpleSaveException(e.getMessage());
        }
    }

}
