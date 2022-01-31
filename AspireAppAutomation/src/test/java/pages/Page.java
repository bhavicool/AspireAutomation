package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;

    Page(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    protected void waitForElement(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void waitForElementWithVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementList(List<WebElement> element) {
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    protected void selectElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected String getElementText(WebElement element)
    {
        return element.getText();
    }
}
