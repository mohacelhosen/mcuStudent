package com.mcu.student.service;

import com.mcu.student.model.StudentModel;

import java.util.List;

public interface IStudentService {
    public Integer saveStudent(StudentModel student);
    public StudentModel getOneStudent(Integer id);
    public List<StudentModel> showAll();
    public void deleteStudent(Integer id);
    public void updateStudent(StudentModel student);

}
