package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends Page {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void waitForProductsMainLink() {
        waitForElement(By.xpath("//button[@title='Products']/span[text()='Products']"));
    }

    public WebElement productsMainLnk(WebDriver driver) {
        return (driver.findElement(By.xpath("//button[@title='Products']/span[text()='Products']")));
    }

    public WebElement productsSubLnk(WebDriver driver) {
        return (driver.findElement(By.xpath("//a[text()='Products']")));
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
        waitForElementToBeClickable(driver.findElement(By.xpath("//label[text()='Unit of Measure']/parent::td/following-sibling::td/div/div/div/a")));
    }

    public WebElement unitOfMeasure(WebDriver driver) {
        return (driver.findElement(By.xpath("//label[text()='Unit of Measure']/parent::td/following-sibling::td/div/div/div/a")));
    }

    public void waitForUnitOfMeasureSelect() {
        waitForElement(By.xpath("//a[text()='cm']"));
    }

    public WebElement unitOfMeasureSelect(WebDriver driver) {
        return (driver.findElement(By.xpath("//a[text()='cm']")));
    }

    public void waitForUpdateProductQuantity(WebDriver driver) {
        waitForElementWithVisibility(driver.findElement(By.xpath("//button[@name='action_update_quantity_on_hand']")));
    }

    public WebElement updateProductQuantity(WebDriver driver) {
        return (driver.findElement(By.xpath("//button[@name='action_update_quantity_on_hand']")));
    }

    public void waitForCreateQuantity(WebDriver driver) {
        waitForElementToBeClickable(driver.findElement(By.xpath("//button[contains(text(),'Create')]")));
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

    public void waitForCountedQuantity() {
        waitForElement(By.xpath("//input[@name='inventory_quantity']"));
    }

    public WebElement countedQuantity(WebDriver driver) {
        return (driver.findElement(By.xpath("//input[@name='inventory_quantity']")));
    }

    public void waitForSelectProductName(WebDriver driver) {
        waitForElementToBeClickable(driver.findElement(By.cssSelector("li.breadcrumb-item.o_back_button")));
    }

    public WebElement selectProductName(WebDriver driver) {
        return (driver.findElement(By.cssSelector("li.breadcrumb-item.o_back_button")));
    }

    public WebElement saveBtn(WebDriver driver) {
        return (driver.findElement(By.xpath("//button[contains(text(),'Save')]")));
    }

    public WebElement applicationIcon(WebDriver driver) {
        return (driver.findElement(By.cssSelector("a.fa.o_menu_toggle.fa-th")));
    }

}
