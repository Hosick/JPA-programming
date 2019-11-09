package me.hosick.demojpa.post;

import org.springframework.data.annotation.*;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Account {
    public Account() {
    }

    @Id @GeneratedValue
    private Long id;

    private String userName;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
