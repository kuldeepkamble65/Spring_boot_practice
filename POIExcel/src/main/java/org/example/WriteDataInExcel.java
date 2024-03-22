package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteDataInExcel {
    public static void main(String[] args) throws IOException {
            String filePath = "/home/perennial/ExcelFile/mypoi.xlsx";
            File myfile = new File(filePath);

            Workbook workbook = new XSSFWorkbook();
             Sheet sheet1= workbook.createSheet("sheet1");

        Row  row = null;
        Cell  cell = null;

        row = sheet1.createRow(3);
        cell = row.createCell(3);
        cell.setCellValue("good morning");

        row = sheet1.createRow(5);
        cell = row.createCell(5);
        cell.setCellValue("good afternoon");

        FileOutputStream fout = new FileOutputStream(myfile);
        workbook.write(fout);
        fout.close();
        System.out.println("file created");


    }
}
