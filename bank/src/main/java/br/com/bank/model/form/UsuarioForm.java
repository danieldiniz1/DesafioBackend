package br.com.bank.model.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UsuarioForm(@NotNull(message = "O CPF é obrigatório.")
                          @Pattern(regexp = "^\\d{11}$", message = "CPF deve ter apenas numeros")
                          String cpf,

                          @NotNull(message = "O nome é obrigatório.")
                          @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
                          String nome,

                          @NotNull(message = "A data de nascimento é obrigatória.")
                          @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Data de nascimento deve estar no formato DD/MM/YYYY")
                          String dataNascimento,

                          @NotNull(message = "O telefone é obrigatório.")
                          TelefoneForm telefone,

                          @NotNull(message = "O endereço é obrigatório.")
                          EnderecoForm endereco,
                          Boolean ativo) {}
