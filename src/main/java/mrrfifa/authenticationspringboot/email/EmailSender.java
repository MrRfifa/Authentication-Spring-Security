package mrrfifa.authenticationspringboot.email;

import org.springframework.mail.MailSender;

public interface EmailSender  {
    void send(String to,String email);
}
