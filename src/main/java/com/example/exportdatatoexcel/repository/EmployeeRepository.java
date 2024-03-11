package com.example.exportdatatoexcel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.exportdatatoexcel.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
