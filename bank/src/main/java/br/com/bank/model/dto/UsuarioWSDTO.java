package br.com.bank.model.dto;

public record UsuarioWSDTO(String nome,
                           String dataNascimento,
                           TelefoneWSDTO telefone,
                           EnderecoWSDTO endereco) {

}
