package stepdefinitions;

import heynoshPages.*;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.Driver.getDriver;


public class SearchStepDefinitions extends ReusableMethods {

    SearchPage searchPage = new SearchPage();
    LoginPage loginPage = new LoginPage();
    RegisterPage register = new RegisterPage();
    ReservationPage reservationPage = new ReservationPage();
    UpdatePage updatePage = new UpdatePage();

    boolean isThere;
    boolean isNotThere;
    String rest;


    @Given("User find a {string}")
    public void user_find_a(String restaurant) {
        //  getDriver();

        waitFor(3);
        clickJS(loginPage.location_West);
        waitFor(3);
        clickJS(reservationPage.findRestaurant);
        waitFor(3);
        reservationPage.sendRestaurant.sendKeys(restaurant);
        waitFor(3);
        KeyEvent enter = new KeyEvent(AndroidKey.ENTER);
        Driver.getDriver().pressKey(enter);
        waitFor(3);


    }

    @Then("User confirms that they found the {string}")
    public void user_confirms_that_they_found_the(String restaurant) {


        try {
            Assert.assertTrue(searchPage.oneRestaurant.isDisplayed());
            locateElementByText(restaurant);
            System.out.println(restaurant + " Restaurant Listesinde bulunmaktadır");

        } catch (Exception e) {
            try {
                Assert.assertTrue(searchPage.zeroRestaurant.isDisplayed());
                System.out.println(restaurant + " Restaurant Listesinde yoktur");

            } catch (Exception d) {
                System.out.println(restaurant + " içeren birden fazla restaurant bulunmaktadır");
            }

        }

    }

    @Given("User find a food {string}")
    public void userFindAFood(String food) {
        getDriver();
        waitForVisibility(loginPage.location_West, 15000);
        clickJS(loginPage.location_West);
        clickJS(reservationPage.findRestaurant);
        waitFor(3);
        reservationPage.sendRestaurant.sendKeys(food);
        waitFor(3);
        KeyEvent enter = new KeyEvent(AndroidKey.ENTER);
        Driver.getDriver().pressKey(enter);
        waitFor(3);

    }

    @Then("User confirms that they found the  food{string}")
    public void userConfirmsThatTheyFoundTheFood(String food) {
        try {
            Assert.assertTrue(searchPage.oneRestaurant.isDisplayed());
            locateElementByText(food);
            System.out.println(food + " Bulunan restaurantlar bulunmaktadır");

        } catch (Exception e) {
            try {
                Assert.assertTrue(searchPage.zeroRestaurant.isDisplayed());
                System.out.println(food + " Restaurant Listesinde yoktur");

            } catch (Exception d) {
                System.out.println(food + " içeren birden fazla restaurant bulunmaktadır");
            }
        }
    }
}
