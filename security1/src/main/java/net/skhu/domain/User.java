package net.skhu.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "userId")
    String loginId;

    String password;

    String name;

    String email;

    boolean enabled;

    String userType;
}
