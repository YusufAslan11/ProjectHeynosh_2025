package stepdefinitions;

import heynoshPages.AsGuestPage;
import heynoshPages.LoginPage;
import heynoshPages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utilities.ReusableMethods;
import utilities.ScreenshotUtil;

public class AsGuestStepDefinition extends ReusableMethods {
    WebDriver driver;

    LoginPage login = new LoginPage();
    RegisterPage register = new RegisterPage();
    ScreenshotUtil screenshotUtil=new ScreenshotUtil(driver);
    AsGuestPage asGuestPage=new AsGuestPage();

    @Given("User clicks Continue as guest")
    public void user_clicks_continue_as_guest() {

        waitFor(3);
        try {
            clickJS(register.Allow);
            waitFor(1);
        }catch (Exception e) {

            System.out.println("İzin istemedi");
        }
        waitFor(2);
        asGuestPage.enterAsGuest.click();
        waitFor(2);
        asGuestPage.choiceNavigate.click();

    }
    @Then("User choice the restaurant")
    public void user_choice_the_restaurant() {


    }
    @Then("User tries make reservation")
    public void user_tries_make_reservation() {

    }
    @Then("The user sees that he could not book")
    public void the_user_sees_that_he_could_not_book() {

    }


}
