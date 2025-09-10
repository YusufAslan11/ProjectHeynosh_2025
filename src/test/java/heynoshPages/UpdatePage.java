package heynoshPages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UpdatePage {
    public UpdatePage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @AndroidFindBy(uiAutomator = "text(\"Update reservation\")")
    public WebElement upDate;
    @AndroidFindBy(uiAutomator = "text(\"You do not have an active reservation\")")
    public WebElement  thereIsNoReservationOld;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"You do not have an active reservation\"]")
    public WebElement thereIsNoReservation;


}
