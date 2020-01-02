package net.skhu.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString(exclude = {"student", "course"})
@EqualsAndHashCode(exclude = {"student", "course"})
@Entity
@Table(name = "register")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    Integer grade;

    Date createDate;

    @ManyToOne
    @JoinColumn(name = "studentId")
    Student student;

    @ManyToOne
    @JoinColumn(name = "courseId")
    Course course;

}