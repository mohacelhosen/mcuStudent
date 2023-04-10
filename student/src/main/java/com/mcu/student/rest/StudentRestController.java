package com.mcu.student.rest;

import com.mcu.student.model.StudentModel;
import com.mcu.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/student")
public class StudentRestController {

    @Autowired
    private IStudentService service;

    //1. Fetch all data
    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<StudentModel> list= service.showAll();

        ResponseEntity<?> response = null;
        try{
             response = new ResponseEntity<List<StudentModel>>(list, HttpStatus.OK);

        }catch (Exception e){
            response = new ResponseEntity<String>("Unable to Fetch Student Data", HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }

        return response;
    }

    //2. Insert Data
    @PostMapping("/save")
    public ResponseEntity<String> addOneStudent(@RequestBody StudentModel student){
        ResponseEntity<String> response = null;
        try{
            Integer id = service.saveStudent(student);
            String message = String.format("Student %d is save successfully",id);
            response = new ResponseEntity<String>(message, HttpStatus.OK);

        }catch (Exception e){
            response = new ResponseEntity<String>("Unable to save", HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return response;
    }

    //3. Update Data

    //4. Fetch single row data

    //5. Delete single row data

}
