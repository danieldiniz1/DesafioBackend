package com.insurance.api.facade;

import com.insurance.api.model.dto.ResultadoContratacaoWSDTO;
import com.insurance.api.model.dto.SeguroDisponivelWSDTO;
import com.insurance.api.model.enumeration.TiposSeguroEnum;

public interface SeguroFacade {

    SeguroDisponivelWSDTO buscarSegurosDisponiveis ();

    ResultadoContratacaoWSDTO contratarSeguro(String cpf, TiposSeguroEnum tiposSeguroEnum);

}
