package stepdefinitions;


import heynoshPages.LoginPage;
import heynoshPages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.ScreenshotUtil;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class LoginStepDefinition extends ReusableMethods {
    WebDriver driver;


    LoginPage login = new LoginPage();
    RegisterPage register = new RegisterPage();
    ScreenshotUtil screenshotUtil=new ScreenshotUtil(driver);

    @Given("User clicks on Login button")
    public void user_clicks_on_login_button() {
        waitFor(3);
      try {
          clickJS(register.Allow);
          waitFor(1);
      }catch (Exception e) {

          System.out.println("İzin istemedi");
      }

        clickJS(login.login);

    }

    @Then("User enters {string} address for login")
    public void userEntersAddressForLogin(String email) {

        waitFor(1);
        login.loginMail.sendKeys(ConfigReader.getProperty(email));


    }

    @Then("User enters {string} for login")
    public void userEntersForLogin(String password) {

        login.loginPassword.click();
        waitFor(1);
        login.loginPassword.sendKeys(ConfigReader.getProperty(password));
        waitFor(1);


    }


    @Then("User clicks on Log in button")
    public void userClicksOnLogInButton() {
        waitFor(2);
        login.loginButton.click();



    }



    @Then("User confirms that the username is correct")
    public void user_confirms_that_the_username_is_correct() throws IOException {

        String nameText = register.registeredMail.getText();
        System.out.println("Kullanıcı adı : " + nameText);
        boolean isTrue = nameText.isEmpty();
        Assert.assertFalse(isTrue);



   }

    //.....................LOGİN NEGATİVE........................

    @Given("User enters {string} and clicks on Continue button_User")
    public void user_enters_and_clicks_on_continue_button_user(String username_N) {
        login.loginMail.sendKeys(username_N);
        waitFor(2);


    }

    @Given("User enters {string} and clicks on Continue button_Pass")
    public void user_enters_and_clicks_on_continue_button_pass(String password_N) {
        login.loginPassword.sendKeys(password_N);
        waitFor(2);

    }


    @Then("User verifies that the user cannot log in")
    public void user_verifies_that_the_user_cannot_log_in() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

        boolean isAnyErrorDisplayed= false;
        String visibleErrors = "";
// 1. Olması muhtemel TÜM hata mesajlarını bir listeye koy
        List<WebElement> possibleErrorElements= Arrays.asList(
                login.loginFailpass,
                login.loginFailMail
                // Sayfada başka hata mesajı WebElement'i varsa onları da bu listeye ekleyin.


        );
        // 2. Listedeki her element için dön
        for(WebElement errorElement : possibleErrorElements ){

            try{
                wait.withTimeout(Duration.ofSeconds(5))
                        .until(ExpectedConditions.visibilityOf(errorElement));
                System.out.println("OK_1");

                if (errorElement.isDisplayed()){
                    isAnyErrorDisplayed=true;
                    visibleErrors += "- " + errorElement.getText() + " "; // Hata metnini de logla
                    System.out.println("Hata Mesajı Görüldü: " + errorElement.getText());
                }

            } catch (Exception e) {
                // Element görünür değilse veya bulunamazsa, buraya düşer. Bu normal, bir sonrakine bakmaya devam et.
                // Hata loglamamak için boş bırakabilirsiniz veya debug için yorum satırı yazdırabilirsiniz.
                System.out.println("DEBUG: " + errorElement + " elementi gözükmedi");

            }

        }
        Assert.assertTrue("TEST FAILED: Hiçbir hata mesajı gözükmedi. Sistem hatalı veriyi kabul etmiş olabilir! Gözlemlenen Hatalar: " + visibleErrors,
                isAnyErrorDisplayed);



    }


    }
