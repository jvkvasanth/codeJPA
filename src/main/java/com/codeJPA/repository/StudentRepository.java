package com.codeJPA.repository;

import com.codeJPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student findByEmailId(String emailId);

    @Query("select s from Student s where s.emailId = ?1")
    public Student findByEmailIdJPQL(String emailId);

    @Query(value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true)
    public Student findByEmailIdNQuery(String emailId);

    @Query(value = "select * from tbl_student s where s.email_address = :email",
            nativeQuery = true)
    public Student findByEmailIdNQuerybyNamedParam(@Param("email") String emailId);

    @Transactional
    @Modifying
    @Query(value = "update tbl_student s set s.first_name = :name where s.email_address = :email",
            nativeQuery = true)
    public int updateNameByEmailId(@Param("name") String name,@Param("email") String emailId);
}
