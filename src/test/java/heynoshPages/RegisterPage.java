package heynoshPages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegisterPage {
    public RegisterPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }


    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign up free\")")
    public WebElement signupForFree;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    public WebElement fullName;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    public WebElement email;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"ion-input-2\")")
    public WebElement password;

    @AndroidFindBy(uiAutomator = "text(\"Continue\")")
    public WebElement Continue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Agree and Continue\"]")
    public WebElement AgreeAndContinue;

    @AndroidFindBy(uiAutomator = "text(\"Don’t allow\")")
    public WebElement dontAllow;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    public WebElement EmailAndPassword;

    @AndroidFindBy(xpath = "//android.webkit.WebView[@text=\"Heynosh\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]")
    public WebElement Skipvideo;

    @AndroidFindBy(uiAutomator = "text(\"Allow\")")
    public WebElement Allow;

    @AndroidFindBy(uiAutomator = "text(\"While using the app\")")
    public WebElement WhileUsingTheApp;

    @AndroidFindBy(uiAutomator = "text(\"Account\")")
    public WebElement Account;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"ttyusuf18@gmail.com\")")
    public WebElement registeredMail;

    @AndroidFindBy(uiAutomator =
            "new UiSelector().className(\"android.widget.TextView\").textContains(\"@\")")
    public WebElement assertRegisteredEmail;   // e-mail’i gösteren TextView

    @AndroidFindBy(uiAutomator = "text(\"Profile\")")
    public WebElement Profile;

    @AndroidFindBy(uiAutomator = "text(\"* Please enter a valid email address!\")")
    public WebElement InvalidEmail;

    @AndroidFindBy(uiAutomator = "text(\"* Must contain at least 6 characters\")")
    public WebElement InvalidPassword;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please enter your name\")")
    public WebElement fail_fullname_Empty;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Password must be at least 6 characters long\")")
    public WebElement fail_password_MissingCharacter;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please enter a valid email address\")")
    public WebElement fail_mail_invalidMail;



}
