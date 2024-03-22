package org.example;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OpenExcelfile {
    public static void main(String[] args) throws IOException {
            String filePath = "/home/perennial/ExcelFile/mypoi.xlsx";
            File myfile = new File(filePath);

        FileInputStream fis = null;

        fis = new FileInputStream(myfile);

        if(myfile.isFile() && myfile.exists()){
            System.out.println("File open succssfully");
        }else {
            System.out.println("File not open");
        }
        fis.close();
    }
}

