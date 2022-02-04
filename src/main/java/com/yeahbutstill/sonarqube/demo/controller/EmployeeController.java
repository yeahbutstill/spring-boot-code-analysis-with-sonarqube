package com.yeahbutstill.sonarqube.demo.controller;

import com.yeahbutstill.sonarqube.demo.domain.dto.external.EmployeeDtoRequest;
import com.yeahbutstill.sonarqube.demo.service.implementation.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@RestController
@EnableWebMvc
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

  private final EmployeeServiceImpl employeeService;

  @PostMapping(value = "/")
  public ResponseEntity<Object> findAllEmployee() {
    try {
      return employeeService.listEmployee();

    } catch (Exception e) {
      log.error(
          "Happened error when findAll employee : {} {}",
          e.getClass().getName(),
          e.getStackTrace());
      log.trace("{}", String.valueOf(e));
      throw e;
    }
  }

  @PostMapping(value = "/create")
  public ResponseEntity<Object> insertEmployee(@RequestBody EmployeeDtoRequest request) {
    try {
      return employeeService.insertEmployee(request);
    } catch (Exception e) {
      log.error(
          "Happened error when insert employee : {} {}", e.getClass().getName(), e.getStackTrace());
      log.trace("{}", String.valueOf(e));
      throw e;
    }
  }

  @PostMapping(value = "/update")
  public ResponseEntity<Object> updateEmployee(@RequestBody EmployeeDtoRequest request) {
    try {
      return employeeService.updateEmployee(request);
    } catch (Exception e) {
      log.error(
          "Happened error when update employee : {} {}", e.getClass().getName(), e.getStackTrace());
      log.trace("{}", String.valueOf(e));
      throw e;
    }
  }

  @PostMapping(value = "/delete")
  public ResponseEntity<Object> deleteEmployee(@RequestBody EmployeeDtoRequest request) {
    try {
      return employeeService.deleteEmployee(request.getId());
    } catch (Exception e) {
      log.error(
          "Happened error when delete employee : {} {}", e.getClass().getName(), e.getStackTrace());
      log.trace("{}", String.valueOf(e));
      throw e;
    }
  }

  @PostMapping(value = "/detail")
  public ResponseEntity<Object> getEmployee(@RequestBody EmployeeDtoRequest request) {
    try {
      return employeeService.getEmployee(request.getNik());
    } catch (Exception e) {
      log.error(
          "Happened error when get employee with NIK: {} {}",
          e.getClass().getName(),
          e.getStackTrace());
      log.trace("{}", String.valueOf(e));
      throw e;
    }
  }
}
