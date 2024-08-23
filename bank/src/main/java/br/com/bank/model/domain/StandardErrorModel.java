package br.com.bank.model.domain;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class StandardErrorModel {

    private String message, error, timeStamp;

    public static StandardErrorModel valueOf (Exception exception) {

        var stm = new StandardErrorModel();
        stm.error = Objects.nonNull(exception.getMessage()) ? exception.getMessage() : exception.getClass().getSimpleName();
        stm.message = exception.getMessage();
        stm.timeStamp = LocalDateTime.now().toString();
        return stm;
    }

}
