package com.shraddhapro.fsdemployeemgt.service;

import com.shraddhapro.fsdemployeemgt.model.Employee;
import com.shraddhapro.fsdemployeemgt.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
  }

    @Override
    public boolean deleteEmployee(Long id) {

        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        Employee EmpDB=employeeRepository.findById(id).get();
        if(Objects.nonNull(employee.getFirstName()) && !"".equalsIgnoreCase(employee.getFirstName())){
            EmpDB.setFirstName(employee.getFirstName());
        }
        if(Objects.nonNull(employee.getLastName()) && !"".equalsIgnoreCase(employee.getLastName())){
            EmpDB.setLastName(employee.getLastName());
        }
        if(Objects.nonNull(employee.getEmail()) && !"".equalsIgnoreCase(employee.getEmail())){
            EmpDB.setEmail(employee.getEmail());
        }
        return employeeRepository.save(EmpDB);
    }
}
