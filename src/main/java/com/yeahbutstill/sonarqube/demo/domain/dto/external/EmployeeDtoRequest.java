package com.yeahbutstill.sonarqube.demo.domain.dto.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yeahbutstill.sonarqube.demo.domain.dao.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDtoRequest {

  private Long id;
  private String nik;
  private String firstName;
  private String lastName;
  private String gender;
  private Long salary;
  private String title;
  private List<Project> memberProject = new ArrayList<>();
}
