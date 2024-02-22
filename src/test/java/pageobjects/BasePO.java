package pageobjects;

import auxiliars.constants;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.Photographer;
import org.testng.log4testng.Logger;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public abstract class BasePO {

    protected WebDriver driverPO;
    protected WebElement webElement;
    protected List<WebElement> llistaWE;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    protected Photographer photographer;
    protected static final Logger LOGGER = Logger.getLogger(BasePO.class);
    private static final String DIRECTORI_SCREENSHOTS = "src/test/resources/screenshots/";

    public BasePO(WebDriver driver){
        driverPO = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(constants.ESPERA));
        js = (JavascriptExecutor) driverPO;
        PageFactory.initElements(driverPO, this);
        photographer = new Photographer(driverPO);
        LOGGER.info("Logger BasePO");
    }

    @Step("Mostrar final")
    public void mostraFinal(){
        photographer.takePhoto();
        js.executeScript("alert('Prova finalitzada correctament: " + System.getProperty("entorno")+ "')");
        // Espera un segon perquè l'alerta es mostri
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Accepta l'alerta
        Alert alert = driverPO.switchTo().alert();
        alert.accept();
        LOGGER.info("Logger MostraFinal");
    }

    @Step("retornaWExPath")
    protected WebElement retornaWExPath(String xPath){
        try{
            webElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
            webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        } catch (Exception e){
            Assert.fail("No s'ha trobat l'element per xPath: " + xPath);
        }
        photographer.takePhoto();
        return webElement;
    }

    @Step("retornaWExId")
    protected WebElement retornaWExId(String id){
        try{
            webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        } catch (Exception e){
            Assert.fail("No s'ha trobat l'element per Id: " + id);
        }
        photographer.takePhoto();
        return webElement;
    }

    private WebElement retornaWE(String literal){
        Assert.assertFalse(llistaWE.isEmpty(),"No s'han trobat elements per xPath: " + literal);
        webElement = llistaWE.get(0);
        return webElement;
    }

    public void captureScreenshot(String filename) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driverPO;
        File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(DIRECTORI_SCREENSHOTS + filename);
        FileUtils.copyFile(scrFile, destFile);
        LOGGER.info("captureScreenshot");
    }

}
