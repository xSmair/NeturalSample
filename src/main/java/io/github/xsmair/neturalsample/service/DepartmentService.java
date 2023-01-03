package io.github.xsmair.neturalsample.service;

import io.github.xsmair.neturalsample.exception.ResourceNotFoundException;
import io.github.xsmair.neturalsample.model.Department;
import io.github.xsmair.neturalsample.model.User;
import io.github.xsmair.neturalsample.repository.DepartmentRepository;
import io.github.xsmair.neturalsample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DepartmentService {
//This comment is just for testing
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, UserRepository userRepository) {
        this.departmentRepository = departmentRepository;
        this.userRepository = userRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department department) {
        Department departmentToUpdate = getDepartmentById(id);
        departmentToUpdate.setName(department.getName());
        departmentToUpdate.setDescription(department.getDescription());
        departmentToUpdate.setLocation(department.getLocation());
        departmentToUpdate.setPhone(department.getPhone());
        departmentToUpdate.setFax(department.getFax());
        departmentToUpdate.setEmail(department.getEmail());
        departmentToUpdate.setStreet(department.getStreet());
        departmentToUpdate.setCity(department.getCity());
        departmentToUpdate.setState(department.getState());
        departmentToUpdate.setZip(department.getZip());
        departmentToUpdate.setCountry(department.getCountry());
        departmentToUpdate.setCompany(department.getCompany());
        departmentToUpdate.setManager(department.getManager());
        return departmentRepository.save(departmentToUpdate);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.delete(getDepartmentById(id));
    }

    public List<Department> findByNameContainingOrLocationContaining(String searchTerm) {
        return StreamSupport.stream(
        departmentRepository.findByNameContainingOrLocationContaining(searchTerm,searchTerm).spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<User> getUsersInDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));
        return department.getUsers();
    }

    public User getManagerOfDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));
        return department.getManager();
    }

    public void updateManagerOfDepartment(Long departmentId, Long managerId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));
        User manager = userRepository.findById(managerId).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + managerId));
        department.setManager(manager);
        departmentRepository.save(department);
    }

}
