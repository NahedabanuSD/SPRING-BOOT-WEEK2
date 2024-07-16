package com.dept.assignment.week2.mvc.controllers;

import com.dept.assignment.week2.mvc.dto.DepartmentDTO;
import com.dept.assignment.week2.mvc.exceptions.ResourceNotFoundException;
import com.dept.assignment.week2.mvc.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }
    @GetMapping(path={"/{departmentId}"})
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long departmentId ) throws Exception {
        //return ResponseEntity.ok(departmentService.getDepartmentById(departmentId));
        Optional<DepartmentDTO> departmentDTO=departmentService.getDepartmentById(departmentId);
        return departmentDTO.map(departmentDTO1 -> ResponseEntity.ok(departmentDTO1)).orElseThrow(
                ()->new ResourceNotFoundException("Department not found with id"+departmentId));
    }
    @PostMapping()
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody  @Valid DepartmentDTO departmentDTO)
    {
        return ResponseEntity.ok(departmentService.createDepartment(departmentDTO));
    }
    @PutMapping(path="/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@RequestBody @Valid DepartmentDTO departmentDTO,@PathVariable Long departmentId )
    {
        return ResponseEntity.ok(departmentService.updateDepartmentById(departmentDTO, departmentId));
    }

    @DeleteMapping(path="/{departmentId}")
    public ResponseEntity<Boolean> deleteDepaartmentById(@PathVariable Long departmentId )
    {
        boolean deleted=departmentService.deleteDepartmentById(departmentId);
        if(deleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }
}
