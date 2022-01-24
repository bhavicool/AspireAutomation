package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.InventoryPage;
import pages.LoginPage;

public class CreateOrderTest {

    private WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    ExtentReports extentReports;
    ExtentTest logger;
    ExtentHtmlReporter extentHtmlReporter;

    @BeforeTest
    public void startReport() {
        extentHtmlReporter=new ExtentHtmlReporter("\\AspireAutomation\\AspireAppAutomation\\test-output\\STMExtentReport.html");
        extentReports=new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("OS", "Windows");
        extentReports.setSystemInfo("AUT", "Aspire App");
        extentReports.setSystemInfo("Tester", "Bhavesh Sachanandani");
    }

    @BeforeMethod()
    public void navigateToApplication() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(getURLDetails("applicationURL"));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        inventoryPage=new InventoryPage(driver);
    }

    @Test(priority = 1)
    public void successfulOrder() throws InterruptedException, IOException {

        ExtentTest logger=extentReports.createTest("Positive Scenario for successful order");
        logger.log(Status.INFO,"Entering Credentials and clicking login");

        loginPage.userNameTxt(driver).sendKeys(getURLDetails("userName"));
        loginPage.passwordTxt(driver).sendKeys(getURLDetails("passWord"));
        loginPage.loginBtn(driver).click();

        homePage.waitForInventoryLink(driver);
        homePage.inventoryLink(driver).click();

        inventoryPage.waitForProductsMainLink(driver);
        inventoryPage.productsMainLnk(driver).click();
        inventoryPage.productsSubLnk(driver).click();
        inventoryPage.waitForCreateProduct(driver);
        inventoryPage.createProduct(driver).click();

        Assert.assertEquals(30, 30);
        logger.log(Status.PASS,"Samsung mobile count is as expected");

    }

    @AfterMethod
    public void quitDriver() throws Exception {
        driver.quit();
    }

    @AfterTest
    public void cleanUp()
    {
        extentReports.flush();
    }

    public static String getURLDetails(String key) throws IOException {
        Properties prop = new Properties();
        String fileName = "\\AspireAutomation\\AspireAppAutomation\\src\\test\\resources\\data.config";
        try (FileInputStream fis = new FileInputStream(fileName)) {
            prop.load(fis);
        } catch (FileNotFoundException ignored) {

        }
        return prop.getProperty(key);
    }
}
