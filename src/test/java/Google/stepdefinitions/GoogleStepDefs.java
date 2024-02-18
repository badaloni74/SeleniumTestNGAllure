package Google.stepdefinitions;

import Google.pageobjects.GooglePageObject;
import Google.stepdefinitions.auxiliars.iniciarWebDriver;
import Google.util.Photographer;
import io.qameta.allure.Description;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleStepDefs implements iniciarWebDriver {

    private ChromeDriver driver;
    private GooglePageObject googlePO;
    private Photographer photo = new Photographer(driver);

    public void setUp() {
        System.out.println("BeforeEach");
    }

    public void setAfterEach() {
        System.out.println("BeforeEach");
    }

    @Test
    @Description("iniciar")
    public void iniciar() throws InterruptedException {
        System.out.println("Iniciar");
        driver = iniciaWebDriver();
        googlePO = new GooglePageObject(driver);
        photo.takeScreenshot();
    }

    public void tearDown() {
        System.out.println("After");
        googlePO.mostraFinal();
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Description("Es navega a...")
    public void esNavegaA(String link) {
        driver.get("http://"+link);
        googlePO.clicarAcceptarCookies();
        photo.takeScreenshot();
    }

    @Test
    @Description("Es escriu al buscador...")
    public void queEscribimAlBuscador(String paraula) {
        googlePO.escriureCerca(paraula);
        photo.takeScreenshot();
    }

    @Test
    @Description("Es pulsa Cerca a Google")
    public void esPulsaCercaaGoogle() {
        googlePO.clicarCercar();
        photo.takeScreenshot();
    }

    @Test
    @Description("Es valida que apareix}")
    public void es_valida_que_apareix(String paraula) {
        googlePO.validarResultat(paraula);
        photo.takeScreenshot();
    }

}
