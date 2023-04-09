package com.mcu.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcu.student.model.StudentModel;

public class Demo {
    public static void main(String[] args) {
        StudentModel student = new StudentModel();
        student.setId(707);
        student.setFname("Mohacel");
        student.setLname("Hosen");
        student.setEmail("mohacel.hosen06@gmail.com");
        student.setGender("Male");
        student.setPhone("0194-6363-345");
        student.setPassword("740325D1");


        try{
            String testString = "{\"id\":707,\"fname\":\"Mohacel\",\"lname\":\"Hosen\",\"email\":\"mohacel.hosen06@gmail.com\",\"gender\":\"Male\",\"phone\":\"0194-6363-345\",\"password\":\"740325D1\"}";
            ObjectMapper om = new ObjectMapper();
            String json =om.writeValueAsString(student);
            System.out.println(json);

            StudentModel sampleStudent = om.readValue(testString, StudentModel.class);
            System.out.println(sampleStudent);
            System.out.println(  );
        }catch ( Exception e){
            e.printStackTrace();
        }
    }
}
