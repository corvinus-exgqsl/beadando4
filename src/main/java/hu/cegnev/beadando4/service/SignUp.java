package hu.cegnev.beadando4.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SignUp {
    private String name;
    private String username;
    private int password;
}
