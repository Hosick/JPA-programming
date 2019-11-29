package net.skhu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString(exclude = {"students","courses","professors"})
@EqualsAndHashCode(exclude = {"students","courses","professors"})
@Entity
public class Department {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "departmentName")
    String name;

    @JsonIgnore
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    List<Student> students;

    @JsonIgnore
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    List<Course> courses;

    @JsonIgnore
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    List<Professor> professors;

}