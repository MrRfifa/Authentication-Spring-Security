package mrrfifa.authenticationspringboot.exception;

import lombok.Getter;

@Getter
public class EmailAlreadyConfirmedException extends RuntimeException {
    public EmailAlreadyConfirmedException(String message) {
        super(message);
    }

}
