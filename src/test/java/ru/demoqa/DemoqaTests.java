package ru.demoqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Configuration.browser;

public class DemoqaTests {

    private WebDriver webDriver;

    @BeforeEach
    public void setUp(){

        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }else if(browser.equals("opera")) {
            WebDriverManager.operadriver().setup();
            webDriver = new OperaDriver();
        }
        webDriver.get("https://demoqa.com/automation-practice-form");
        webDriver.manage().window().maximize();


    }

    @Test
    public void fillForm() throws InterruptedException {
        webDriver.findElement(By.id("firstName"))
                .sendKeys("Иванов");
        webDriver.findElement(By.id("lastName"))
                .sendKeys("Иван");
        webDriver.findElement(By.id("userEmail"))
                .sendKeys("IvanovIvan123@mail.ru");
        webDriver.findElement(By.cssSelector("#genterWrapper div div:nth-child(1)")).click();
        webDriver.findElement(By.id("userNumber"))
                .sendKeys("9519519519");
        webDriver.findElement(By.id("dateOfBirthInput"))
                .clear();
        webDriver.findElement(By.id("dateOfBirthInput"))
                .sendKeys("12.05.1997");




        Thread.sleep(2000);



    }


    @AfterEach
    public void tearDown(){
        webDriver.quit();
  }

}
