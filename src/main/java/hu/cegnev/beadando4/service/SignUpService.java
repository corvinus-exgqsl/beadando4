package hu.cegnev.beadando4.service;

import hu.cegnev.beadando4.LoginFailedException;
import hu.cegnev.beadando4.RegistrationAlreadyExistsException;

import java.util.Collection;

public interface SignUpService {
    void signUp(SignUp signUp) throws RegistrationAlreadyExistsException;

    Collection<SignUp> getAll();

    void logIn(LogIn logIn) throws LoginFailedException, LoginFailedException;

    Collection<LogIn> getUsernameAndPassword();
}
