import io.qameta.allure.Step;
import org.testng.annotations.*;
import pageobjects.GooglePageObject;
import auxiliars.iniciarWebDriver;
import io.qameta.allure.Description;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest implements iniciarWebDriver {

    private ChromeDriver driver;
    private GooglePageObject googlePO;
    private String paraula;

    @Test
    @Description("Cercar Badalona")
    public void buscarBadalona() throws InterruptedException {
        paraula = "Badalona";
        googlePO.escriureCerca(paraula);
        googlePO.clicarCercar();
        googlePO.validarResultat(paraula);
    }

    @Test
    @Description("Cercar Barcelona")
    public  void buscarBarcelona() throws InterruptedException {
        paraula = "Barcelona";
        googlePO.escriureCerca(paraula);
        googlePO.clicarCercar();
        googlePO.validarResultat(paraula);
    }

    @Test
    @Description("Cercar Londres")
    public void buscarLondres() throws InterruptedException {
        paraula = "Londres";
        googlePO.escriureCerca(paraula);
        googlePO.clicarCercar();
        googlePO.validarResultat(paraula);
    }

    @Test
    @Description("Cercar DFDFDFD")
    public void buscarDFDFDFD() throws InterruptedException {
        paraula = "DFDFDFD";
        googlePO.escriureCerca(paraula);
        googlePO.clicarCercar();
        googlePO.validarResultat(paraula);
    }

    @Description("Obrir el browser")
    public void iniciarTest() throws InterruptedException {
        System.out.println("Iniciar");
        driver = iniciaWebDriver();
        googlePO = new GooglePageObject(driver);
    }

    @Step("Finalitzar test")
    @AfterMethod
    @Description("final Test")
    public void finalTest() {
        System.out.println("After Tes");
        googlePO.mostraFinal();
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
        googlePO = null;
    }

    @BeforeMethod
    @Description("Before Test")
    public void beforeTest() throws InterruptedException {
        System.out.println("Before Test");
        iniciarTest();
    }

}
