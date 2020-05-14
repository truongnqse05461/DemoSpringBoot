package com.example.demo001.service;

import com.example.demo001.model.Employee;

import java.util.List;

public interface EmployeeService {
	Iterable<Employee> findAll();

    List<Employee> search(String q);

    Employee findOne(long id);

    void save(Employee emp);

    void delete(Employee emp);
}
