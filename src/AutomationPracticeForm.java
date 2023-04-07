// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutomationPracticeForm {
    public static void main(String[] args) {
        // Set system property for ChromeDriver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Vlad\\Documents\\geckodriver.exe");

        // Instantiate a ChromeDriver object
        WebDriver driver = new FirefoxDriver();

        // Navigate to the website
        driver.get("https://demoqa.com/automation-practice-form");

        // Find and fill the Name field
        WebElement nameField = driver.findElement(By.id("firstName"));
        nameField.sendKeys("John");
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys("Doe");

        // Find and fill the Email field
        WebElement emailField = driver.findElement(By.id("userEmail"));
        emailField.sendKeys("test@test.test");

        // Find and select the Male radio button for Gender
//        WebElement maleRadioButton = driver.findElement(By.id("gender-radio-1"));
//        maleRadioButton.click();

        // Find and fill the Mobile field
        WebElement mobileField = driver.findElement(By.id("userNumber"));
        mobileField.sendKeys("123456789");

        // Find and select the Date of Birth field and enter a date
        WebElement dateOfBirthField = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthField.click();
        WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
        monthDropdown.sendKeys("January");
        WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
        yearDropdown.sendKeys("1980");
        WebElement dateOfMonth = driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--001']"));
        dateOfMonth.click();

        // Find and select the Automation Testing Modules checkbox for Subjects
        WebElement automationTestingModulesCheckbox = driver.findElement(By.xpath("//label[text()='Automation Testing']"));
        automationTestingModulesCheckbox.click();

        // Find and fill the Current Address field
        WebElement currentAddressField = driver.findElement(By.id("currentAddress"));
        currentAddressField.sendKeys("Somewhere Str., 1, Worldwide");

        // Find and click the Submit button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Verify that the displayed pop-up contains the proper values
        WebElement popup = driver.findElement(By.xpath("//div[@class='modal-body']/div[preceding-sibling::div[text()='Student Name']]"));
        String popupText = popup.getText();
        String expectedText = "Student Name John Doe\nStudent Email test@test.test\nGender Male\nMobile 123456789\nDate of Birth 01 January,1980\nSubjects Automation Testing\nAddress Somewhere Str., 1, Worldwide";
        if (popupText.equals(expectedText)) {
            System.out.println("The popup contains the proper values.");
        } else {
            System.out.println("The popup does not contain the proper values.");
        }

        // Close the browser
        driver.quit();
    }
}
