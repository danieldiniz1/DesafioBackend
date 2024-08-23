package br.com.bank.model.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EnderecoForm(@NotNull(message = "O CEP é obrigatório.")
                           @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 12345-678")
                           String cep,

                           @NotNull(message = "O logradouro é obrigatório.")
                           @Size(min = 2, max = 100, message = "O logradouro deve ter entre 2 e 100 caracteres.")
                           String logradouro,

                           @NotNull(message = "O número é obrigatório.")
                           @Size(min = 1, max = 10, message = "O número deve ter entre 1 e 10 caracteres.")
                           String numero,

                           String complemento,

                           @NotNull(message = "O bairro é obrigatório.")
                           @Size(min = 2, max = 100, message = "O bairro deve ter entre 2 e 100 caracteres.")
                           String bairro,

                           @NotNull(message = "A cidade é obrigatória.")
                           @Size(min = 2, max = 100, message = "A cidade deve ter entre 2 e 100 caracteres.")
                           String cidade,

                           @NotNull(message = "A UF é obrigatória.")
                           @Pattern(regexp = "[A-Z]{2}", message = "A UF deve ter 2 letras maiúsculas.")
                           String uf,

                           @NotNull(message = "O país é obrigatório.")
                           @Size(min = 2, max = 100, message = "O país deve ter entre 2 e 100 caracteres.")
                           String pais,
                           Boolean enderecoPrincipal) {}
