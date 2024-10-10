package com.codingvisit.ems.mapper;

import com.codingvisit.ems.dto.EmployeeDto;
import com.codingvisit.ems.entity.Employee;
import lombok.*;
import org.springframework.stereotype.Component;



@Component
public class EmployeeMapper {

    public  static EmployeeDto entityToEmployeeDto(Employee employee) {

        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()

        ) ;
    }

    public  static Employee dtoToEmployee(EmployeeDto employeeDto) {

        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()

        ) ;
    }


}
