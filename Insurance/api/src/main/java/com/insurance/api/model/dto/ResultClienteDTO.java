package com.insurance.api.model.dto;

public record ResultClienteDTO(String nome,
                               String dataNascimento,
                               TelefoneDTO telefone,
                               EnderecoDTO endereco) {}
