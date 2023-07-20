/*https://chat.openai.com/share/ea325d92-1b3c-4250-a3a1-cf64f42bf8fe*/
/*8 min*/
package case1_ERPProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import erp_login.Case1_ErpLoginTest;

public class Case2_Createproject extends Case1_ErpLoginTest { 
	 @BeforeClass
	    public void setUpChildClass() {
	        setUp();
	    }
	
	@Test (dependsOnMethods = "login")
		public void project() throws InterruptedException {

	// Step 2: Click on the "Projects" link in the navbar menu
    WebElement projectsLink = driver.findElement(By.xpath("//a[contains(., 'Projects')]"));
    projectsLink.click();

    // Step 3: Click on the "All Projects" link to open the subfeature
    WebElement allProjectsLink = driver.findElement(By.xpath("//a[contains(., 'All Projects')]"));
    allProjectsLink.click();

    // Step 4: Verify the heading "All Projects"
    WebElement headingElement = driver.findElement(By.xpath("//h3[contains(., 'All Projects')]"));
    String headingText = headingElement.getText();
    if (headingText.equals("All Projects")) {
        System.out.println("Heading verification successful.");
    } else {
        System.out.println("Heading verification failed.");
    }

    // Step 5: Click on the heading
   Thread.sleep(3500);
    WebElement createproject = driver.findElement(By.xpath("//button[normalize-space()='Create Project']"));
    createproject.click();
    Thread.sleep(5000);
    
    
 // Select the "Direct" option from the dropdown
    WebElement modeDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
    Select dropdown = new Select(modeDropdown);
    dropdown.selectByVisibleText("Direct");
Thread.sleep(3500);
   
    }

    
}
	
