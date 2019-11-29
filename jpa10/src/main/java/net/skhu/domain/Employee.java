package net.skhu.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departmentId")
    Department department;

    @OneToOne(mappedBy = "employee", fetch = FetchType.EAGER)
    Address address;
}