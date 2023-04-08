package com.mcu.student.service.impl;

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
    public List<StudentModel> showAll() {
        return stdRepo.findAll();
    }
}
