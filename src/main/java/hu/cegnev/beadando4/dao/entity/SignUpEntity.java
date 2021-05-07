package hu.cegnev.beadando4.dao.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class SignUpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column()
    private String name;

    @Column()
    private String username;

    @Column()
    private int passwordHash;
}
