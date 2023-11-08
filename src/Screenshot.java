// This is the code/Script to take Screenshots....

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        com.google.common.io.Files.copy(scrFile, new File("Screenshot1.png"));       
        driver.quit();   
    }
}
