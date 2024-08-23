package br.com.bank.exception;

public class UserUnactiveException extends RuntimeException {
    public UserUnactiveException (String s) {
        super(s);
    }
}
