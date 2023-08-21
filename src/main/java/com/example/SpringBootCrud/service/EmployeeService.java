package com.example.SpringBootCrud.service;


import com.example.SpringBootCrud.model.Employee;
import com.example.SpringBootCrud.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        Employee employee1 = employeeRepository.save(employee);
        return employee1;
    }

    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
                employeeRepository.findAll()
                .forEach(employees::add);
        return employees;
    }

    public Employee getEmployeeById(Long id) {
            Optional<Employee> employee= employeeRepository.findById(id);
            if(employee.isPresent()){
                return employee.get();
            }
            return null;
    }

    public Optional<Employee> updateEmployee(Long id, Employee employee) {
        Optional<Employee> employeeObj = employeeRepository.findById(id);

        if(employeeObj.isPresent()){
            Employee updateEmployee = employeeObj.get();
            updateEmployee.setSalary(employee.getSalary());
            Employee employee1 = employeeRepository.save(updateEmployee);
        }
        return employeeObj;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void deleteAllEmployee() {
        employeeRepository.deleteAll();
    }
}
