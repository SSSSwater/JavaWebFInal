package com.example.exelgetuser;

import com.example.basicLayout.Student;
import com.example.basicLayout.Teacher;
import com.example.jdbc.IloginDao;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class getTeacher {
    public static void getTeacher(String path) {
        try {
            FileInputStream fip = new FileInputStream(path);
            XSSFWorkbook wb = new XSSFWorkbook(fip);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row row = null;
            int n = sheet.getPhysicalNumberOfRows();
            for(int i=1;i<n;i++){
                row = sheet.getRow(i);
                int worknum = (int) row.getCell(1).getNumericCellValue();
                String name = row.getCell(2).getStringCellValue();
                String school = row.getCell(3).getStringCellValue();
                String grade = row.getCell(4).getStringCellValue();
                String subject = row.getCell(5).getStringCellValue();
                String classnum = row.getCell(6).getStringCellValue();
                String account = row.getCell(7).getStringCellValue();
                String password = row.getCell(8).getStringCellValue();
                Teacher teachers = new Teacher(worknum,name,school,grade,subject,classnum,account,password);
                ApplicationContext ac =new ClassPathXmlApplicationContext("Bean.xml");
                IloginDao logDao = ac.getBean("loginDao",IloginDao.class);
                logDao.updateTeacher(teachers);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
