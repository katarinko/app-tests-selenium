package com.appassure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by cats on 30.11.14.
 */
public class FirstTest {

    @Test
    public void checkLoginWithValidCredentials() {



        // Test data
        //String email = "ekaterina.blekher@softheme.com";
        //String pass = "kohana123";

        // Test steps
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://administrator:123asdQ@10.10.3.229:8006/apprecovery/admin");
        //driver.findElement(By.xpath("//button[contains(@class, 'fr')]")).click();
        //driver.get("https://administrator:123asdQ@10.10.3.229:8006/apprecovery/admin/ProtectedMachines");
        driver.findElement(By.className("ui-item-panel-title")).click();
        //driver.findElement(By.xpath("//span[text()='Recovery Points']")).click();
        //driver.findElement(By.cssSelector(".dxGridView_gvDetailCollapsedButton_ReplayAdmin")).click();

        //driver.findElement(By.xpath("//span[text()='Мои Друзья']")


        // Assertion
        //assertTrue(driver.findElement(By.cssSelector(".gb_e.gb_f")).getText().equals("+Ekaterina"));
        //driver.quit();
    }
}
