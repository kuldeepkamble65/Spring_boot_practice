package org.example;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataInExcel {
    public static void main(String[] args) throws IOException {
        String filePath = "/home/perennial/ExcelFile/mypoi.xlsx";
        File myfile = new File(filePath);
        FileInputStream fis = new FileInputStream(myfile);
        Workbook workbook = new XSSFWorkbook(filePath);
        Sheet sheet = workbook.getSheetAt(0);

        String cellvalue = sheet.getRow(3).getCell(2).getStringCellValue();
        System.out.println(cellvalue);
        workbook.close();
        fis.close();
    }
}
