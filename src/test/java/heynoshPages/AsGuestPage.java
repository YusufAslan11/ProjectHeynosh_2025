package heynoshPages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AsGuestPage {
    public AsGuestPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }


    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Continue as guest\")")
    public WebElement enterAsGuest;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_one_time_button\")")
    public WebElement choiceNavigate;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sollomon Restaurant\")")
    public WebElement sollomonRestaurant;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please log in or sign up to continue your reservation.\")")
    public WebElement asguestErrorMessages;


}
