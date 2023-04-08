package com.mcu.student.service;

import com.mcu.student.model.StudentModel;

import java.util.List;

public interface IStudentService {
    public Integer saveStudent(StudentModel student);
    public List<StudentModel> showAll();

}
