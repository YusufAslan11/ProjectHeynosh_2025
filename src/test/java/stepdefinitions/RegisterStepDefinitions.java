package stepdefinitions;

import com.github.javafaker.Faker;
import heynoshPages.LoginPage;
import heynoshPages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class RegisterStepDefinitions extends ReusableMethods {

    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();
    boolean isEmailInvalid;


    @Given("User clicks on signUp for free button")
    public void user_clicks_on_sign_up_for_free_button() {
        waitFor(3);
        clickJS(registerPage.Allow);
        waitFor(10);
        clickJS(registerPage.signupForFree);

    }

    @Then("User enters full name")
    public void userEntersFullName() {
        registerPage.fullName.sendKeys(faker.name().fullName());
        waitFor(2);

    }

    @Then("User enters e-mail address")
    public void user_enters_e_mail_address() {
        registerPage.email.sendKeys(faker.internet().emailAddress());
        waitFor(3);


    }


    @Then("User clicks on Continue button")
    public void user_clicks_on_continue_button() {
        clickJS(registerPage.Continue);
        waitFor(3);
    }


    @Then("User enters password")
    public void user_enters_password() {

        registerPage.password.sendKeys("As1456");
        waitFor(2);
    }


    @Then("User clicks Agree and Continue button")
    public void userClicksAgreeAndContinueButton() {
        registerPage.AgreeAndContinue.click();
    }


    @And("User clicks on Continue buttons")
    public void userClicksOnContinueButtons() {

        clickJS(registerPage.Continue);
        waitFor(3);


    }


    @Then("User clicks skip button")
    public void user_clicks_skip_button() {
        waitFor(5);
        clickJS(registerPage.Skipvideo);


    }

    @Then("User allows to the location")
    public void user_allows_to_the_location() {
        clickJS(registerPage.Allow);

    }

    @Then("User clicks While Using the app button")
    public void user_clicks_while_using_the_app_button() {
        clickJS(registerPage.WhileUsingTheApp);

    }

    @Then("User clicks on account button")
    public void user_clicks_on_account_button() {
        waitFor(2);
        try {
            clickJS(loginPage.location_West);

        } catch (Exception e) {
            System.out.println("Uygulama konum istemedi");

        }
        waitFor(2);
       try {
           clickJS(registerPage.Account);
       } catch (Exception e) {
           System.out.println("Account error");
           waitFor(2);
        clickJS(registerPage.Account);

       }
//

    }

    @Then("User clicks on Show Profile")
    public void user_clicks_on_show_profile() {
        String emailText = registerPage.assertRegisteredEmail.getText();
        System.out.println(emailText);
        Assert.assertTrue(emailText.contains("@"));


    }

    @Then("User closed the page")
    public void user_closed_the_page() {
        Driver.closeDriver();
    }


    //************Negative Scenario***********//

    // fullName için
    @Then("User enters {string} as full name")
    public void userEntersAsFullName(String fullName) {
        registerPage.fullName.sendKeys(fullName);
    }


    // password için (önceki 'userEntersPassword' ile çakışmaması için isim değişti)
    @Then("User enters {string} as password")
    public void userEntersAsPassword(String password) {
        registerPage.password.sendKeys(password);
    }

    // e-mail için (önceki 'user_enters_e_mail_address' ile çakışmaması için)
    @Then("User enters {string} as email address")
    public void userEntersAsEmailAddress(String eMail) {
        registerPage.email.sendKeys(eMail);
    }

    @Then("User should not be able to register with incorrect data")
    public void userShouldNotBeAbleToRegisterWithIncorrectData() {


        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        boolean isAnyErrorDisplayed = false;
        String visibleErrors = "";

        // 1. Olması muhtemel TÜM hata mesajlarını bir listeye koy
        List<WebElement> possibleErrorElements = Arrays.asList(
                registerPage.fail_fullname_Empty,
                registerPage.fail_mail_invalidMail,
                registerPage.fail_password_MissingCharacter
                // Sayfada başka hata mesajı WebElement'i varsa onları da bu listeye ekleyin.
        );

        // 2. Listedeki her element için dön
        for (WebElement errorElement : possibleErrorElements) {
            try {
                // Elementi 2 saniyeden kısa bir sürede görmeye çalış
                wait.withTimeout(Duration.ofSeconds(5))
                        .until(ExpectedConditions.visibilityOf(errorElement));

                // Eğer bu satıra geldiyse, element görünür demektir.
                if (errorElement.isDisplayed()) {
                    isAnyErrorDisplayed = true;
                    visibleErrors += "- " + errorElement.getText() + " "; // Hata metnini de logla
                    System.out.println("Hata Mesajı Görüldü: " + errorElement.getText());
                }
            } catch (Exception e) {
                // Element görünür değilse veya bulunamazsa, buraya düşer. Bu normal, bir sonrakine bakmaya devam et.
                // Hata loglamamak için boş bırakabilirsiniz veya debug için yorum satırı yazdırabilirsiniz.
                // System.out.println("DEBUG: " + errorElement + " elementi gözükmedi, beklenen bir durum olabilir.");
            }
        }

        // 3. Ana Assertion: HERHANGİ BİR hata mesajı gözüktü mü?
        Assert.assertTrue("TEST FAILED: Hiçbir hata mesajı gözükmedi. Sistem hatalı veriyi kabul etmiş olabilir! Gözlemlenen Hatalar: " + visibleErrors,
                isAnyErrorDisplayed);
    }

}


//
//    @Then("User should not register if user enters an incorrect email")
//    public void userShouldNotRegisterIfUserEntersAnIncorrectEmail() {
//
//        Assert.assertTrue(registerPage.InvalidEmail.isDisplayed());
//        Driver.closeDriver();
//    }

//
//    @Then("User enters {string}")
//    public void userEnters(String password) {
//        registerPage.password.sendKeys(password);
//    }

//
//    @Then("The user should not register if user enters an incorrect email or password..")
//    public void theUserShouldNotRegisterIfHeSheEntersAnIncorrectEmailOrPassword() {
//        boolean isInvalidPassword=registerPage.InvalidPassword.isDisplayed();
//        Assert.assertTrue(isInvalidPassword || isEmailInvalid);
//
//    }





