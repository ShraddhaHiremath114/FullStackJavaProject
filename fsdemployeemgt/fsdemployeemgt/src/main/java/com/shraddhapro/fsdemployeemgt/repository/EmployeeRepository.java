package com.shraddhapro.fsdemployeemgt.repository;

import com.shraddhapro.fsdemployeemgt.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
