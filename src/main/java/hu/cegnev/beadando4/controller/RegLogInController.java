package hu.cegnev.beadando4.controller;

import hu.cegnev.beadando4.LoginFailedException;
import hu.cegnev.beadando4.RegistrationAlreadyExistsException;
import hu.cegnev.beadando4.controller.dto.LogInDto;
import hu.cegnev.beadando4.controller.dto.SignUpRecordDto;
import hu.cegnev.beadando4.service.LogIn;
import hu.cegnev.beadando4.service.SignUp;
import hu.cegnev.beadando4.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/beadando4")
@RequiredArgsConstructor
public class RegLogInController {

    private final SignUpService signUpService;

    @PostMapping("/signup")
    public void signUp(@Valid @RequestBody SignUpRecordDto signUpRecordDto) {
        try {
            signUpService.signUp(
                    SignUp.builder()
                            .name(signUpRecordDto.getName())
                            .username(signUpRecordDto.getUsername())
                            .password((signUpRecordDto.getPassword()).hashCode())
                            .build()
            );
        } catch (RegistrationAlreadyExistsException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "This username already exists. Try something else."
            );
        }
    }

    @PostMapping("/login")
    public void logIn(@RequestBody LogInDto logInDto){
        try {
            signUpService.logIn(
                    LogIn.builder()
                            .username(logInDto.getUsername())
                            .password((logInDto.getPassword()).hashCode())
                            .build()
            );
        } catch (LoginFailedException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Login failed. Incorrect username or password"
            );
        }
    }

}
