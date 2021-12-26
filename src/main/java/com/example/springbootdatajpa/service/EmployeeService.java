package com.example.springbootdatajpa.service;

import com.example.springbootdatajpa.domain.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    void save(Employee employee);

    Employee get(int id);

    void delete(int id);

    List<Employee> findAllByName(String name);
}
