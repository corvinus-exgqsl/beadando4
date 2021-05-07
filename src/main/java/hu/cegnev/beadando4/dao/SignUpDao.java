package hu.cegnev.beadando4.dao;

import java.util.Collection;

public interface SignUpDao {
    Collection<SignUp> readAll();
    void save (SignUp signUp);
}
