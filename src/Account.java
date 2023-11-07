// This is the Scripts that open salesforce and create a Account record using this Script


import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;



public class Account {
    public static void main(String[] args) throws InterruptedException {
      //  System.setProperty(WebDriver.chrome.driver,"/Users/mayankjha/Documents/Programming/Testing/test/src/main/java/com/Selenium/src/Driver/chromedriver");
       // WebDriverInfo.chromedriver().setup("/Users/mayankjha/Documents/Programming/Testing/test/src/main/java/com/Selenium/src/Driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        // This will redirect to this link
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("mayank@cloudprism.com");
        driver.findElement(By.id("password")).sendKeys("Cloudprism@1234567890");
        driver.findElement(By.id("Login")).click();
        // Redirect to the Account
        driver.get("https://cloudprism43-dev-ed.lightning.force.com/001");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element = driver.findElement(By.linkText("New"));
        element.click();
        
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Testing This Component");

        FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class); 
        try {
            WebElement picklist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Rating, --None--']")));
            picklist.click();
            WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//lightning-base-combobox-item[@data-value='Hot']")));
            element1.click();
            Thread.sleep(5000);
            WebElement elementSave = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
            elementSave.click();
        }
         catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());

        }
        System.out.println("Success");
        Thread.sleep(5000);
    }}
