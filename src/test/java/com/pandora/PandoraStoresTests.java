package com.pandora;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @BeforeMethod
    public void openMainPage() {
        driver.get("http://www.pandora.net/uk-ua");
    }

    @Test(priority = 1)
    public void checkStoresInKiev() {
        // Test data
        String city = "Киев";
        String[] expectedLocations = {"Pandora Київ ТРЦ \"Океан Плаза\"\nPandora Store, 1.5 km",
                "Pandora Київ ТРЦ \"Гуллівер\"\nPandora Store, 3.9 km",
                "Pandora Київ ТРЦ \"Універмаг Україна…\nPandora Store, 5.7 "
        };

        // Test steps
        goToShopsPage();
        searchForStoresInCity(city);

        // Assertions
        assertTrue(checkThatShopPresentsInList(expectedLocations[0]),
                "Shop '" + expectedLocations[0] + "' is not on the list");
        assertTrue(checkThatShopPresentsInList(expectedLocations[1]),
                "Shop '" + expectedLocations[1] + "' is not on the list");
        assertTrue(checkThatShopPresentsInList(expectedLocations[2]),
                "Shop '" + expectedLocations[2] + "' is not on the list");
    }


    @Test(priority = 2)
    public void checkNamistinki() {
        // Test data
        String itemPrice = "1 395,00 UAH";

        //Test steps
        selectNamistunkiTab();
        viewAllNamistunki();
        selectMetal("Срібло");
        selectFirsItemInList();

        // Assertions
        assertEquals(getItemPrice(), itemPrice, "Price is not correct!");
    }

    private String getItemPrice() {
        return driver.findElement(By.xpath("//div[@class='price']/p")).getText();
    }

    private void selectFirsItemInList() {
        driver.findElement(By.xpath("//div[@class]//img[@alt='Срібна намистина, куб. оксид цирконію']")).click();
    }

    private void viewAllNamistunki() {
        driver.findElement(By.xpath("//span/a[text()='Дивіться усі підвіски']")).click();
        //driver.findElement(By.cssSelector(".bullet.closePandoraDialogOther")).click();
    }

    private void selectNamistunkiTab() {
        driver.findElement(By.xpath("//span[text()='НАМИСТИНИ']")).click();
    }

    private void selectMetal(String type) {
        driver.findElement(By.xpath("//div[@id='filter-metal-dropdown']//span[@class='bullet']")).click();
        driver.findElement(By.xpath("//div[@id='filter-metal-dropdown']//a[contains(text(), '" + type + "')]")).click();
    }

    private void goToShopsPage() {
        driver.findElement(By.xpath("//span[contains(text(), 'Магазини')]")).click();
        driver.findElement(By.cssSelector(".bullet.closePandoraDialogOther")).click();
    }

    private void searchForStoresInCity(String city) {
        driver.findElement(By.id("storeAddress")).sendKeys(city);
        driver.findElement(By.xpath("//span[text()='Пошук']")).click();
    }

    private boolean checkThatShopPresentsInList(String shop) {
        List<WebElement> locations = driver.findElements(By.xpath("//div[@class='carousel-wrap']//li"));
        List<String> actualShopsList = new ArrayList<String>();

        for (WebElement l: locations) {
            actualShopsList.add(l.getText());
            if (l.getText().equals(shop)) {
                return true;
            }
        }
        System.out.println(actualShopsList.toString());
        return false;
    }
}




