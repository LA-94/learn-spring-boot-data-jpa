package com.example.springbootdatajpa.cotrollers;

import com.example.springbootdatajpa.domain.Employee;
import com.example.springbootdatajpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private final EmployeeService service;

    @Autowired
    public EmployeeRestController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Employee> getAllEmployees() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping("")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        service.save(employee);
        return employee;
    }

    @PutMapping("")
    public Employee updateEmployee(@RequestBody Employee employee) {
        service.save(employee);
        return employee;
    }

    @DeleteMapping("/{id}")
    public String removeEmployee(@PathVariable int id) {
        service.delete(id);
        return String.format("Employee with id = %s was deleted", id);
    }

    @GetMapping("/name/{name}")
    public List<Employee> findAllByName(@PathVariable String name) {
        return service.findAllByName(name);
    }
}
