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
    
 // Step 6: Select "Direct" from the mode dropdown - https://chat.openai.com/share/cc81f5f5-e19c-4c2b-ad67-971b630336b1
     WebElement modeDropdown = driver.findElement(By.xpath("//select[@class='form-control form-control-dark ng-untouched ng-pristine ng-invalid']"));
    Select modeSelect = new Select(modeDropdown);
    modeSelect.selectByVisibleText("Direct");
    // You can also select by value if the value attribute is unique for the option
    // modeSelect.selectByValue("5e4f6bbfd691320006d415bf");

    // Step 7: Verification - Check if "Direct" is selected
    WebElement selectedOption = modeSelect.getFirstSelectedOption();
    String selectedText = selectedOption.getText();
    if (selectedText.equals("Direct")) {
        System.out.println("Mode dropdown selection successful.");
    } else {
        System.out.println("Mode dropdown selection failed.");
    }
    
    
 // Click on the "Add" button -> https://chat.openai.com/share/6f765968-7e4c-499b-b31a-a126f8c5c417
    WebElement addButton = driver.findElement(By.cssSelector("div.append-btn a"));
    addButton.click();

    // Fill in the client information
    WebElement clientNameInput = driver.findElement(By.cssSelector("input[formcontrolname='name']"));
    clientNameInput.sendKeys("Goe1");

    WebElement organizationNameInput = driver.findElement(By.cssSelector("input[formcontrolname='companyName']"));
    organizationNameInput.sendKeys("Goe1");

    WebElement emailInput = driver.findElement(By.cssSelector("input[formcontrolname='email']"));
    emailInput.sendKeys("goe1@example.com");

    WebElement contactNoInput = driver.findElement(By.cssSelector("input[formcontrolname='phoneNumber']"));
    contactNoInput.sendKeys("9155778915");

    WebElement communicationInput = driver.findElement(By.cssSelector("input[formcontrolname='skypeId']"));
    communicationInput.sendKeys("goe1_skype_id");

    // Click on the "Save Client" button
    WebElement saveButton = driver.findElement(By.xpath("//button[normalize-space()='Save Client']"));  
    saveButton.click();
    Thread.sleep(2000);
    
    
    // Wait for the selected field to be populated with the new client name
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement selectedField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Select client(s)')]")));

    // Get the text of the selected field
    String selectedFieldText = selectedField.getText();

    // Check if the selected field is not empty
    if (!selectedFieldText.isEmpty()) {
        System.out.println("Client name added successfully to the selected field.");
    } else {
        System.out.println("Client name was not added to the selected field.");
    }
    
    
 // Wait for the selected field to be populated with the new client name
    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
    WebElement selectedField1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='dropdown-btn'])[1]")));
    // Click on the dropdown to open the options list
    selectedField1.click();

    // Wait for the search field to be present
    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(50));
    WebElement searchField1 = wait2.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[aria-label='multiselect-search']")));

    // Type the client name you want to search for (e.g., "Andrew Shore")
    String searchValue = "Andrew Shore";
    searchField1.sendKeys(searchValue);

    // Wait for the option to be visible in the dropdown and select it
    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(50));
    WebElement option = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='item2']//div[contains(text(), '" + searchValue + "')]")));
    option.click();

    // Close the dropdown
    selectedField1.click();
    
 // Select "Hourly" from the project type dropdown
    WebElement projectTypeDropdown = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[3]/following::select[1]"));
    Select projectTypeSelect = new Select(projectTypeDropdown);
    projectTypeSelect.selectByVisibleText("Hourly");

    // Fill project name in field
    WebElement projectname = driver.findElement(By.xpath("(//input[@id='emp-adhaar'])[1]"));
    projectname.sendKeys("Meta-5778915");
    
//    // Click on the "Select Project Approver" dropdown to open the options list
//    WebElement selectApproverDropdown = driver.findElement(By.xpath("//span[contains(text(), 'Select Project Approver')]"));
//    selectApproverDropdown.click();
//
//    // Wait for the search field to be present
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//    WebElement searchField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[aria-label='multiselect-search']")));
//
//    // Type the name you want to search for (e.g., "manish gulati")
//    String searchValue1 = "manish gulati";
//    searchField.sendKeys(searchValue1);
//
//    // Wait for the option to be visible in the dropdown and select it using the checkbox
//    WebElement option1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class, 'multiselect-item-checkbox')]//div[contains(text(), '" + searchValue1 + "')]")));
//    WebElement checkbox = option1.findElement(By.cssSelector("input[type='checkbox']"));
//    checkbox.click();
//
//    // Close the dropdown by clicking outside (assuming clicking on the dropdown itself will close it)
//    selectApproverDropdown.click();

    
    
    
    
    
    }

    
}
	
