package com.codeJPA.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "email_address"
        ))
public class Student {

    @Id
    @SequenceGenerator(
            name = "STUD_SEQ",
            allocationSize = 10
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "STUD_SEQ"
    )
    private Long id;
    private String firstName;
    private String lastName;
    @Column(name = "email_address",
            nullable = false)
    private String emailId;

    @Embedded
    private Guardian guardian;
}
