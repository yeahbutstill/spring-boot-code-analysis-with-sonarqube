package com.yeahbutstill.sonarqube.demo.repository;

import com.yeahbutstill.sonarqube.demo.domain.dao.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

  Project findByProjectCode(String projectCode);
}
