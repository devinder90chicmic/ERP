/*https://chat.openai.com/share/6bc30859-2443-4f61-b0c2-92bdae63e4ec*/
/*5 min*/

package erp_login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Case1_ErpLoginTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Window system file location
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

        // mac system file location
        // System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        
        // Create a new instance of ChromeDriver if it's not already initialized
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }

    @Test
    public void login() {
        driver.get("https://d20omqbtwm8stm.cloudfront.net/auth/login");
        
        // Find the input elements for Employee ID and password
        WebElement employeeIdInput = driver.findElement(By.cssSelector("input[formcontrolname='email']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("input[formcontrolname='password']"));
        
        // Find the "Sign in" button
        WebElement signInButton = driver.findElement(By.cssSelector("button.btn-primary"));

        // Fill in the Employee ID and password
        employeeIdInput.sendKeys("CHM/2018/191");
        passwordInput.sendKeys("123456");

        // Click on the "Sign in" button
        signInButton.click();

        // Wait for a while to see the result (you might need to add explicit waits depending on your application)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
         //   driver.quit();
        }
    }
}
