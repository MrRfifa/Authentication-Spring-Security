package mrrfifa.authenticationspringboot.exception;

public class NotValidEmailException extends RuntimeException {
    public NotValidEmailException(String email) {
        super("This email : "+email+" is invalid");
    }
}
