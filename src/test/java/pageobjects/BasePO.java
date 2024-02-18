package pageobjects;

import auxiliars.constants;
import util.Photographer;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public abstract class BasePO {

    protected WebDriver driverPO;
    protected WebElement webElement;
    protected List<WebElement> llistaWE;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    protected static Photographer photo;

    protected BasePO(WebDriver driver){
        driverPO = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(constants.ESPERA));
        js = (JavascriptExecutor) driverPO;
        PageFactory.initElements(driverPO, this);
        photo = new Photographer(driverPO);
    }

    public void mostraFinal(){
        js.executeScript("alert('Prova finalitzada correctament')");
        // Espera un segon perquè l'alerta es mostri
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Accepta l'alerta
        Alert alert = driverPO.switchTo().alert();
        alert.accept();
    }

    protected WebElement retornaWExPath(String xPath){
        try{
            webElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
            webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        } catch (Exception e){
            Assert.fail("No s'ha trobat l'element per xPath: " + xPath);
        }
        return webElement;
    }

    protected WebElement retornaWExId(String id){
        try{
            webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        } catch (Exception e){
            Assert.fail("No s'ha trobat l'element per Id: " + id);
        }
        return webElement;
    }

    private WebElement retornaWE(String literal){
        Assert.assertFalse(llistaWE.isEmpty(),"No s'han trobat elements per xPath: " + literal);
        webElement = llistaWE.get(0);
        return webElement;
    }

}
