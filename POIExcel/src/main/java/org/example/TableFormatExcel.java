package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TableFormatExcel {
    public static void main(String[] args) throws IOException {

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet1 = workbook.createSheet("sheet1234");

        String [][] tableData = {{"No","firstName","LastName"},{"1","kuldeep","kamble"},{"2","vaibhav","Bokade"},{"3","omkar","andhare"},{"4","shubham","rote"}};
        Row row = null;
        Cell cell= null;

        int rowPosition = 0;
        int colPositon = 0;

        for(int i=0; i<tableData.length;i++){
            row = sheet1.createRow(i+rowPosition);
            for(int j=0; j<tableData[0].length;j++ )
            {
                cell = row.createCell(j+colPositon);
                
                cell.setCellValue(tableData[i][j]);
            }
        }


        FileOutputStream fout = new FileOutputStream("/home/perennial/ExcelFile/Transaction.xlsx");
        workbook.write(fout);
        fout.close();
        System.out.println("file created");
    }
}
