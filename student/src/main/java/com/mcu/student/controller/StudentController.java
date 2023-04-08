package com.mcu.student.controller;

import com.mcu.student.model.StudentModel;
import com.mcu.student.service.IStudentService;
import com.mcu.student.view.StudentExcelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService service;
    @GetMapping("/register")
    public String showRegister(){
        return "StudentRegister";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute StudentModel studentModel, Model model){
        Integer id = service.saveStudent(studentModel);
        String message = String.format("Registration %d successfully", id);
        model.addAttribute("msg",message );
        return "StudentRegister";
    }

    @GetMapping("/all")
    public String showAll(Model model){
        List<StudentModel> studentModelList = service.showAll();
        model.addAttribute("studentModelList", studentModelList);
        return "StudentTab";
    }

    @GetMapping("/excel")
    public ModelAndView exportToExcel(){
        ModelAndView m = new ModelAndView();
        m.setView( new StudentExcelView());

        //fetch data from db
        List<StudentModel> studentList = service.showAll();
        // send data to view class
        m.addObject("studentList",studentList);
        return m;
    }

}
