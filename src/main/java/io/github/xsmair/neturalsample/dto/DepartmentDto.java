package io.github.xsmair.neturalsample.dto;

import io.github.xsmair.neturalsample.model.Department;
import io.github.xsmair.neturalsample.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
public class DepartmentDto {

    private String name;

    private String description;

    private String location;

    private String phone;

    private String fax;

    private String email;

    private String street;

    private String city;

    private String state;

    private String zip;

    private String country;

    private String company;

    private String Manager;

    public static Department toEntity(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setName(departmentDto.getName());
        department.setDescription(departmentDto.getDescription());
        department.setLocation(departmentDto.getLocation());
        department.setPhone(departmentDto.getPhone());
        department.setFax(departmentDto.getFax());
        department.setEmail(departmentDto.getEmail());
        department.setStreet(departmentDto.getStreet());
        department.setCity(departmentDto.getCity());
        department.setState(departmentDto.getState());
        department.setZip(departmentDto.getZip());
        department.setCountry(departmentDto.getCountry());
        department.setCompany(departmentDto.getCompany());
        return department;
    }

    public static DepartmentDto fromEntity(Department department){
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName(department.getName());
        departmentDto.setDescription(department.getDescription());
        departmentDto.setLocation(department.getLocation());
        departmentDto.setPhone(department.getPhone());
        departmentDto.setFax(department.getFax());
        departmentDto.setEmail(department.getEmail());
        departmentDto.setStreet(department.getStreet());
        departmentDto.setCity(department.getCity());
        departmentDto.setState(department.getState());
        departmentDto.setZip(department.getZip());
        departmentDto.setCountry(department.getCountry());
        departmentDto.setCompany(department.getCompany());
        return departmentDto;
    }
}
