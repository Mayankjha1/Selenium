// This is the Script to Open Chrome and search for a Video and exit from chrome


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");
        driver.manage().window().setSize(new Dimension(1440, 814));
        driver.findElement(By.name("search_query")).click();
        driver.findElement(By.name("search_query")).sendKeys("How to start a youtube channel");
        driver.findElement(By.name("search_query")).sendKeys(Keys.ENTER); 
   
        Thread.sleep(5000);
          driver.findElement(By.cssSelector(".ytd-item-section-renderer:nth-child(1) > #dismissible #video-title > .style-scope:nth-child(2)")).click();
          Thread.sleep(12000);
          driver.findElement(By.cssSelector(".ytp-fullscreen-button")).click();
          driver.findElement(By.cssSelector(".ytp-fullscreen-button")).click();
          Thread.sleep(17000);
          driver.close();
    }
}