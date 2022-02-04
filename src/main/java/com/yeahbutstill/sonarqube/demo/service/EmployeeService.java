package com.yeahbutstill.sonarqube.demo.service;

import com.yeahbutstill.sonarqube.demo.domain.dto.external.EmployeeDtoRequest;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {

  ResponseEntity<Object> getEmployee(String request);

  ResponseEntity<Object> insertEmployee(EmployeeDtoRequest request);

  ResponseEntity<Object> updateEmployee(EmployeeDtoRequest request);

  ResponseEntity<Object> deleteEmployee(Long request);

  ResponseEntity<Object> listEmployee();
}
