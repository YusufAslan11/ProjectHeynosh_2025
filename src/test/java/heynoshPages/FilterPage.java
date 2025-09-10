package heynoshPages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;


public class FilterPage extends ReusableMethods {

    public FilterPage() {

        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);

    }
    @AndroidFindBy(id = "com.dmall.mfandroid:id/listingFilterTV")
    public WebElement filtrele;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"openFilter\")")
    public WebElement openFilter;

    @AndroidFindBy(xpath = "(//android.widget.CheckBox[@text=\"New on Hey Nosh\"])[1]/android.widget.Image")
    public WebElement NewOnHeynosh;
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Show 36 results\"]")
    public WebElement getFilterResult1;
    @AndroidFindBy(uiAutomator = "text(\"Show 36 results\")")
    public WebElement filterResult;
    @AndroidFindBy(xpath = "(//android.widget.CheckBox[@text=\"50% discounted\"])[1]/android.widget.Image")
    public WebElement yuzde50discounted;
    @AndroidFindBy(xpath = "(//android.widget.CheckBox[@text=\"40% discounted\"])[1]/android.widget.Image")
    public WebElement yuzde40discounted;
    @AndroidFindBy(xpath = "(//android.widget.CheckBox[@text=\"30% discounted\"])[1]/android.widget.Image")
    public WebElement yuzde30discounted;
    @AndroidFindBy(xpath = "(//android.widget.CheckBox[@text=\"BBQ month\"])[1]/android.widget.Image")
    public WebElement BBQ;
    @AndroidFindBy(xpath = "(//android.widget.CheckBox[@text=\"Free parking\"])[1]/android.widget.Image")
    public WebElement freeParking;
    @AndroidFindBy(xpath = "(//android.widget.CheckBox[@text=\"Select the date you want to make a reservation\"])[1]/android.widget.Image")
    public WebElement forSwipe1;
    @AndroidFindBy(xpath = "(//android.widget.CheckBox[@text=\"All you can eat\"])[1]/android.widget.Image")
    public WebElement AllYouCanEat;
    @AndroidFindBy(xpath = "(//android.widget.CheckBox[@text=\"Fastfood\"])[1]/android.widget.Image")
    public WebElement Fastfood;
    @AndroidFindBy(xpath = "(//android.widget.CheckBox[@text=\"Breakfast\"])[1]/android.widget.Image")
    public WebElement Breakfast;
    @AndroidFindBy(xpath = "(//android.widget.CheckBox[@text=\"Burgers\"])[1]/android.widget.Image")
    public WebElement Burger;
    @AndroidFindBy(xpath = "(//android.widget.CheckBox[@text=\"Dinner\"])[1]/android.widget.Image")
    public WebElement Dinner;


}
