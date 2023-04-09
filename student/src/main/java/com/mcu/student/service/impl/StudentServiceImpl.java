package com.mcu.student.service.impl;

import com.mcu.student.exception.StudentNotFoundException;
import com.mcu.student.model.StudentModel;
import com.mcu.student.repository.StudentRepository;
import com.mcu.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository stdRepo;

    @Override
    public Integer saveStudent(StudentModel student) {
        return stdRepo.save(student).getId();
    }

    @Override
    public StudentModel getOneStudent(Integer id) {
        return stdRepo.findById(id).orElseThrow(()-> new StudentNotFoundException("Id Not Found 😵"));
    }

    @Override
    public List<StudentModel> showAll() {
        return stdRepo.findAll();
    }

    @Override
    public void deleteStudent(Integer id) {
        StudentModel studentModel = stdRepo.findById(id).orElseThrow(()-> new StudentNotFoundException("Id Not Found 😵"));
            stdRepo.delete(studentModel);
    }

    @Override
    public void updateStudent(StudentModel student) {
        stdRepo.save(student);
    }
}
