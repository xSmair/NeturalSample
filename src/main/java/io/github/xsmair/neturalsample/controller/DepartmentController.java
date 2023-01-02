package io.github.xsmair.neturalsample.controller;

import io.github.xsmair.neturalsample.model.Department;
import io.github.xsmair.neturalsample.model.User;
import io.github.xsmair.neturalsample.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }

    @GetMapping("search")
    public List<Department> searchDepartments(String searchTerm) {
        return departmentService.findByNameContainingOrLocationContaining(searchTerm);
    }

    @GetMapping("/{id}/users")
    public List<User> getDepartmentUsers(Long id) {
        return departmentService.getUsersInDepartment(id);
    }

    @GetMapping("/{id}/manager")
    public User getDepartmentManager(Long id) {
        return departmentService.getManagerOfDepartment(id);
    }

    @PutMapping("/{id}/manager")
    public ResponseEntity<?> setDepartmentManager(Long id, Long userId) {
        departmentService.updateManagerOfDepartment(id, userId);
        return ResponseEntity.ok().build();
    }
}