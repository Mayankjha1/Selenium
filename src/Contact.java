
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Contact {
  public static void main(String[] args) throws InterruptedException {
   // WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("https://login.salesforce.com/");
    driver.findElement(By.id("username")).sendKeys("mayank@cloudprism.com");
    driver.findElement(By.id("password")).sendKeys("Cloudprism@1234567890");
    driver.findElement(By.id("Login")).click();

    Thread.sleep(5000);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    WebElement appLauncherButton = driver.findElement(By.xpath("//div[contains(@class, 'slds-icon-waffle')]"));
    appLauncherButton.click();
    // Wait for the App Launcher page to load
    Thread.sleep(3000);
    // Search for Accounts
    WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']"));
    searchBox.sendKeys("Contacts");
    // searchBox.sendKeys(Keys.RETURN);
    // Wait for the search results page to load
    Thread.sleep(3000);
    // Wait for the element to be clickable
    WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[2]/div[1]/div[1]/div[1]/one-app-launcher-menu/div/div[2]/one-app-launcher-menu-item[2]/a/div/lightning-formatted-rich-text/span/p/b")));
    Thread.sleep(2000);
    element2.click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    WebElement element = driver.findElement(By.linkText("New"));
    element.click();
    System.out.println("Testing");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Testing This Component");
    FluentWait<WebDriver> wait2 = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
    Thread.sleep(5000);
    WebElement searchBox1 = driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']"));
    searchBox1.click();
    Thread.sleep(5000);
    WebElement element11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul//li//lightning-base-combobox-item//span//span//span[@title='Testing This Component']")));
    element11.click();
    // Method for Scroll
    WebElement radioButton = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Lead Source, --None--']")));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);

    WebElement picklist = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Lead Source, --None--']")));
    picklist.click();
    WebElement element1 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//lightning-base-combobox-item[@data-value='Web']")));
    element1.click();
    Thread.sleep(5000);
    WebElement elementSave = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
    elementSave.click();
  }
} 
