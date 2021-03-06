package com.yeahbutstill.sonarqube.demo.service;

import com.yeahbutstill.sonarqube.demo.domain.dao.Employee;
import com.yeahbutstill.sonarqube.demo.domain.dto.external.EmployeeDtoRequest;
import com.yeahbutstill.sonarqube.demo.repository.EmployeeRepository;
import com.yeahbutstill.sonarqube.demo.service.implementation.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@Slf4j
@SpringBootTest
public class EmployeeServiceTest {

  @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Mock private EmployeeRepository employeeRepository;

  @InjectMocks private EmployeeServiceImpl employeeService;

  @Mock private ModelMapper modelMapper;

  public Employee getEmployee() {
    return Employee.builder()
        .id(1L)
        .firstName("Dede")
        .lastName("Hamzah")
        .nik("AB1234")
        .gender("laki-laki")
        .salary(1000000L)
        .title("Programmer")
        .build();
  }

  @Test
  public void getListEmployee_expectSuccess() {
    List<Employee> employeesList = List.of(getEmployee());
    Mockito.when(employeeRepository.findAll()).thenReturn(employeesList);
    ResponseEntity<Object> responseEntity = employeeService.listEmployee();
    Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
  }

  @Test
  public void getEmployee_expectSuccess() {
    Mockito.when(employeeRepository.findByNik(any())).thenReturn(getEmployee());
    ResponseEntity<Object> response = employeeService.getEmployee(any());
    Assertions.assertEquals(200, response.getStatusCodeValue());
  }

  @Test
  public void insertEmployee_expectSuccess() {
    ResponseEntity<Object> response =
        employeeService.insertEmployee(
            EmployeeDtoRequest.builder()
                .firstName("Dede")
                .lastName("Hamzah")
                .nik("AB1234")
                .gender("laki-laki")
                .salary(1000000L)
                .title("Programmer")
                .build());
    Assertions.assertEquals(200, response.getStatusCodeValue());
    Mockito.verify(employeeRepository).save(any());
  }

  @Test
  public void updateEmployee_expectSuccess() {
    ResponseEntity<Object> response =
        employeeService.updateEmployee(
            EmployeeDtoRequest.builder()
                .id(1L)
                .firstName("Dede")
                .lastName("Hamzah")
                .nik("AB1234")
                .gender("laki-laki")
                .salary(1000000L)
                .title("Programmer")
                .build());
    Assertions.assertEquals(200, response.getStatusCodeValue());
    Mockito.verify(employeeRepository).save(any());
  }

  @Test
  public void deleteEmployee_expectSuccess() {
    Mockito.when(employeeRepository.findById(any())).thenReturn(Optional.of(getEmployee()));
    ResponseEntity<Object> response = employeeService.deleteEmployee(getEmployee().getId());
    Assertions.assertEquals(200, response.getStatusCodeValue());
    Mockito.verify(employeeRepository).delete(any());
  }

  @Test
  public void deleteEmployee_expectError() {
    Mockito.when(employeeRepository.findById(any())).thenReturn(Optional.empty());
    ResponseEntity<Object> response = employeeService.deleteEmployee(getEmployee().getId());
    Assertions.assertEquals(404, response.getStatusCodeValue());
  }

  @Test
  public void getListEmployee_expectError() {
    Mockito.when(employeeRepository.findAll()).thenReturn(new ArrayList<>());
    ResponseEntity<Object> response = employeeService.listEmployee();
    Assertions.assertEquals(404, response.getStatusCodeValue());
  }

  @Test
  public void updateEmployee_expectError() {
    ResponseEntity<Object> response =
        employeeService.updateEmployee(
            EmployeeDtoRequest.builder()
                .firstName("Dede")
                .lastName("Hamzah")
                .nik("AB1234")
                .gender("laki-laki")
                .salary(1000000L)
                .title("Programmer")
                .build());
    Assertions.assertEquals(400, response.getStatusCodeValue());
  }

  @Test
  public void insertEmployee_expectError() {
    ResponseEntity<Object> response =
        employeeService.insertEmployee(
            EmployeeDtoRequest.builder()
                .id(1L)
                .firstName("Dede")
                .lastName("Hamzah")
                .nik("AB1234")
                .gender("laki-laki")
                .salary(1000000L)
                .title("Programmer")
                .build());
    Assertions.assertEquals(400, response.getStatusCodeValue());
  }

  @Test
  public void getEmployee_expectError() {
    Mockito.when(employeeRepository.findByNik(any())).thenReturn(null);
    ResponseEntity<Object> response = employeeService.getEmployee(any());
    Assertions.assertEquals(404, response.getStatusCodeValue());
  }
}
