package br.com.bank.exception;

public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException(String s) {
        super(s);
    }
}
