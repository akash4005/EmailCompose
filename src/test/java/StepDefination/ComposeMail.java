package StepDefination;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ComposeMail {
    WebDriver driver;
    @Given("user logged in to my Gmail account")
    public void user_logged_in_to_my_gmail_account() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://mail.google.com/");
        driver.findElement(By.id("identifierId")).sendKeys("xyz123@gmail.com");// this email and pass is just taking for an Example
        driver.findElement(By.id("identifierNext")).click();
        driver.findElement(By.name("password")).sendKeys("12345");
        driver.findElement(By.id("passwordNext")).click();
    }
    @When("user click on the {string} button")
    public void user_click_on_the_button() {
        WebElement composeButton = driver.findElement(By.xpath("//div[contains(text(),'Compose')]"));
        composeButton.click();
    }


    @When("user fill in the recipient's email address as {string}")
    public void user_fill_in_the_recipient_s_email_address_as(String email) {
        WebElement toField = driver.findElement(By.name("to"));
        toField.sendKeys(email);
    }
    @When("user fill in the subject as {string}")
    public void user_fill_in_the_subject_as(String subject) {
        WebElement subjectField = driver.findElement(By.name("subjectbox"));
        subjectField.sendKeys(subject);

    }
    @When("user fill in the body as {string}")
    public void user_fill_in_the_body_as(String body) {
        WebElement bodyField = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
        bodyField.sendKeys(body);

    }
    @And("user click on the \"Send\" button")
    public void user_click_on_the_Send_button() {

        driver.findElement(By.cssSelector("div[aria-label*='Send'][role='button']")).click();
    }

    @Then("the email should be sent successfully")
    public void the_email_should_be_sent_successfully() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Your message has been sent.')]")));

        WebElement sentConfirmation = driver.findElement(By.xpath("//span[contains(text(), 'Your message has been sent.')]"));
        Assert.assertTrue(sentConfirmation.isDisplayed());

    }
    @Then("user should see a confirmation message that the email has been sent")
    public void user_should_see_a_confirmation_message_that_the_email_has_been_sent() {
        WebElement sentConfirmation = driver.findElement(By.xpath("//span[contains(text(), 'Your message has been sent.')]"));
        Assert.assertTrue(sentConfirmation.isDisplayed());

        driver.quit();


    }}
