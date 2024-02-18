package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GooglePageObject extends BasePO {

    private final String ID_CERCA_TEXTBOX = "APjFqb";
    private final String ID_RESULTATS_LABEL = "result-stats";
    private final String XPATH_CERCA_BUTTON = "//input[@value='Cerca de Google']";
    private final String ID_ACCEPTAR_COOKIES = "L2AGLb";
    private final String URL_GOOGLE="https://www.google.cat";

    public GooglePageObject(WebDriver driver){
        super(driver);
        navegarAGoogle();
    }

    @Step("Navegar a Google")
    private void navegarAGoogle(){
        driverPO.get(URL_GOOGLE);
        clicarAcceptarCookies();
        photo.takeScreenshot();
    }

    @Step("Escriure {cerca}")
    public void escriureCerca(String cerca){
        retornaWExId(ID_CERCA_TEXTBOX).clear();
        webElement.sendKeys(cerca);
        photo.takeScreenshot();
    }

    @Step("Clicar Cercar")
    public void clicarCercar(){
        retornaWExPath(XPATH_CERCA_BUTTON).click();
    }

    @Step("Validar Resultat")
    public void validarResultat(String paraula) throws InterruptedException {
        photo.takeScreenshot();
        Thread.sleep(2000);
        String resultats = retornaWExId(ID_RESULTATS_LABEL).getText();
        Assert.assertTrue( resultats.contains("Aproximadament"), "La consulta no retorna cap resultat per " + paraula );
        Assert.assertTrue( resultats.contains("resultats"), "La consulta no retorna cap resultat per " + paraula );
    }

    @Step("Clicar Acceptar Cookies")
    public void clicarAcceptarCookies(){
        if(retornaWExId(ID_ACCEPTAR_COOKIES).isDisplayed()){
            photo.takeScreenshot();
            webElement.click();
        }
    }

}
