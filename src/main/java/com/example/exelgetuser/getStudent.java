package com.example.exelgetuser;

import com.example.basicLayout.Student;
import com.example.jdbc.IloginDao;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class getStudent {
    public static void getStudent(String path) {
        try {
            FileInputStream fip = new FileInputStream(path);
            XSSFWorkbook wb = new XSSFWorkbook(fip);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row row = null;
            int n = sheet.getPhysicalNumberOfRows();
            for(int i=1;i<n;i++){
                row = sheet.getRow(i);
                int id = (int) row.getCell(1).getNumericCellValue();
                String name = row.getCell(2).getStringCellValue();
                String classnum = row.getCell(3).getStringCellValue();
                String school = row.getCell(4).getStringCellValue();
                String account = row.getCell(5).getStringCellValue();
                String password = row.getCell(6).getStringCellValue();
                Student students = new Student(id,name,classnum,school,account,password);
                ApplicationContext ac =new ClassPathXmlApplicationContext("Bean.xml");
                IloginDao logDao = ac.getBean("loginDao",IloginDao.class);
                logDao.updateStudent(students);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
