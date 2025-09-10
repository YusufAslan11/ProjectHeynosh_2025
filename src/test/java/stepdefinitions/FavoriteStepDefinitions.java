package stepdefinitions;

import heynoshPages.FavoritePage;
import heynoshPages.LoginPage;
import heynoshPages.RegisterPage;
import heynoshPages.ReservationPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;



public class FavoriteStepDefinitions extends ReusableMethods {
    FavoritePage favoritePage=new FavoritePage();
    RegisterPage registerPage=new RegisterPage();
    ReservationPage reservationPage=new ReservationPage();
    LoginPage loginPage=new LoginPage();

    @And("User clicks on Continue buttons_f")
    public void userClicksOnContinueButtons_f() {
        clickJS(registerPage.Continue);
        waitFor(3);
        try {
            waitFor(3);
            clickJS(loginPage.location_West);
        }catch(Exception e){
            System.out.println("Konum istenmedi");
        }
    }

    @Given("User searches for the {string}")
    public void user_searches_for_the(String restaurant) {


        clickJS(reservationPage.findRestaurant);
        waitFor(2);
        reservationPage.sendRestaurant.sendKeys(ConfigReader.getProperty(restaurant));
        waitFor(2);
        KeyEvent enter =new KeyEvent(AndroidKey.ENTER);
        Driver.getDriver().pressKey(enter);

    }
    @Then("User enters to restaurant")
    public void user_enters_to_restaurant() {
        try{
            clickJS(reservationPage.WhileUsingTheApp);
            waitFor(2);

        }catch(Exception e){
            System.out.println("Konum sormadı");
        }

        clickJS(reservationPage.ID_174_1604058861547);
        waitFor(1);

    }
    @Then("User clicks on favorites icon")
    public void user_clicks_on_favorites_icon() {
        favoritePage.favoriteIcon.click();

        waitFor(2);
        clickJS(favoritePage.leftButton);

    }
    @Then("User confirms to add to favorites")
    public void user_confirms_to_add_to_favorites() {
        favoritePage.favoriteButton.click();
        waitFor(3);
        Assert.assertTrue(reservationPage.ID_174_1604058861547.isDisplayed());
        waitFor(3);

    }


    @Then("User select the restaurant")
    public void userSelectTheRestaurant() {
        favoritePage.selectRestaurant.click();
    }

}
