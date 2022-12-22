package mrrfifa.authenticationspringboot.exception;

public class EmailAlreadyExistsException extends RuntimeException{

    public EmailAlreadyExistsException(String email) {
        super("This email : "+email+" is already taken");
    }
}
