package io.github.xsmair.neturalsample.controller;

import io.github.xsmair.neturalsample.model.User;
import io.github.xsmair.neturalsample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/{id}/departments")
    public void addUserToDepartment(@PathVariable Long id, @RequestBody Long departmentId) {
        userService.addUserToDepartment(id, departmentId);
    }

    @DeleteMapping("/{id}/departments")
    public void removeUserFromDepartment(@PathVariable Long id, @RequestBody Long departmentId) {
        userService.removeUserFromDepartment(id, departmentId);
    }
}

