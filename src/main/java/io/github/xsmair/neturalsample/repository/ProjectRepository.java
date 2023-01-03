package io.github.xsmair.neturalsample.repository;

import io.github.xsmair.neturalsample.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
