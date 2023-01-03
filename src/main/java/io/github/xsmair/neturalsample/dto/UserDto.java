package io.github.xsmair.neturalsample.dto;

import io.github.xsmair.neturalsample.model.Department;
import io.github.xsmair.neturalsample.model.Job;
import io.github.xsmair.neturalsample.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String name;

    private String email;

    private String password;

    private String phone;

    private String street;

    private String city;

    private String state;

    private String zip;

    private String country;

    private String company;

    private String title;

    private String department;

    private String manager;

    private String job;

    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        user.setStreet(userDto.getStreet());
        user.setCity(userDto.getCity());
        return user;
    }

    public static UserDto fromEntity(User user){
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setPhone(user.getPhone());
        userDto.setStreet(user.getStreet());
        userDto.setCity(user.getCity());
        userDto.setDepartment(user.getDepartment().getName());
        userDto.setJob(user.getJob().getName());
        userDto.setManager(user.getManager().getName());
        return userDto;
    }
}
