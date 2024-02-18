package Google.pageobjects;

import Google.arquitectura.BasePO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GooglePageObject extends BasePO {

    private final String ID_CERCA_TEXTBOX = "APjFqb";
    private final String ID_RESULTATS_LABEL = "result-stats";
    private final String XPATH_CERCA_BUTTON = "//input[@value='Cerca de Google']";
    private final String ID_ACCEPTAR_COOKIES = "L2AGLb";

    protected boolean validarPagina() {
        return false;
    }

    public GooglePageObject(WebDriver driver){
        super(driver);
    }

    public void escriureCerca(String cerca){
        retornaWExId(ID_CERCA_TEXTBOX).clear();
        webElement.sendKeys(cerca);
        photo.takeScreenshot();
    }

    public void clicarCercar(){
        retornaWExPath(XPATH_CERCA_BUTTON).click();
    }

    public void validarResultat(String paraula){
        photo.takeScreenshot();
        String resultats = retornaWExId(ID_RESULTATS_LABEL).getText();
        Assert.assertTrue( resultats.contains(paraula), "La consulta no retorna cap resultat per " + paraula );
    }

    public void clicarAcceptarCookies(){
        if(retornaWExId(ID_ACCEPTAR_COOKIES).isDisplayed()){
            photo.takeScreenshot();
            webElement.click();
        }
    }

}
