package com.dept.assignment.week2.mvc.entities;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter //from lambok dependency
@Setter
@Entity //from data-jpa dependency
@Table(name="Department")
public class DepartmentEntity {
    @Id
    private Long id;
    private String title;
    private LocalDate createAt;
    private Boolean isActive;
    private String password;
    private Integer primeNum;

}
