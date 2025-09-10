package stepdefinitions;

import heynoshPages.*;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.Driver.getDriver;

public class ReservationStepDefinitions extends ReusableMethods {

    RegisterPage registerPage = new RegisterPage();
    FavoritePage favoritePage = new FavoritePage();
    LoginPage loginPage = new LoginPage();
    ReservationPage reservationPage = new ReservationPage();
    UpdatePage updatePage = new UpdatePage();
    SearchPage searchPage = new SearchPage();
    boolean noDiscount;
    boolean haveReservation;


    @Then("User searches for {string}")
    public void user_searches_for(String restaurant) {
        waitFor(5);
        clickJS(loginPage.location_West);
        getDriver();
        waitFor(3);
        clickJS(reservationPage.findRestaurant);
        waitFor(2);
        //  clickJS(reservationPage.WhileUsingTheApp);
        reservationPage.sendRestaurant.sendKeys(restaurant);
        waitFor(3);
        KeyEvent enter = new KeyEvent(AndroidKey.ENTER);
        Driver.getDriver().pressKey(enter);

    }

    @Then("User clicks on the restaurant")
    public void user_clicks_on_the_restaurant() {
        //   clickJS(reservationPage.);

        clickJS(favoritePage.selectRestaurant);
        waitFor(2);

        if(reservationPage.TodayTwoPerson.isDisplayed()){
            clickJS(reservationPage.TodayTwoPerson);
        }else {
            clickJS(reservationPage.TomorrowTwoPerson);
        }
        waitFor(2);
        clickJS(reservationPage.onePerson);
        waitFor(2);
        clickJS(reservationPage.done);
        waitFor(1);
        clickJS(reservationPage.bookATable);
        waitFor(3);



//        try {
//            noDiscount = reservationPage.noDiscountText.isDisplayed();
//            System.out.println(reservationPage.noDiscountText);
//            Assert.assertTrue(noDiscount);
//            System.out.println("Rezervasyon için indirimli saat bulunmamaktadır...");
//
//        } catch (Exception e) {
//
//            try {
//                clickJS(reservationPage.yuzde40);
//                waitFor(1);
//            } catch (Exception forty) {
//
//                try {
//                    System.out.println("%40 indirimli rezervasyon bulunmamaktadır");
//                    clickJS(reservationPage.yuzde20);
//                    waitFor(1);
//
//                } catch (Exception twenty) {
//
//                    try {
//                        System.out.println("%20 indirimli rezervasyon bulunmamaktadır");
//                        clickJS(reservationPage.yuzde10);
//                    } catch (Exception ten) {
//
//                        System.out.println("Rezervasyon bulunmamaktadır");
//
//                    }
//                }
//            }
//
//        }

    }

    @Then("User sees the booking information")
    public void user_sees_the_booking_information() {
        try {
            noDiscount = reservationPage.noDiscountText.isDisplayed();
            System.out.println(reservationPage.noDiscountText);
            Assert.assertTrue(noDiscount);
        } catch (Exception e) {
            boolean isReserv = reservationPage.ReserveButton.isDisplayed();
            Assert.assertTrue(isReserv);

        }


    }

    @Then("User confirms the booking information")
    public void user_confirms_the_booking_information() {

        try {
            noDiscount = reservationPage.noDiscountText.isDisplayed();
            System.out.println(reservationPage.noDiscountText);
            Assert.assertTrue(noDiscount);
        } catch (Exception e) {

            clickJS(reservationPage.ReserveButton);
            waitFor(1);

            try {
                haveReservation = reservationPage.haveReservation.isDisplayed();
                System.out.println("SECOND");
            } catch (Exception a) {
                System.out.println("Rezervasyon işleminiz gerçekleşmektedir");
            }


        }

    }

    @Then("User confirms the booking")
    public void user_confirms_the_booking() {
        try {
            noDiscount = reservationPage.noDiscountText.isDisplayed();
            System.out.println(reservationPage.noDiscountText);

            Assert.assertTrue(noDiscount);
            Driver.closeDriver();

        } catch (Exception e) {
            try {
                Assert.assertTrue(reservationPage.haveReservation.isDisplayed());
                System.out.println("Aynı gün içerisinde rezervasyon bulunmaktadır");
                Driver.closeDriver();

            } catch (Exception c) {
                reservationPage.completeReservation.isDisplayed();
            }


        }


    }


    //..................................UPDATE..................................

    @Given("User clicks on the Reservation button")
    public void user_clicks_on_the_reservation_button() {
        waitFor(3);
        try {
            clickJS(loginPage.location_West);
        } catch (Exception e) {
            System.out.println("Konum istemedi");
        }

        clickJS(reservationPage.Reservations);

    }

    @Given("User clicks on the booking information for Update")
    public void user_clicks_on_the_booking_information_for_update() {
        waitFor(3);
        try {
            clickJS(reservationPage.reservationCard);

//            tapOnWithPoint(Driver.getDriver(), 750, 1100);
//            waitFor(2);


        } catch (Exception e) {

            updatePage.thereIsNoReservation.isDisplayed();
            System.out.println("There is no reservation to update ");


        }

    }

    @Given("User click on the Update reservation")
    public void user_click_on_the_update_reservation() {
        try {
            clickJS(updatePage.upDate);

        } catch (Exception e) {
            System.out.println("There is no reservation to update");

        }

    }

    @Given("User selects time for reservation for update")
    public void user_selects_time_for_reservation_for_update() {
        try {
            noDiscount = reservationPage.noDiscountText.isDisplayed();
            System.out.println(reservationPage.noDiscountText);
            Assert.assertTrue(noDiscount);
            System.out.println("Rezervasyon için indirimli saat bulunmamaktadır...");

        } catch (Exception e) {

            try {
                System.out.println("40 ı dene");
                clickJS(reservationPage.yuzde40);
                waitFor(1);
            } catch (Exception forty) {

                try {
                    System.out.println("%40 indirimli rezervasyon bulunmamaktadır");
                    System.out.println("20 dene1");
                    clickJS(reservationPage.yuzde20);
                    System.out.println("20 dene2");
                    waitFor(1);

                } catch (Exception twenty) {

                    try {
                        System.out.println("%20 indirimli rezervasyon bulunmamaktadır");
                        System.out.println("10 dene1");
                        clickJS(reservationPage.yuzde10);
                        System.out.println("10 dene2");
                    } catch (Exception ten) {

                        System.out.println("Rezervasyon bulunmamaktadır");
                    }
                }
            }


        }
        //  System.out.println("oneperson");
        //  clickJS(reservationPage.onePerson);

        waitFor(2);


    }

    @And("User verifies the update")
    public void userVerifiesTheUpdate() {
        clickJS(reservationPage.done);
        waitFor(3);
        reservationPage.completeReservation.isDisplayed();

    }

    //-----------------CANCEL........................

    @Given("User clicks on the booking information")
    public void user_clicks_on_the_booking_information() {

        try {
            clickJS(reservationPage.reservationCard);

            // tapOnWithPoint(Driver.getDriver(), 650, 1100);
            waitFor(3);
        } catch (Exception e) {
            System.out.println("There is no Reservation ");

        }

    }

    @Then("User clicks on the Cancel reservation")
    public void user_clicks_on_the_cancel_reservation() {
        try {
            reservationPage.CancelReservation.click();
            waitFor(1);
            reservationPage.Yes.click();
        } catch (Exception e) {

            System.out.println("There is no Reservation ");
        }

    }

    @Then("User verifies the canceled reservation")
    public void user_verifies_the_canceled_reservation() {
        try {
            Assert.assertTrue(reservationPage.confirmDeleted.isDisplayed());
        } catch (Exception e) {

            System.out.println("There is no Reservation ");
        }

    }


}
