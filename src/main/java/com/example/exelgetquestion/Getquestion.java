package com.example.exelgetquestion;

import com.example.jdbc.IQuestionDao;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Getquestion {
    public static void getQuestion(String path) {
        try {
            FileInputStream fip = new FileInputStream(path);
            XSSFWorkbook wb = new XSSFWorkbook(fip);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row row = null;
            int n = sheet.getPhysicalNumberOfRows();
            for(int i=1;i<n;i++){
                String choiceA;
                String choiceB;
                String choiceC;
                String choiceD;
                String analysis;
                row = sheet.getRow(i);
                String subject = row.getCell(1).getStringCellValue();
                String type = row.getCell(2).getStringCellValue();
                String title = row.getCell(3).getStringCellValue();
                if(row.getCell(4) == null) {
                    choiceA = "";
                }else{
                    choiceA = row.getCell(4).getStringCellValue();
                }
                if(row.getCell(5) == null) {
                    choiceB = "";
                }else{
                    choiceB = row.getCell(5).getStringCellValue();
                }
                if(row.getCell(6) == null) {
                    choiceC = "";
                }else{
                    choiceC = row.getCell(6).getStringCellValue();
                }
                if(row.getCell(7) == null) {
                    choiceD = "";
                }else{
                    choiceD = row.getCell(7).getStringCellValue();
                }
                String answer = row.getCell(8).getStringCellValue();
                String analysisEnabled = row.getCell(9).getStringCellValue();
                if(row.getCell(10) == null) {
                    analysis = "";
                }else{
                    analysis = row.getCell(10).getStringCellValue();
                }
                Question question = new Question(subject,type,title,choiceA,choiceB,choiceC,choiceD,answer,analysisEnabled,analysis);
                ApplicationContext ac =new ClassPathXmlApplicationContext("Bean.xml");
                IQuestionDao questionDao =ac.getBean("questionDao",IQuestionDao.class);
                questionDao.updateQuestion(question);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "D:\\test\\question.xlsx";
        getQuestion(path);
    }
}
