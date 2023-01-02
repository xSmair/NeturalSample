package io.github.xsmair.neturalsample.service;

import io.github.xsmair.neturalsample.exception.ResourceNotFoundException;
import io.github.xsmair.neturalsample.model.Department;
import io.github.xsmair.neturalsample.model.User;
import io.github.xsmair.neturalsample.repository.DepartmentRepository;
import io.github.xsmair.neturalsample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public UserService(UserRepository userRepository, DepartmentRepository departmentRepository) {
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User userToUpdate = getUserById(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        return userRepository.save(userToUpdate);
    }

    public void deleteUser(Long id) {
        userRepository.delete(getUserById(id));
    }

    public void addUserToDepartment(Long departmentId, Long userId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        department.getUsers().add(user);
        departmentRepository.save(department);
    }

    public void removeUserFromDepartment(Long departmentId, Long userId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        department.getUsers().remove(user);
        departmentRepository.save(department);
    }

}
