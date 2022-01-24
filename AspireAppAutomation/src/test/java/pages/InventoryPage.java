package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends Page {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void waitForProductsMainLink(WebDriver driver) {
        waitForElement(By.xpath("//a[contains(text(),'Products')]"));
    }

    public WebElement productsMainLnk(WebDriver driver) {
        return (driver.findElement(By.xpath("//a[contains(text(),'Products')]")));
    }

    public WebElement productsSubLnk(WebDriver driver) {
        return (driver.findElement(By.xpath("//span[text()='Products']")));
    }

    public void waitForCreateProduct(WebDriver driver) {
        waitForElement(By.xpath("//button[contains(text(),'Create')]"));
    }

    public WebElement createProduct(WebDriver driver) {
        return (driver.findElement(By.xpath("//button[contains(text(),'Create')]")));
    }
}
