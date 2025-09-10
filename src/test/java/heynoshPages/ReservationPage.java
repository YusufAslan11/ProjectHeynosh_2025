package heynoshPages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ReservationPage {

    public ReservationPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }


    @AndroidFindBy(uiAutomator = "text(\"Search restaurant, cousine...\")")
    public WebElement findRestaurant;
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public WebElement sendRestaurant;
    @AndroidFindBy(uiAutomator = "text(\"Allow only while using the app\")")
    public WebElement allowOnlyWhile;
    @AndroidFindBy(uiAutomator = "text(\"While using the app\")")
    public WebElement WhileUsingTheApp;
    @AndroidFindBy(uiAutomator = "text(\"ID_174_1604058861547\")")
    public WebElement ID_174_1604058861547;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"reservationCard\")")
    public WebElement reservationCard;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Today\")")
    public WebElement today;

    @AndroidFindBy(uiAutomator = "text(\"There is no online availability for discounted hours.\")")
    public WebElement noDiscountText;
    @AndroidFindBy(uiAutomator = "text(\"You have a reservation at this time, please choose another discount\")")
    public WebElement haveReservation;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"-%10\"][1]")
    public WebElement yuzde10;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"-%20\"][1]")
    public WebElement yuzde20;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"%25\"][1]")
    public WebElement yuzde25;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"-%40\"][1]")
    public WebElement yuzde40;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"1\"]")
    public WebElement onePersonrez;
    @AndroidFindBy(uiAutomator = "text(\"Reserve\"))")
    public WebElement ReserveButtonOld;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"2 · Today\")")
    public WebElement TodayTwoPerson;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"2 · Tomorrow\")")
    public WebElement TomorrowTwoPerson;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Book a Table\")")
    public WebElement bookATable;


    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Reserve\"]")
    public WebElement ReserveButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Announce Your HeyNosh Reservation and Discount Upon Arrival\"]")
    public WebElement completeReservation;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Go to reservations\"]")
    public WebElement goToReservations;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Reservations\"]")
    public WebElement Reservations;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Upcoming\"]")
    public WebElement Upcoming;
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Cancel reservation\"]")
    public WebElement CancelReservation;
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Yes\"]")
    public WebElement Yes;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"You do not have an active reservation\"]")
    public WebElement confirmDeleted;
    @AndroidFindBy(uiAutomator = "text(\"You have a reservation at this time, please choose another discount\"))")
    public WebElement alreadyYouHaveReservationOld;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"You have a reservation at this time, please choose another discount\"]")
    public WebElement alreadyYouHaveReservation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"1\"]")
    public WebElement onePerson;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Done\"]")
    public WebElement done;

    @AndroidFindBy(uiAutomator = "text(\"Done\"))")
    public WebElement doneOld;


}
