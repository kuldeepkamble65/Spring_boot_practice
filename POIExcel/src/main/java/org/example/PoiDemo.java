package org.example;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PoiDemo {
    public static void main(String[] args) throws IOException {
        String filePath = "/home/perennial/ExcelFile/mypoi.xlsx";
        File myfile = new File(filePath);
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet1 = workbook.createSheet("sheet123");

        FileOutputStream fout = new FileOutputStream(myfile);
        workbook.write(fout);
        fout.close();
        System.out.println("file created");
    }
}
