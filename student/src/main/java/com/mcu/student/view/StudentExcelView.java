package com.mcu.student.view;

import com.mcu.student.model.StudentModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import java.util.List;
import java.util.Map;

public class StudentExcelView extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.addHeader("Content-Disposition", "attachment ; filename = student.xlsx");

        List<StudentModel> studentList = (List<StudentModel>) model.get("studentList");

        Sheet sheet = workbook.createSheet("Students");
        setHeader(sheet);
        setBody(sheet, studentList);
    }



    private void setHeader(Sheet sheet) {
        Row row = sheet.createRow(0);
         row.createCell(0).setCellValue("ID");
         row.createCell(1).setCellValue("First Name");
         row.createCell(2).setCellValue("Last Name");
         row.createCell(3).setCellValue("Email");
         row.createCell(4).setCellValue("Gender");
         row.createCell(5).setCellValue("Phone");

    }

    private void setBody(Sheet sheet, List<StudentModel> studentList) {
        int rowNumber = 1;
        for(StudentModel singleStudent: studentList){
            Row row = sheet.createRow(rowNumber++);
            row.createCell(0).setCellValue(singleStudent.getId());
            row.createCell(1).setCellValue(singleStudent.getFname());
            row.createCell(2).setCellValue(singleStudent.getLname());
            row.createCell(3).setCellValue(singleStudent.getEmail());
            row.createCell(4).setCellValue(singleStudent.getGender());
            row.createCell(5).setCellValue(singleStudent.getPhone());

        }

    }
}
