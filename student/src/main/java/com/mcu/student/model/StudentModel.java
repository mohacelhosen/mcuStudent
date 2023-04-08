package com.mcu.student.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student_tab")
public class StudentModel {
    @Id
    @GeneratedValue
    @Column(name = "student_id_col")
    private Integer id;
    @Column(name = "student_fname_col")
    private String fname;
    @Column(name = "student_lname_col")
    private String lname;
    @Column(name = "student_email_col")
    private String email;
    @Column(name = "student_gender_col")
    private String gender;
    @Column(name = "student_phone_col")
    private String phone;
    @Column(name = "student_password_col")
    private String password;

}
