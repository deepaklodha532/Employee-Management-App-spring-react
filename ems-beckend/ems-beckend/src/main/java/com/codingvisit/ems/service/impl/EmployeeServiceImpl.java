package com.codingvisit.ems.service.impl;

import com.codingvisit.ems.dto.EmployeeDto;
import com.codingvisit.ems.entity.Employee;
import com.codingvisit.ems.exception.ResourceNotFooundException;
import com.codingvisit.ems.mapper.EmployeeMapper;
import com.codingvisit.ems.repository.EmployeeRepository;
import com.codingvisit.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper mapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = mapper.dtoToEmployee(employeeDto) ;
        Employee savedEmployee=   employeeRepository.save(employee) ;
        return mapper.entityToEmployeeDto(savedEmployee) ;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee=  employeeRepository
                .findById(employeeId)
                .orElseThrow(()-> new ResourceNotFooundException("employee not found given id " +employeeId)) ;

        EmployeeDto employeeDto = mapper.entityToEmployeeDto(employee)  ;
        return employeeDto;

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = employees.stream().map(employee -> mapper.entityToEmployeeDto(employee)).collect(Collectors.toList());
        return employeeDtos ;
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee employee =   employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFooundException("Employee is not found given  id "));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail()) ;
        Employee savedEmployee = employeeRepository.save(employee) ;
        return mapper.entityToEmployeeDto(savedEmployee) ;
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFooundException("employee not found given id "));
        employeeRepository.delete(employee) ;

    }
}
