package com.codingvisit.ems.controller;

import com.codingvisit.ems.dto.EmployeeDto;
import com.codingvisit.ems.service.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
@Tag(name = "EmployeeController", description = "REST APIs related to perform Employee")

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //build Add Employee rest api
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody  EmployeeDto employeeDto) {
        EmployeeDto savedEmployee =employeeService.createEmployee(employeeDto) ;
        return  new ResponseEntity<>(employeeDto, HttpStatus.CREATED) ;

    }

    //build get employee by  employeeId
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> getByEmployeeId(@PathVariable Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId) ;
        return new ResponseEntity<>(employeeDto , HttpStatus.OK)  ;
    }

    //build get all  employee
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        return new ResponseEntity<>( employeeService.getAllEmployees(), HttpStatus.OK);
    }

    //update employee by id
    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1= employeeService.updateEmployee(employeeId, employeeDto) ;
        return  new ResponseEntity<>(employeeDto, HttpStatus.OK) ;
    }

    //delete employee
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId){
         employeeService.deleteEmployee(employeeId);
         return new ResponseEntity<>("employee deleted successfully" , HttpStatus.OK) ;
    }


}
