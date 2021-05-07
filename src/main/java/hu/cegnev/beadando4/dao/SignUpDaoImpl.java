package hu.cegnev.beadando4.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Slf4j
@RequiredArgsConstructor
public class SignUpDaoImpl implements SignUpDao {

    private final UserRepository userRepository;

    @Override
    public Collection<SignUp> readAll() {

        return StreamSupport.stream(userRepository.findAll().spliterator(),false).
                map(entity -> SignUp.builder()
                        .name(entity.getName())
                        .username(entity.getUsername())
                        .password(entity.getPasswordHash())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void save(SignUp signUp) {

        hu.cegnev.beadando4.dao.entity.SignUpEntity entity =
                new hu.cegnev.beadando4.dao.entity.SignUpEntity();
        entity.setName(signUp.getName());
        entity.setUsername(signUp.getUsername());
        entity.setPasswordHash(signUp.getPassword());
        userRepository.save(entity);

    }
}
