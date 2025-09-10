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

import static utilities.Driver.getDriver;

public class ReusableMethods {

    private static Actions actions() { return new Actions(getDriver()); }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    String dateTimeString = LocalDateTime.now().format(formatter);
    String filePath = "C:\\Users\\yusuf\\IdeaProjects\\heynoshProject_NowUp0404\\raporlar\\pictures.png";

    // ---------- Long Press ----------
    // Bir öğeye uzun tıklama (long press) yapar
    public static void longPress(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
    }

    // ---------- Double Click ----------
    // Bir öğeye çift tıklama (double click) yapar
    public static void doubleClick(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("mobile: doubleClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
    }

    // ---------- Click JS ----------
    // JavaScript kullanarak bir öğeye tıklama işlemi yapar
    public static void clickJS(WebElement element) {
        waitForClickAbility(element, 10);
        ((JavascriptExecutor) getDriver()).executeScript("mobile: clickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
    }

    // ---------- Drag and Drop ----------
    // Belirtilen öğeyi belirli X, Y koordinatlarına sürükler
    public static void dragAndDrop(WebElement element, double endX, double endY) {
        ((JavascriptExecutor) getDriver()).executeScript("mobile: dragGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
                        "endX", endX, "endY", endY, "speed", 5000));
    }

    // ---------- Get Middle Point of the Screen ----------
    // Ekranın orta noktasının koordinatlarını döndürür
    public static Point getMiddlePointOfTheScreen() {
        Dimension size = getDriver().manage().window().getSize();
        int x = size.getWidth() / 2;
        int y = size.getHeight() / 2;
        return new Point(x, y);
    }

    // ---------- Swipe ----------
    // Sayfayı sağa, sola, yukarı veya aşağı kaydırır
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
                            "percent", 30,
                            "speed", speed1to100 * 1000
                    ));
        }
    }

    // ---------- Scroll ----------
    // Sayfayı yukarı veya aşağı kaydırır
    public static void scroll_n(String direction, int count) {
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

    // ---------- Scroll Into View ----------
    // Belirtilen öğeyi kaydırarak görünür hale getirir
    public static void scrollIntoView(String uiSelector) {
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ");";
        getDriver().findElement(AppiumBy.androidUIAutomator(command));
    }

    // ---------- Enter Text ----------
    // Bir öğeye metin girer
    public static void enterText(WebElement element, String text) {
        waitToBeClickable(element, Duration.ofSeconds(10));
        element.sendKeys(text);
    }

    // ---------- Wait for Clickability ----------
    // Bir öğe tıklanabilir hale gelene kadar bekler
    public static WebElement waitForClickAbility(WebElement element, int timeout) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(timeout))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    // ---------- Wait for Visibility ----------
    // Bir öğe görünür hale gelene kadar bekler
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(element));
    }

    // ---------- Tap on ----------
    // Bir öğeye tıklama işlemi yapar
    public static void tapOn(WebElement element) {
        waitToBeClickable(element, Duration.ofSeconds(10));
        element.click();
    }

    // ---------- Wait to be Clickable ----------
    // Bir öğe tıklanabilir olana kadar bekler
    public static void waitToBeClickable(WebElement element, Duration timeout) {
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(element));
    }

    // ---------- Wait ----------
    // Belirtilen süre kadar bekler
    public static void waitFor(int sec) {
        try { Thread.sleep(sec * 1000L); } catch (InterruptedException ignored) {}
    }

    // ---------- Calculate Offset for Up and Down Scroll ----------
    // Yukarı ve aşağı kaydırma için kaydırma mesafesini hesaplar
    private static int calculateOffsetForUpAndDownScroll(int scrollAmount) {
        Dimension size = getDriver().manage().window().getSize();
        return (scrollAmount * size.getHeight()) / 100;
    }

    // ---------- Calculate Offset for Left and Right Scroll ----------
    // Sağa ve sola kaydırma için kaydırma mesafesini hesaplar
    private static int calculateOffsetForLeftAndRightScroll(int scrollAmount) {
        Dimension size = getDriver().manage().window().getSize();
        return (scrollAmount * size.getWidth()) / 100;
    }
//
//    // ---------- Tap on with Point ----------
//    // Belirtilen koordinatlara tıklama işlemi yapar
//    public void tapOnWithPoint(AndroidDriver driver, int x, int y) {
//        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        Sequence tap = new Sequence(finger, 1);
//        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
//        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        driver.perform(List.of(tap));
//    }

    // ---------- Drag Gesture ----------
    // Öğeyi belirtilen koordinatlara sürükler
    public void dragGesture(AndroidDriver driver, WebElement element, int endX, int endY) {
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", endX,
                "endY", endY
        ));
    }

    // ---------- Swipe Gesture ----------
//    // Öğeyi belirtilen yönde kaydırır
//    public void swipeGesture(AndroidDriver driver, WebElement element, String direction, double percent, int speed) {
//        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) element).getId(),
//                "direction", direction,
//                "percent", percent,
//                "speed", speed
//        ));
//    }



    public void swipeGesture(String direction, double percent, int speed) {
        // Sayfanın sadece 2 satır kayması için percent değeri küçük tutulmalı
        double scrollPercent = 5;  // Kaydırma oranını %5 olarak belirliyoruz, 2 satır için uygun olabilir

        // Mevcut Appium driver'ını getDriver() fonksiyonu ile alıyoruz
        AppiumDriver driver = getDriver();

        // Kaydırma işlemini başlatıyoruz
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "direction", direction,   // Kaydırma yönü (up, down, left, right)
                "percent", scrollPercent, // Kaydırma mesafesini %5 yapıyoruz
                "speed", speed            // Kaydırma hızı
        ));
    }


    // ---------- Drag Gesture with Coordinates ----------
    // Başlangıç ve bitiş koordinatları ile öğeyi sürükler
    public void dragGesture(AndroidDriver driver, int startX, int startY, int endX, int endY) {
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "startX", startX, "startY", startY, "endX", endX, "endY", endY
        ));
    }

    // ---------- Scroll ----------
    // Sayfayı kaydırma işlemi yapar
    public void scroll(AppiumDriver driver, int scroll) throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.25);

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

    // ---------- Locate Element By Text ----------
    // Belirtilen metinle öğe arar
    public By locateElementByText(String text) {
        return AppiumBy.androidUIAutomator("new UiSelector().text(\"" + text + "\")");
    }

    // ---------- Take Screenshot ----------
    // Ekran görüntüsü alır ve belirtilen dosyaya kaydeder
    public void takeScreenshot1(String filePath) {
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try (FileOutputStream out = new FileOutputStream(new File(filePath))) {
            IOUtils.copy(new FileInputStream(scrFile), out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ---------- Content Desc Click ----------
    // Belirtilen content-desc ile öğeye tıklama yapar
    public void contentDescClick(String text){
        getDriver().findElement(By.xpath("//*[@content-desc='" + text + "']")).click();
    }
}
