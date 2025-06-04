package com.hibernate.commit_rollback;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);

        // Simulating an exception to test rollback
        if (employee.getName().equalsIgnoreCase("Error")) {
            throw new RuntimeException("Simulated Exception - Transaction will be rolled back!");
        }
    }
}
