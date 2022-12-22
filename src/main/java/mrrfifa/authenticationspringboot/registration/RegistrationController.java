package mrrfifa.authenticationspringboot.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/sign-up")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @GetMapping(path = "/confirm/{token}")
    public Map<String, String> confirm(@PathVariable String token){
        return registrationService.confirmToken(token);
    }
}
