package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManufacturingPage extends Page {

    public ManufacturingPage(WebDriver driver) {
        super(driver);
    }

    public void waitForCreateQuantity() {
        waitForElement(By.xpath("//button[contains(text(),'Create')]"));
    }

    public WebElement createQuantity(WebDriver driver) {
        return (driver.findElement(By.cssSelector("div > button.btn.btn-primary.o_list_button_add")));
    }

    public void waitForEnterProduct() {
        waitForElement(By.xpath("//label[text()='Product']/parent::td/following-sibling::td/div/div/div/input"));
    }

    public WebElement enterProduct(WebDriver driver) {
        return (driver.findElement(By.xpath("//label[text()='Product']/parent::td/following-sibling::td/div/div/div/input")));
    }

    public WebElement confirmOrder(WebDriver driver) {
        return (driver.findElement(By.xpath("//button[@name='action_confirm']")));
    }

    public void waitForMarkAsDone() {
        waitForElement(By.xpath("//span[text()='Mark as Done']/parent::button[@confirm='There are no components to consume. Are you still sure you want to continue?']"));
    }

    public WebElement markAsDoneOrder(WebDriver driver) {
        return (driver.findElement(By.xpath("//span[text()='Mark as Done']/parent::button[@confirm='There are no components to consume. Are you still sure you want to continue?']")));
    }

    public void waitForOkConfirmation() {
        waitForElement(By.xpath("//span[text()='Ok']/parent::button"));
    }

    public WebElement OkConfirmation(WebDriver driver) {
        return (driver.findElement(By.xpath("//span[text()='Ok']/parent::button")));
    }

    public void waitForApplyConfirmation() {
        waitForElement(By.xpath("//span[text()='Apply']/parent::button"));
    }

    public WebElement ApplyConfirmation(WebDriver driver) {
        return (driver.findElement(By.xpath("//span[text()='Apply']/parent::button")));
    }

    public void waitForProductName() {
        waitForElement(By.xpath("//label[text()='Product']/parent::td/following-sibling::td/a/span"));
    }

    public WebElement doneConfirmationState(WebDriver driver) {
        return (driver.findElement(By.xpath("//button[@title='Current state']")));
    }

    public WebElement productName(WebDriver driver) {
        return (driver.findElement(By.xpath("//label[text()='Product']/parent::td/following-sibling::td/a/span")));
    }

}
