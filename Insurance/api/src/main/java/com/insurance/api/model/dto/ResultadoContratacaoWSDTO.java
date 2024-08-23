package com.insurance.api.model.dto;

import java.util.List;

public record ResultadoContratacaoWSDTO(Boolean pedidoSeguroEnviado,
                                        List<ErrosWSDTO> errosWSDTOList) {}
