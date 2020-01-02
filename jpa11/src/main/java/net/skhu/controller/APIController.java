package net.skhu.controller;

import net.skhu.domain.*;
import net.skhu.repository.DepartmentRepository;
import net.skhu.repository.ProfessorRepository;
import net.skhu.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("api")
public class APIController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @RequestMapping("departments")
    public List<Department> departments() {
        return departmentRepository.findAll();
    }

    @RequestMapping("students")
    public List<Student> students() {
        return studentRepository.findAll();
    }

    @RequestMapping("department/{id}/students")
    public List<Student> departmentStudents(@PathVariable("id") int id) {
        Department department = departmentRepository.findById(id).get();
        return department.getStudents();
    }

    @RequestMapping("department/{id}/professors")
    public List<Professor> departmentProfessors(@PathVariable("id") int id) {
        Department department = departmentRepository.findById(id).get();
        return department.getProfessors();
    }

    @RequestMapping("student/{id}/registrations")
    public List<Registration> studentRegistrations(@PathVariable("id") int id) {
        Student student = studentRepository.findById(id).get();
        return student.getRegistrations();
    }

    @RequestMapping("student/{id}/courses")
    public Stream<Course> studentCourses(@PathVariable("id") int id) {
        return studentRepository.findById(id).get().getRegistrations().stream().map(s -> s.getCourse());
    }
}
