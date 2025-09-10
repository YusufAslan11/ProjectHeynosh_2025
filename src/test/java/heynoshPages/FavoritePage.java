package heynoshPages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

public class FavoritePage extends ReusableMethods {
    public FavoritePage() {
            PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").instance(5)")
    public WebElement favoriteIcon;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").instance(2)")
    public WebElement leftButton;

    @AndroidFindBy(uiAutomator = "text(\"favorite\")")
    public WebElement favoriteIcon1;

    @AndroidFindBy(uiAutomator = "text(\"Favorites\")")
    public WebElement favoriteButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(21)")
    public WebElement selectRestaurant;

}
