package com.insurance.api.service;

import com.insurance.api.model.dto.ResultClienteDTO;
import com.insurance.api.model.dto.ResultadoContratacaoWSDTO;
import com.insurance.api.model.enumeration.TiposSeguroEnum;

import java.util.List;

public interface SeguroService {

    List<TiposSeguroEnum> buscarSegurosDisponiveis();

    ResultadoContratacaoWSDTO contratarSeguro (ResultClienteDTO resultClienteDTO);

}
