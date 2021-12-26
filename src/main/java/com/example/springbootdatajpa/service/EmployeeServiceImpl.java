package com.example.springbootdatajpa.service;

import com.example.springbootdatajpa.dao.EmployeeRepository;
import com.example.springbootdatajpa.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public Employee get(int id) {
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAllByName(String name) {
        return repository.findAllByName(name);
    }
}
