package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void waitForInventoryLink(WebDriver driver) {
        waitForElement(By.xpath("//div[text()='Inventory']"));
    }

    public WebElement inventoryLink(WebDriver driver) {
        return (driver.findElement(By.xpath("//div[text()='Inventory']")));
    }

    public void waitForManufacturingLink(WebDriver driver) {
        waitForElement(By.xpath("//div[text()='Manufacturing']"));
    }

    public WebElement manufacturingLink(WebDriver driver) {
        return (driver.findElement(By.xpath("//div[text()='Manufacturing']")));
    }
}
