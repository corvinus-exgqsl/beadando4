package hu.cegnev.beadando4.dao;

import hu.cegnev.beadando4.dao.entity.SignUpEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<SignUpEntity, Long> {
}
