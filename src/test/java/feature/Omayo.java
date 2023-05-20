package feature;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Omayo {
    WebDriver driver;

    @Before("@login")
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("^I navigate to omayo website$")
    public void i_navigate_to_omayo_website() {

        driver.get("http://www.omayo.blogspot.com");
    }

    @When("^I enter correct username as ([^\"]*) and password as ([^\"]*)$")
    public void i_enter_correct_username_as_and_password_as(String someusername, String somepassword) {
        driver.findElement(By.name("userid")).sendKeys(someusername);
        driver.findElement(By.name("pswrd")).sendKeys(somepassword);

    }

    @And("^I click on login button$")
    public void i_click_on_login_button() {
        driver.findElement(By.cssSelector("input[type='button'][value='Login']")).click();
    }

    @Then("^User should be able to logged in based on ([^\"]*) login status$")
    public void user_should_be_able_to_logged_in_based_on_login_status(String expected) {
        Alert alert = driver.switchTo().alert();
        String actual = null;
        try {
            if (alert.getText().contains("Error Password or Username")) {
                actual = "failure";
            }

        } catch (Exception e) {
            actual = "sucess";
        }
        Assert.assertEquals(expected, actual);

    }

    @After("@login")
    public void teardown() {
        driver.quit();
    }

}
