package net.skhu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String phone;

    String address;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    Employee employee;
}