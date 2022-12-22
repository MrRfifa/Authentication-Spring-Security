package mrrfifa.authenticationspringboot.exception;

public class TokenNotFoundException extends RuntimeException {

    public TokenNotFoundException(String token) {
        super("This token : "+token+" is invalid");
    }
}
