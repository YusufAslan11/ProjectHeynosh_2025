package heynoshPages;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchPage {
    public SearchPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"1 Restaurants\")")
    public WebElement oneRestaurant;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"0 Restaurants\")")
    public WebElement zeroRestaurant;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"No matching restaurant has been found.\")")
    public WebElement noMatch;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"\\d+ Restaurants\")")
    public WebElement restaurantCount;


    @AndroidFindBy(className ="(android.widget.TextView)[4]" )
    public WebElement restResult;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sollomon Restaurant\"]")
    public WebElement Sollomon;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Sham Maza\"])[2]")
    public WebElement ShamMaza;

    @AndroidFindBy(xpath = "//android.widget.TextView[@textStartsWith('Deneme')]")
    public WebElement aranan;







}
