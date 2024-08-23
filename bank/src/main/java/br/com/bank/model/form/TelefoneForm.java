package br.com.bank.model.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.boot.context.properties.bind.DefaultValue;

public record TelefoneForm(@NotNull(message = "O DDD é obrigatório.")
                           @Pattern(regexp = "\\d{2}", message = "O DDD deve ter 2 dígitos.")
                           String ddd,

                           @NotNull(message = "O número de telefone é obrigatório.")
                           @Pattern(regexp = "\\d{8,9}", message = "O número de telefone deve ter entre 8 e 9 dígitos.")
                           String numero,

                           @DefaultValue("BR")
                           @Pattern(regexp = "[A-Z]{2}", message = "O código ISO deve ter 2 letras maiúsculas.")
                           String isoCode) {}
