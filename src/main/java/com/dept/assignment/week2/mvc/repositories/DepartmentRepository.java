package com.dept.assignment.week2.mvc.repositories;

import com.dept.assignment.week2.mvc.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository <DepartmentEntity,Long>{
    //jpa Repository
}
