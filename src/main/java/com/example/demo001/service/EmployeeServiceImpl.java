package com.example.demo001.service;

import com.example.demo001.model.Employee;
import com.example.demo001.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> search(String q) {
        return employeeRepository.findByNameContaining(q);
    }

    @Override
    public Employee findOne(long id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public void save(Employee contact) {
    	employeeRepository.save(contact);
    }

    @Override
    public void delete(Employee emp) {
    	employeeRepository.delete(emp);
    }
}	
