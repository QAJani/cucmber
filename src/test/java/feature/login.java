package feature;

import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class login {
    WebDriver driver;

    @Before("@ninja")
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("^User navigates to login page of the application$")
    public void user_navigates_to_login_page_of_the_application() {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
    }

    @When("^User enters Username \"([^\"]*)\" and Password \"([^\"]*)\" into the fields$")
    public void user_enters_username_something_and_password_something_into_the_fields(String username,
            String password) {
        driver.findElement(By.id("input-email")).sendKeys(username);
        driver.findElement(By.id("input-password")).sendKeys(password);
    }

    @Then("^User should successfully login$")
    public void user_should_successfully_login() {
        driver.findElement(By.cssSelector("input[type='submit'][value='Login']")).click();
    }

    @And("^Clicks on Login button$")
    public void clicks_on_login_button() {
        WebElement accountbreadcrumbs = null;
        try {
            accountbreadcrumbs = driver.findElement(By.xpath("//*[class='breadcrumb']//a[text()='Account']"));
        } catch (Exception e) {
            System.out.println("User has not logged in");
        }
        Assert.assertNotNull("User has not logged in", accountbreadcrumbs);
    }

    public void teardown() {
        driver.quit();
    }
}
