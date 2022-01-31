package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement userNameTxt(WebDriver driver) {
        return (driver.findElement(By.xpath("//input[@id='login']")));
    }

    public WebElement passwordTxt(WebDriver driver) {
        return (driver.findElement(By.cssSelector("input#password")));
    }

    public WebElement loginBtn(WebDriver driver) {
        return (driver.findElement(By.xpath("//button[text()='Log in']")));
    }
}
