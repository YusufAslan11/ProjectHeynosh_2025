package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
    private WebDriver driver;

    public ScreenshotUtil(WebDriver driver) {
        this.driver = driver;
    }

    // Full page screenshot
    public void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(fileName));
    }

    // Element screenshot
    public void takeElementScreenshot(WebElement element, String fileName) throws IOException {
        File srcFile = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(fileName));
    }

}
