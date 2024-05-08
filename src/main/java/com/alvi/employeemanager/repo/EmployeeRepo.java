package com.alvi.employeemanager.repo;

import com.alvi.employeemanager.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {



    void deleteEmployeeById(Integer id);

   Optional<Employee>findEmployeeById(Integer id);
}
