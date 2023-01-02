package io.github.xsmair.neturalsample.repository;

import io.github.xsmair.neturalsample.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    //List<Department> findByNameContainingOrLocationContaining(String searchTerm);
    Iterable<Department> findByNameContainingOrLocationContaining(String name, String location);
}
