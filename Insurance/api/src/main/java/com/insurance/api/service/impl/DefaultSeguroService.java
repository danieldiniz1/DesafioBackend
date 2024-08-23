package com.insurance.api.service.impl;

import com.insurance.api.model.dto.ErrosWSDTO;
import com.insurance.api.model.dto.ResultClienteDTO;
import com.insurance.api.model.dto.ResultadoContratacaoWSDTO;
import com.insurance.api.model.enumeration.TiposSeguroEnum;
import com.insurance.api.service.SeguroService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultSeguroService implements SeguroService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<TiposSeguroEnum> buscarSegurosDisponiveis () {

        return List.of(TiposSeguroEnum.BRONZE,TiposSeguroEnum.OURO,TiposSeguroEnum.PRATA);
    }

    @Override
    public ResultadoContratacaoWSDTO contratarSeguro (final ResultClienteDTO resultClienteDTO) {
        // lógica de contratação do seguro aqui
        LOGGER.info(resultClienteDTO);
        return new ResultadoContratacaoWSDTO(Boolean.TRUE,null);
    }

}
