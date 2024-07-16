package com.dept.assignment.week2.mvc.dto;

import com.dept.assignment.week2.mvc.annotations.PasswordValidation;
import com.dept.assignment.week2.mvc.annotations.PrimeValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private Long id;
    @NotBlank(message="Name of the department cannot be blank")
    @Size(min =4, max = 20,message = "Number of characters in title should be in the range: [3, 10]")
    private String title;
    @PastOrPresent(message = "createAt field cannot be future")
    private LocalDate createAt;
    @AssertTrue(message = "Department should be active")
    private Boolean isActive;
    @PasswordValidation
    private String password;
    @PrimeValidation
    private Integer primeNum;
}
