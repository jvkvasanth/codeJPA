package com.codeJPA.repository;

import com.codeJPA.entity.Guardian;
import com.codeJPA.entity.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        System.out.println("setup");
    }

    @AfterEach
    void tearDown() {
        System.out.println("teardown");
    }

    @Test
    public void saveStudentTest() {

        Guardian guardian = Guardian.builder()
                .name("Jagannathan")
                .email("Jagannathan@gmail.com")
                .mobileNo("9176630544").build();

        Student student = Student.builder()
                .firstName("Vasanthakumar")
                .lastName("Jagannathan")
                .emailId("vasanth3@gmail.com")
                .guardian(guardian).build();

        studentRepository.save(student);
        Long id = Long.valueOf(1);
        Optional<Student> student1 = studentRepository.findById(id);
        Assertions.assertEquals(student.getFirstName(), student1.get().getFirstName());
    }

    @Test
    public void getStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println("All the students ->" + students);
    }

    @Test
    public void getStudentsByEmailId() {
       Student students = studentRepository.findByEmailId("vasanth3@gmail.com");
        System.out.println("All the students ->" + students);
    }

    @Test
    public void getByEmailIdJPQL() {
        Student students = studentRepository.findByEmailIdJPQL("vasanth3@gmail.com");
        System.out.println("All the students ->" + students);
    }

    @Test
    public void getByEmailIdNQuery() {
        Student students = studentRepository.findByEmailIdNQuery("vasanth3@gmail.com");
        System.out.println("All the students ->" + students);
    }
}