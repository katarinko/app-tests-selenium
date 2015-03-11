package com.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Date;
import jxl.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * Created by root on 04.03.15.
 */
public class simpleTest {

    Workbook workbook = Workbook.getWorkbook("testData.xls");
    Sheet sheet = workbook.getSheet(0);
    Cell a1 = sheet.getCell(0,0);
    Cell b2 = sheet.getCell(1,1);
    Cell c2 = sheet.getCell(2,1);

    String stringa1 = a1.getContents();
    String stringb2 = b2.getContents();
    String stringc2 = c2.getContents();


}


