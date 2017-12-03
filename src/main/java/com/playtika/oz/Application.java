package com.playtika.oz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Application {

    @Test(priority = 1)
    public void useLogin() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.oz.by/");
        driver.findElement(By.xpath("//span[@class='top-panel__userbar__auth__lbl']")).click();
        driver.findElement(By.id("loginFormLoginEmailLink")).click();
        driver.findElement(By.name("cl_email")).sendKeys("val.pupok@bk.ru");
        driver.findElement(By.name("cl_psw")).sendKeys("y5Rcz8");
        driver.findElement(By.xpath("//button[contains(@class, 'i-popup__form-button')]")).click();
        String userName = driver.findElement(By.xpath("//span[@class='top-panel__userbar__user__name__inner']")).getText();
        Assert.assertEquals(userName, "Вал Пупок");
        driver.quit();
    }

    @Test(priority = 2)
    public void bookChoose() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.oz.by/");
        driver.findElement(By.xpath("//li[@class='main-nav__list__li main-nav__list__li_wnav']/a[@class='main-nav__list__item ']")).click();
        driver.findElement(By.className("offers-slider__item__btn")).click();
        driver.findElement(By.xpath("//a[@href='/books/more102199.html']")).click();
        driver.findElement(By.xpath("//button[@class='b-product-control__button i-button i-button_large i-button_orange addtocart-btn first-button']")).click();
        driver.findElement(By.xpath("//a[@href='/checkout/']")).click();
        String itemName = driver.findElement(By.xpath("//div[@class='goods-table-cell__link']/a[@href='https://oz.by/books/more102199.html']")).getText();
        Assert.assertEquals(itemName, "Оно");
        driver.quit();

    }

    //Just for training case: User search book via serch panel
    @Test(priority = 3)
    public void serchItem() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.oz.by/");
        driver.findElement(By.id("top-s")).sendKeys("java");
        driver.findElement(By.className("top-panel__search__btn")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'more1054381')]")).click();
        String serchName = driver.findElement(By.xpath("//h1[@itemprop='name']")).getText();
        Assert.assertEquals(serchName, "Java 8. Руководство для начинающих");
        driver.quit();
    }
}

