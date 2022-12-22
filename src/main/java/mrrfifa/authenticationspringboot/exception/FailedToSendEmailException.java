package mrrfifa.authenticationspringboot.exception;

public class FailedToSendEmailException extends RuntimeException {
    public FailedToSendEmailException(String to) {
        super("Failed to send confirmation email to : "+to);
    }
}
