package com.codeJPA.repository;

import com.codeJPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student findByEmailId(String emailId);

    @Query("select s from Student s where s.emailId = ?1")
    public Student findByEmailIdJPQL(String emailId);

    @Query(value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true)
    public Student findByEmailIdNQuery(String emailId);
}
