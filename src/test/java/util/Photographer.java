package util;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Photographer {

    private WebDriver driverPhoto;

    public Photographer(WebDriver driver) {
        driverPhoto = driver;
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driverPhoto).getScreenshotAs(OutputType.BYTES);
    }
}
