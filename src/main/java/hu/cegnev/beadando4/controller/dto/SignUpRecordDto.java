package hu.cegnev.beadando4.controller.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@RequiredArgsConstructor
public class SignUpRecordDto {


    private String name;


    @Size(min = 6,message = "Username must be minimum 6 characters long!")
    private String username;


    @Pattern(regexp = "(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{8,})$")
    private String password;

}
