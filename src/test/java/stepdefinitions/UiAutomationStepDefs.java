package stepdefinitions;

import Utils.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UiAutomationStepDefs {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

    @Given("User is logged in to the application")
    public void userIsLoggedInToTheApplication() {

        driver.get("http://demo.guru99.com/test/newtours/index.php");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("submit"))));
        driver.findElement(By.name("userName")).sendKeys("mercury");
        driver.findElement(By.name("password")).sendKeys("mercury");
        driver.findElement(By.name("submit")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[contains(text(),'Login Successfully')]"))));
    }

    @When("User clicks on fight booking section")
    public void userClicksOnFightBookingSection() {
        driver.findElement(By.xpath("//a[contains(text(),'Flights')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@name='findFlights']"))));
    }

    @Then("User should see the below values in departure selection")
    public void userShouldSeeTheBelowValuesInDepartureSelection(DataTable dataTable) {
        List<String> expectedOptions=dataTable.asList();
        List<String> actualOptions= SeleniumUtils.getSelectOptionsValue(new Select(driver.findElement(By.name("fromPort"))));
        Assert.assertEquals(expectedOptions, actualOptions);
    }
}
