import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.*;
import io.qameta.allure.Feature;

//@Feature("Test01")
public class Test01 {
    /*public static void main(String[] args) {
        System.out.println("Hello World");
    }*/

    @Test(description = "Test01 - TC01 Prova correcta")
    public void tc01_OK() {
        pas1();
        pas2();
        System.out.println("Prova correcta");
    }

    @Step("Test01 - Step01")
    private void pas1() {
        System.out.println("Step 01");
    }

    @Step("Test01 - Step02")
    private void pas2() {
        System.out.println("Step 02");
    }

    //@Test(description = "Test02 - Prova fallida")
    public void test02_KO(){
        Assert.fail("Prova fallida");
    }

    //@Test(description = "Test03 - Prova fallida: true == false")
    public void test03_KO(){
        Assert.fail("Prova fallida: true == false");
    }

    @Test(description = "Test01 tc04 - Prova correcta")
    public void tc04_OK(){
        Assert.assertTrue(true, "Prova passed: true == true");
    }

    @Test(description = "Test01 tc05 - Prova correcta")
    //@Ignore
    public void tc05_OK() {
        System.out.println("Test05 - Prova correcta");
    }

    @Test(description = "Test01 tc06 - Prova correcta")
    @Parameters({"parametre1", "parametre2"})
    public void tc06_OK(String parametre1, String parametre2) {
        System.out.println("Test06 - Prova correcta: P1: " + parametre1 + " - P2: " + parametre2 );
    }

    @DataProvider
    public Object[][] dataProvider(){
        return new Object[][]{
                {"Sergi", "Llorca Cota 1"},
                {"Martí", "Llorca Cota 2"}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void tc07_OK(String nom, String cognoms){
        System.out.println("Test07 - Prova correcta: Nom: " + nom + " - Cognoms: " + cognoms );
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
}

