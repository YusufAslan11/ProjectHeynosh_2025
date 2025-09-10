package utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import static utilities.Driver.getDriver;

public class ReusableMethods1 {

    private static Actions actions() { return new Actions(getDriver()); }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    String dateTimeString = LocalDateTime.now().format(formatter);
    String filePath = "C:\\Users\\yusuf\\IdeaProjects\\heynoshProje010925\\raporlar\\pictures.png";


    public static void longPress(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
    }

    public static void doubleClick(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("mobile: doubleClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
    }

    public static void clickJS(WebElement element) {
        waitForClickAbility(element, 10);
        ((JavascriptExecutor) getDriver()).executeScript("mobile: clickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
    }

    public static void dragAndDrop(WebElement element, double endX, double endY) {
        ((JavascriptExecutor) getDriver()).executeScript("mobile: dragGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
                        "endX", endX, "endY", endY, "speed", 5000));
    }

    public static void dragAndDrop(double startX, double startY, double endX, double endY) {
        ((JavascriptExecutor) getDriver()).executeScript("mobile: dragGesture",
                ImmutableMap.of("startX", startX, "startY", startY, "endX", endX, "endY", endY, "speed", 5000));
    }

    public static void dragAndDrop(double startX, double startY, double endX, double endY, int speed1to5) {
        ((JavascriptExecutor) getDriver()).executeScript("mobile: dragGesture",
                ImmutableMap.of("startX", startX, "startY", startY, "endX", endX, "endY", endY, "speed", 1000 * speed1to5));
    }

    public static void dragAndDrop(WebElement element, WebElement targetElement) {
        actions().clickAndHold(element).moveToElement(targetElement).release().perform();
    }

    // ---------- screen geometry ----------
    public static Point getMiddlePointOfTheScreen() {
        Dimension size = getDriver().manage().window().getSize();
        int x = size.getWidth() / 2;
        int y = size.getHeight() / 2;
        return new Point(x, y);
    }

    // ---------- swipe/scroll (mobile:) ----------
    public static void swipe(String fingerDirection, int speed1to100, int count) {
        Point midPoint = getMiddlePointOfTheScreen();
        for (int i = 0; i < count; i++) {
            waitFor(2);
            ((JavascriptExecutor) getDriver()).executeScript("mobile: swipeGesture",
                    ImmutableMap.of(
                            "left",   midPoint.getX() * 0.5,
                            "top",    midPoint.getY() * 0.5,
                            "width",  midPoint.getX(),
                            "height", midPoint.getY(),
                            "direction", fingerDirection.toLowerCase(),
                            "percent", 0.75,
                            "speed", speed1to100 * 1000
                    ));
        }
    }

    public static void swipe(WebElement element, String fingerDirection, int speed1to100) {
        waitFor(1);
        ((JavascriptExecutor) getDriver()).executeScript("mobile: swipeGesture",
                ImmutableMap.of(
                        "elementId", ((RemoteWebElement) element).getId(),
                        "direction", fingerDirection.toLowerCase(),
                        "percent", 0.75,
                        "speed", speed1to100 * 1000
                ));
    }

    public static void scroll1(String direction, int count) {
        Point midPoint = getMiddlePointOfTheScreen();
        for (int i = 0; i < count; i++) {
            waitFor(2);
            ((JavascriptExecutor) getDriver()).executeScript("mobile: scrollGesture",
                    ImmutableMap.of(
                            "left",   midPoint.getX() * 0.5,
                            "top",    midPoint.getY() * 0.5,
                            "width",  midPoint.getX(),
                            "height", midPoint.getY(),
                            "direction", direction.toLowerCase(),
                            "percent", 5,
                            "speed", 4000
                    ));
        }
    }

    public static void scroll1(WebElement element, String direction) {
        waitFor(2);
        ((JavascriptExecutor) getDriver()).executeScript("mobile: scrollGesture",
                ImmutableMap.of(
                        "elementId", ((RemoteWebElement) element).getId(),
                        "direction", direction.toLowerCase(),
                        "percent", 3
                ));
    }

    public static void scrollIntoView(String uiSelector) {
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ");";
        getDriver().findElement(AppiumBy.androidUIAutomator(command));
    }

    // ---------- actions-based drags ----------
    public static void scrollRight(WebElement element, int swipePercentage) {
        waitForClickAbility(element, 10);
        actions().clickAndHold(element).moveByOffset(calculateOffsetForLeftAndRightScroll(swipePercentage), 0).release().perform();
    }

    public static void scrollLeft(WebElement element, int swipePercentage, int count) {
        for (int i = 0; i < count; i++) {
            waitForClickAbility(element, 10);
            actions().clickAndHold(element).moveByOffset(-calculateOffsetForLeftAndRightScroll(swipePercentage), 0).release().perform();
            waitFor(1);
        }
    }

    // ---------- typing / waits ----------
    public static void enterText(WebElement element, String text) {
        waitToBeClickable(element, Duration.ofSeconds(10));
        element.sendKeys(text);
    }

    public static WebElement waitForClickAbility(WebElement element, int timeout) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(timeout))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForVisibility(WebElement element, int timeout) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void tapOn(WebElement element) {
        waitToBeClickable(element, Duration.ofSeconds(10));
        element.click();
    }

    public static void waitToBeClickable(WebElement element, Duration timeout) {
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitFor(int sec) {
        try { Thread.sleep(sec * 1000L); } catch (InterruptedException ignored) {}
    }

    // ---------- offsets ----------
    private static int calculateOffsetForUpAndDownScroll(int scrollAmount) {
        Dimension size = getDriver().manage().window().getSize();
        return (scrollAmount * size.getHeight()) / 100;
    }

    private static int calculateOffsetForLeftAndRightScroll(int scrollAmount) {
        Dimension size = getDriver().manage().window().getSize();
        return (scrollAmount * size.getWidth()) / 100;
    }

    // ---------- low-level W3C sequences ----------
    public void tapOnWithPoint(AndroidDriver driver, int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(tap));
    }

    public void dragGesture(AndroidDriver driver, WebElement element, int endX, int endY) {
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", endX,
                "endY", endY
        ));
    }

    public void swipeGesture(AndroidDriver driver, WebElement element, String direction, double percent, int speed) {
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", percent,
                "speed", speed
        ));
    }

    public void dragGesture(AndroidDriver driver, int startX, int startY, int endX, int endY) {
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "startX", startX, "startY", startY, "endX", endX, "endY", endY
        ));
    }

    public void scroll1(AppiumDriver driver, int scroll) throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.25);  // 0.10 kaydırma oranını etkiliyor

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        for (int i = 0; i < scroll; i++) {
            Sequence sequence1 = new Sequence(finger1, 1)
                    .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1, Duration.ofMillis(200)))
                    .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Collections.singletonList(sequence1));
        }
        Thread.sleep(300);
    }

    public By locateElementByText(String text) {
        return AppiumBy.androidUIAutomator("new UiSelector().text(\"" + text + "\")");
    }

    public void takeScreenshot1(String filePath) {
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try (FileOutputStream out = new FileOutputStream(new File(filePath))) {
            IOUtils.copy(new FileInputStream(scrFile), out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void contentDescClick(String text){
        getDriver().findElement(By.xpath("//*[@content-desc='" + text + "']")).click();
    }
}
