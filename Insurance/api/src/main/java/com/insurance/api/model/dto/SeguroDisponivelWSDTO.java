package com.insurance.api.model.dto;

import com.insurance.api.model.enumeration.TiposSeguroEnum;

import java.util.List;

public record SeguroDisponivelWSDTO(List<TiposSeguroEnum> seguroDisponivel) {}
