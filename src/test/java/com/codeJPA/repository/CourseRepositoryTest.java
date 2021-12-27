package com.codeJPA.repository;

import com.codeJPA.entity.Course;
import com.codeJPA.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourse() {
        Course course = Course.builder()
                .title("Test")
                .credit(1).build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("test://URL")
                .course(course).build();

        courseMaterialRepository.save(courseMaterial);

        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }

}