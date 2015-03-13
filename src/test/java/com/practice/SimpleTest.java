package com.practice;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* public class SimpleTest {

    public static void main(String[] args)throws IOException, BiffException {

        SimpleTest.ExcelFile("/home/kate/Documents/testData.xls");
    }

     public static void ExcelFile(String path) throws IOException, BiffException {

         Workbook workbook = Workbook.getWorkbook(new java.io.File("/home/kate/Documents/testData.xls"));

         Sheet sheet = workbook.getSheet(0);
            Cell b1 = sheet.getCell(0, 0);
            Cell b2 = sheet.getCell(0, 1);
            Cell c1 = sheet.getCell(2, 0);

            String stringa1 = b1.getContents();
            String stringb2 = b2.getContents();
            String stringc2 = c1.getContents();

         System.out.println(stringa1);
         System.out.println(stringb2);
         System.out.println(c1);
        }

    }
*/

public class SimpleTest {

    public static void main(String[] args) {

        try {

        FileInputStream file = new FileInputStream(new File("/home/kate/Documents/testData.xls"));
        HSSFWorkbook workbook = new HSSFWorkbook(file);

        HSSFSheet sheet = workbook.getSheetAt(0);

        String heading = sheet.getRow(0).getCell(0).getStringCellValue();

        String searchText1 = sheet.getRow(1).getCell(0).getStringCellValue();

        String searchText2 = sheet.getRow(2).getCell(0).getStringCellValue();

        System.out.println("Heading is:" + heading);

        System.out.println("Search Text 1 is:" + searchText1);

        System.out.println("Search Text 2 is:" + searchText2);

        file.close();

    } catch (FileNotFoundException fnfe) {
        fnfe.printStackTrace();
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
}
}
