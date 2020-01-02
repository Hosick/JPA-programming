package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.skhu.domain.Department;
import net.skhu.domain.Employee;
import net.skhu.repository.DepartmentRepository;
import net.skhu.repository.EmployeeRepository;

@RestController
@RequestMapping("api")
public class APIController {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("employees")        //  모든 직원 리턴
    public List<Employee> employees() {
        return employeeRepository.findAll();
    }

    @RequestMapping("employee/{id}")    //  id로 직원 리턴
    public Employee employee(@PathVariable("id") int id) {
        return employeeRepository.findById(id).get();
    }

    @RequestMapping("departments")      //  모든 부서 리턴
    public List<Department> departments() {
        return departmentRepository.findAll();
    }

    @RequestMapping("department/{id}/employees")    //  아이디로 부서 찾아서 소속직원 리턴
    public List<Employee> department(@PathVariable("id") int id) {
        Department department = departmentRepository.findById(id).get();
        return department.getEmployees();
    }
}