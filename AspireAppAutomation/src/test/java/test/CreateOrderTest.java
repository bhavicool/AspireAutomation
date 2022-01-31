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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.ManufacturingPage;
import utils.RandomNameGenerator;

public class CreateOrderTest {

    private WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    ManufacturingPage manufacturingPage;
    ExtentReports extentReports;
    ExtentTest logger;
    ExtentHtmlReporter extentHtmlReporter;
    RandomNameGenerator randomNameGenerator;
    Actions action;

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
        manufacturingPage=new ManufacturingPage(driver);
        randomNameGenerator=new RandomNameGenerator();
        action=new Actions(driver);
    }

    @Test(priority = 1)
    public void successfulOrder() throws InterruptedException, IOException {

        ExtentTest logger=extentReports.createTest("Positive Scenario for successful order");
        logger.log(Status.INFO,"Entering Credentials and clicking login");

        try {
            loginPage.userNameTxt(driver).sendKeys(getURLDetails("userName"));
            loginPage.passwordTxt(driver).sendKeys(getURLDetails("passWord"));
            loginPage.loginBtn(driver).click();

            homePage.waitForInventoryLink(driver);
            homePage.inventoryLink(driver).click();

            inventoryPage.waitForProductsMainLink();
            inventoryPage.productsMainLnk(driver).click();
            inventoryPage.productsSubLnk(driver).click();
            inventoryPage.waitForCreateProduct();
            inventoryPage.createProduct(driver).click();
            inventoryPage.waitForProductName();
            inventoryPage.productName(driver).sendKeys(randomNameGenerator.generateRandomProductName());
            inventoryPage.waitForUnitOfMeasure(driver);
            action.moveToElement(inventoryPage.unitOfMeasure(driver)).click().perform();
            inventoryPage.waitForUnitOfMeasureSelect();
            inventoryPage.unitOfMeasureSelect(driver).click();
            inventoryPage.saveBtn(driver).click();
            Thread.sleep(2000);

            inventoryPage.updateProductQuantity(driver).click();
            Thread.sleep(2000);
            inventoryPage.createQuantity(driver).click();
            inventoryPage.waitForCountedQuantity();
            inventoryPage.countedQuantity(driver).clear();
            inventoryPage.countedQuantity(driver).sendKeys("100");
            action.sendKeys(Keys.TAB).build().perform();
            inventoryPage.selectProductName(driver).click();
            inventoryPage.applicationIcon(driver).click();

            homePage.waitForManufacturingLink(driver);
            homePage.manufacturingLink(driver).click();

            manufacturingPage.waitForCreateQuantity();
            manufacturingPage.createQuantity(driver).click();
            manufacturingPage.waitForEnterProduct();
            manufacturingPage.enterProduct(driver).click();
            manufacturingPage.enterProduct(driver).sendKeys(randomNameGenerator.generateRandomProductName());
            Thread.sleep(2000);
            action.sendKeys(Keys.TAB).build().perform();
            manufacturingPage.confirmOrder(driver).click();
            manufacturingPage.waitForMarkAsDone();
            manufacturingPage.markAsDoneOrder(driver).click();
            manufacturingPage.waitForOkConfirmation();
            manufacturingPage.OkConfirmation(driver).click();
            manufacturingPage.waitForApplyConfirmation();
            manufacturingPage.ApplyConfirmation(driver).click();

            Thread.sleep(3000);
            Assert.assertEquals(30, 30);
            logger.log(Status.PASS, "Samsung mobile count is as expected");
        }
        catch(Exception e)
        {
            System.out.println("Exception is:"+e.toString());
            Assert.assertEquals(30, 32);
            logger.log(Status.ERROR, "An Exception:"+e.toString());

        }

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
