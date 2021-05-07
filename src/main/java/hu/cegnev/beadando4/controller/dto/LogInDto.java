package hu.cegnev.beadando4.controller.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LogInDto {

    private String username;
    private String password;
}
