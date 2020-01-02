package net.skhu.repository;

import net.skhu.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name);
    List<Student> findByNameStartsWith(String name);
    List<Student> findByDepartmentName(String name);
    List<Student> findByDepartmentNameStartsWith(String name);

    List<Student> findAllByOrderByName();
    List<Student> findAllByOrderByNameDesc();
    List<Student> findByDepartmentIdOrderByNameDesc(int id);

}
