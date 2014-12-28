package com.pandora;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by root on 14.12.14.
 */
public class PandoraStoresTests {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void checkStoresInKiev() {
        // Test data
        String city = "Киев";
        String[] expectedLocations = {"Pandora Київ ТРЦ \"Океан Плаза\"\nPandora Store, 1.5 km",
                "Pandora Київ ТРЦ \"Гуллівер\"\nPandora Store, 3.9 km",
                "Pandora Київ ТРЦ \"Універмаг Україна…\nPandora Store, 5.7 "
        };

        // Test steps
        driver.get("http://www.pandora.net/uk-ua");
        driver.findElement(By.linkText("МАГАЗИНИ")).click();
        driver.findElement(By.cssSelector(".bullet.closePandoraDialogOther")).click();
        driver.findElement(By.id("storeAddress")).sendKeys(city);
        driver.findElement(By.xpath("//span[text()='Пошук']")).click();

        List<WebElement> locations = driver.findElements(By.xpath("//div[@class='carousel-wrap']//li"));

        int counter = 0;
        for (WebElement l: locations) {
            //System.out.println(l.getText());
            Assert.assertEquals(l.getText(), expectedLocations[counter]);
            counter += 1;
            if (counter == 3) {
                break;
            }
        }

    }
    @Test
    public void checkNamistinki() {

        //Test steps
        driver.get("http://www.pandora.net/uk-ua");
        driver.findElement(By.xpath("//span[text()='НАМИСТИНИ']")).click();
        driver.findElement(By.xpath("//span[text()='Дивіться усі підвіски']")).click();
        driver.findElement(By.cssSelector(".bullet.closePandoraDialogOther")).click();
        selectMetal("Срібло");

    }

    private void selectMetal(String type) {
        driver.findElement(By.xpath("//div[@id='filter-metal-dropdown']//span[@class='bullet']")).click();
        driver.findElement(By.xpath("//div[@id='filter-metal-dropdown']//a[contains(text(), '" + type + "')]")).click();

    }

    private void closePandoraDialog() {


    }



}

