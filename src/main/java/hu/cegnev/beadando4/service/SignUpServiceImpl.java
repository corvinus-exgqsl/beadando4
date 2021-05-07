package hu.cegnev.beadando4.service;

import hu.cegnev.beadando4.LoginFailedException;
import hu.cegnev.beadando4.RegistrationAlreadyExistsException;
import hu.cegnev.beadando4.dao.SignUpDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    final private SignUpDao signUpDao;

    @Override
    public void signUp(SignUp signUp) throws RegistrationAlreadyExistsException {

        Collection<SignUp> all = getAll();
        for(SignUp data: all){
            if(data.getUsername().equals(signUp.getUsername())){
                throw new RegistrationAlreadyExistsException();
            }
        }

        signUpDao.save(
                hu.cegnev.beadando4.dao.SignUp.builder()
                .name(signUp.getName())
                .username(signUp.getUsername())
                .password(signUp.getPassword())
                .build()
        );

    }

    @Override
    public Collection<SignUp> getAll() {
        return signUpDao.readAll().stream().map(
             daoSignUp -> SignUp.builder()
                     .name(daoSignUp.getName())
                     .username(daoSignUp.getUsername())
                     .password(daoSignUp.getPassword())
                     .build()
        ).collect(Collectors.toList());
    }

    @Override
    public void logIn(LogIn logIn) throws LoginFailedException {

        Collection<LogIn> all = getUsernameAndPassword();
        if(!all.contains(logIn)){
            throw new LoginFailedException();
        }
    }

    @Override
    public Collection<LogIn> getUsernameAndPassword() {
        return signUpDao.readAll().stream().map(
                daoSignIn -> LogIn.builder()
                        .username(daoSignIn.getUsername())
                        .password(daoSignIn.getPassword())
                        .build()
        ).collect(Collectors.toList());
    }

}
