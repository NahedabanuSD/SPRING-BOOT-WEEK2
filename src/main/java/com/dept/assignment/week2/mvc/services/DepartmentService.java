package com.dept.assignment.week2.mvc.services;

import com.dept.assignment.week2.mvc.dto.DepartmentDTO;
import com.dept.assignment.week2.mvc.entities.DepartmentEntity;
import com.dept.assignment.week2.mvc.exceptions.ResourceNotFoundException;
import com.dept.assignment.week2.mvc.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.dynamic.DynamicType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final ModelMapper modelMapper;
    private final DepartmentRepository departmentRepository;

    public DepartmentService(ModelMapper modelMapper, DepartmentRepository departmentRepository) {
        this.modelMapper = modelMapper;
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departmentEntities=departmentRepository.findAll();
        return departmentEntities
                .stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<DepartmentDTO> getDepartmentById(Long departmentId) {
        Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(departmentId);
        return departmentEntity
                .map(departmentEntity1->modelMapper.map(departmentEntity1, DepartmentDTO.class));
    }

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
       DepartmentEntity departmentEntity=modelMapper.map(departmentDTO, DepartmentEntity.class);
       DepartmentEntity saveDepartmentEntity=departmentRepository.save(departmentEntity);
       return modelMapper.map(saveDepartmentEntity, DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartmentById(DepartmentDTO departmentDTO, Long departmentId) {
        isExistDepartmentById(departmentId);
        DepartmentEntity departmentEntity=modelMapper.map(departmentDTO, DepartmentEntity.class);
       departmentEntity.setId(departmentId);
        DepartmentEntity updatedEntity=departmentRepository.save(departmentEntity);
        return modelMapper.map(updatedEntity, DepartmentDTO.class);
    }

    private void isExistDepartmentById(Long departmentId){
        boolean exists=departmentRepository.existsById(departmentId);
        if(!exists)throw  new ResourceNotFoundException("Department not found with id"+departmentId);
    }

    public boolean deleteDepartmentById(Long departmentId) {
         isExistDepartmentById(departmentId);
         departmentRepository.deleteById(departmentId);
         return true;


    }
}
