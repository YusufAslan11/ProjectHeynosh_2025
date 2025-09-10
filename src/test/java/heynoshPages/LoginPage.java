package heynoshPages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ScreenshotUtil;

import java.io.IOException;



public class LoginPage {
    public LoginPage() {

        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }


    @AndroidFindBy(uiAutomator = "text(\"Log in\")")
    public WebElement loginOld;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log in\")")
    public WebElement login;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    public WebElement loginMailOld;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"ion-input-0\")")
    public WebElement loginMail;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"ion-input-1\")")
    public WebElement loginPassword;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log in\")")
    public WebElement loginButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please enter a valid email address\")")
    public WebElement loginFailMail;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"You have entered an incorrect email or password. Please try again.\")")
    public WebElement loginFailpass;



    @AndroidFindBy(xpath = "//android.app.Dialog/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View")
    public WebElement loginMail1;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    public WebElement loginPasswordOld;

    @AndroidFindBy(uiAutomator = "text(\"Amsterdam - West\")")
    public WebElement location_West;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(24)")
    public WebElement location_West2;

    @AndroidFindBy(className = "android.widget.Button")
    public WebElement loginPassword1;

    @AndroidFindBy(uiAutomator = "text(\"Yusuf AslanShow profile\")")
    public WebElement YusufAslanShow;

    @AndroidFindBy(uiAutomator = "text(\"* You have entered an invalid email or password\")")
    public WebElement passwordFail;


    @AndroidFindBy(uiAutomator = "text(\"Sign out\")")
    public WebElement Signout;


    public void captureLoginPageScreenshot() throws IOException, IOException {
        ScreenshotUtil screenshotUtil = new ScreenshotUtil(Driver.getDriver());
        screenshotUtil.takeScreenshot("screenshots/LoginPage.png");
    }



}
