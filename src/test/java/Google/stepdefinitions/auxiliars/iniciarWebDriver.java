package Google.stepdefinitions.auxiliars;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public interface iniciarWebDriver {

    default ChromeDriver iniciaWebDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", constants.PATH_CHROME_DRIVER);
        //WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-popup-blocking");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        return driver;
    }

}
