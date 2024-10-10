package com.codingvisit.ems.dto;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class EmployeeDto {

    private long id ;
//    @Size(min = 3, max = 20, message = "Invalid Name !!")
    private String firstName;

    private String lastName ;

//    @Pattern(regexp = "^[a-z0-9][-a-z0-9._]+@([-a-z0-9]+\\.)+[a-z]{2,5}$", message= "Invalid User Email !!")
//    @NotBlank(message = "Email is required !!")
    private String email ;
}
