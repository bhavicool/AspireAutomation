package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends Page {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void waitForProductsMainLink() {
        waitForElement(By.xpath("//a[contains(text(),'Products')]"));
    }

    public WebElement productsMainLnk(WebDriver driver) {
        return (driver.findElement(By.xpath("//a[contains(text(),'Products')]")));
    }

    public WebElement productsSubLnk(WebDriver driver) {
        return (driver.findElement(By.xpath("//span[text()='Products']")));
    }

    public void waitForCreateProduct() {
        waitForElement(By.xpath("//button[contains(text(),'Create')]"));
    }

    public WebElement createProduct(WebDriver driver) {
        return (driver.findElement(By.xpath("//button[contains(text(),'Create')]")));
    }

    public void waitForProductName() {
        waitForElement(By.xpath("//label[text()='Product Name']/parent::div/descendant::input[@name='name']"));
    }

    public WebElement productName(WebDriver driver) {
        return (driver.findElement(By.xpath("//label[text()='Product Name']/parent::div/descendant::input[@name='name']")));
    }

    public void waitForUnitOfMeasure(WebDriver driver) {
        waitForElementToBeClickable(driver.findElement(By.xpath("//label[text()='Unit of Measure']/parent::td/following-sibling::td/div/div/a")));
    }

    public WebElement unitOfMeasure(WebDriver driver) {
        return (driver.findElement(By.xpath("//label[text()='Unit of Measure']/parent::td/following-sibling::td/div/div/a")));
    }

    public void waitForUnitOfMeasureSelect() {
        waitForElement(By.xpath("//a[text()='L']"));
    }

    public WebElement unitOfMeasureSelect(WebDriver driver) {
        return (driver.findElement(By.xpath("//a[text()='L']")));
    }

    public WebElement updateProductQuantity(WebDriver driver) {
        return (driver.findElement(By.xpath("//span[text()='Update Quantity']")));
    }

    public WebElement createQuantity(WebDriver driver) {
        return (driver.findElement(By.xpath("//button[contains(text(),'Create')]")));
    }

    public WebElement locationDropdown(WebDriver driver) {
        return (driver.findElement(By.xpath("//div[@name='location_id']/descendant::input[@class='o_input ui-autocomplete-input']")));
    }

    public WebElement virtualLocationOption(WebDriver driver) {
        return (driver.findElement(By.xpath("//a[text()='Virtual Locations/HN']")));
    }

    public WebElement onHandQuantity(WebDriver driver) {
        return (driver.findElement(By.xpath("//input[@name='inventory_quantity']")));
    }

    public WebElement saveBtn(WebDriver driver) {
        return (driver.findElement(By.xpath("//button[contains(text(),'Save')]")));
    }

}
