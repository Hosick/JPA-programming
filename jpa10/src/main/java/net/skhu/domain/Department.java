package net.skhu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @JsonIgnore //  Infinite Recursion 에러 방지하기 위해 JsonIgnore를 붙혀준다
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    List<Employee> employees;
}