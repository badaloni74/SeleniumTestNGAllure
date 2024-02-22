import io.qameta.allure.Step;
import org.testng.annotations.*;
import pageobjects.GooglePageObject;
import auxiliars.iniciarWebDriver;
import io.qameta.allure.Description;
import org.openqa.selenium.chrome.ChromeDriver;
import util.LectorPropietats;
import java.io.IOException;

public class GoogleTest implements iniciarWebDriver {

    private ChromeDriver driver;
    private GooglePageObject googlePO;
    private String paraula;
    LectorPropietats lectorPropietats=new LectorPropietats("TST");

    @Test(priority = 3)
    @Description("Cercar Badalona - Prioritat 3")
    public void buscarBadalona() throws InterruptedException, IOException {
        paraula = lectorPropietats.getProperty("paraula1");
        try {
            googlePO.escriureCerca(paraula);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        googlePO.clicarCercar();
        googlePO.validarResultat(paraula);
    }

    @Test(priority = 2)
    @Description("Cercar Barcelona - Prioritat 2")
    public  void buscarBarcelona() throws InterruptedException, IOException {
        paraula = lectorPropietats.getProperty("paraula2");
        googlePO.escriureCerca(paraula);
        googlePO.clicarCercar();
        googlePO.validarResultat(paraula);
    }

    @Test(priority = 1)
    @Description("Cercar Londres - Prioritat 1")
    public void buscarLondres() throws InterruptedException, IOException {
        paraula = lectorPropietats.getProperty("paraula3");
        googlePO.escriureCerca(paraula);
        googlePO.clicarCercar();
        googlePO.validarResultat(paraula);
    }

    @Test(priority = 0)
    @Description("Cercar DFDFDFD - Prioritat 0")
    public void buscarDFDFDFD() throws InterruptedException, IOException {
        paraula = lectorPropietats.getProperty("paraula4");
        googlePO.escriureCerca(paraula);
        googlePO.clicarCercar();
        googlePO.validarResultat(paraula);
    }

    @Description("Obrir el browser")
    public void iniciarTest() throws InterruptedException, IOException {
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
    public void beforeTest() throws InterruptedException, IOException {
        System.out.println("Before Test");
        iniciarTest();
    }

}
