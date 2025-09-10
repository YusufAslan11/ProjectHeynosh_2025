package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public final class Driver {

    private Driver() {}

    public static UiAutomator2Options options;
    private static AndroidDriver driver;
    public static AppiumDriverLocalService service;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            options = new UiAutomator2Options()
                    .setAppPackage("com.heynosh.noshapp")
                    .setAppActivity("com.heynosh.noshapp.MainActivity")
                    .setAutomationName("uiautomator2")
                    .setNoReset(false)
                    .setNewCommandTimeout(Duration.ofMinutes(15));
            try {
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
