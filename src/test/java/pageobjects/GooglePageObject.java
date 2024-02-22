package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.Photographer;

import java.io.IOException;

public class GooglePageObject extends BasePO {

    private final String ID_CERCA_TEXTBOX = "APjFqb";
    private final String ID_RESULTATS_LABEL = "result-stats";
    private final String XPATH_CERCA_BUTTON = "//input[@value='Cerca de Google']";
    private final String ID_ACCEPTAR_COOKIES = "L2AGLb";
    private final String URL_GOOGLE="https://www.google.cat";


    public GooglePageObject(WebDriver driver) throws IOException {
        super(driver);
        navegarAGoogle();
        photographer = new Photographer(driver);
    }

    @Step("Navegar a Google")
    private void navegarAGoogle() throws IOException {
        photographer.takePhoto();
        driverPO.get(URL_GOOGLE);
        clicarAcceptarCookies();
    }

    @Step("Escriure {cerca}")
    public void escriureCerca(String cerca) throws IOException {
        retornaWExId(ID_CERCA_TEXTBOX).clear();
        webElement.sendKeys(cerca);
        captureScreenshot("EscriureCerca.png");
        //photographer.takePhoto();
    }

    @Step("Clicar Cercar")
    public void clicarCercar() throws IOException {
        retornaWExPath(XPATH_CERCA_BUTTON).click();
        captureScreenshot("Cercar.png");
        //photographer.takePhoto();
    }

    @Step("Validar Resultat")
    public void validarResultat(String paraula) throws InterruptedException, IOException {
        //photographer.takePhoto();
        captureScreenshot("ValidarResultat.png");
        Thread.sleep(4000);
        String resultats = retornaWExId(ID_RESULTATS_LABEL).getText();
        Assert.assertTrue( resultats.contains("Aproximadament"), "La consulta no retorna cap resultat per " + paraula );
        Assert.assertTrue( resultats.contains("resultats"), "La consulta no retorna cap resultat per " + paraula );
    }

    @Step("Clicar Acceptar Cookies")
    public void clicarAcceptarCookies() throws IOException {
        if(retornaWExId(ID_ACCEPTAR_COOKIES).isDisplayed()){
            //photographer.takePhoto();
            captureScreenshot("ClicarAcceptarCookies.png");
            webElement.click();
        }
    }

}
