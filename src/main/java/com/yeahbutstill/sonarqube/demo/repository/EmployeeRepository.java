package com.yeahbutstill.sonarqube.demo.repository;

import com.yeahbutstill.sonarqube.demo.domain.dao.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  Employee findByNik(String nik);
}
