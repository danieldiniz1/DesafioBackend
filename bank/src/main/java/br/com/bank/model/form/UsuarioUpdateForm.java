package br.com.bank.model.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UsuarioUpdateForm(@NotNull(message = "O nome é obrigatório.")
                                @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
                                String nome,

                                @NotNull(message = "O CPF é obrigatório.")
                                @Pattern(regexp = "^\\d{11}$", message = "CPF deve ter apenas numeros")
                                String cpf) {}
