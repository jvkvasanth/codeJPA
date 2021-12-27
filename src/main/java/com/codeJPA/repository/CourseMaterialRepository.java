package com.codeJPA.repository;

import com.codeJPA.entity.Course;
import com.codeJPA.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {


}
