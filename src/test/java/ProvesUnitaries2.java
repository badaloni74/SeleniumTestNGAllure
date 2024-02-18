import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Feature("ProvesUnitaries2")
public class ProvesUnitaries2 {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    @Test(description = "Test01 - Prova correcta")
    @Description("PU2: Test01 - Prova correcta")
    public void test01_OK() {
        pas1();
        pas2();
        System.out.println("Prova correcta");
    }

    @Step("PU2: Step01")
    public void pas1() {
        System.out.println("Step 01");
    }

    @Step("PU2: Step02")
    @Deprecated
    public void pas2() {
        System.out.println("Step 02");
    }


    @Test(description = "PU2: Test02 - Prova fallida")
    @Ignore
    public void test02_KO(){
        Assert.fail("Prova fallida");
    }

    @Test(description = "PU2: Test03 - Prova fallida: true == false")
    @Ignore
    public void test03_KO(){
        Assert.fail("Prova fallida: true == false");
    }

    @Test
    public void PU2_test04_OK(){
        Assert.assertTrue(true, "Prova passed: true == true");
    }

    @BeforeTest
    public void setUp2() {
        System.out.println("BeforeTest");
    }

    @BeforeTest
    @Step("PU2: BeforeTest-setUp2")
    public void setUp3() {
        System.out.println("BeforeTest");
    }

    @AfterTest
    public void tearDown() {
        System.out.println("AfterTest");
    }

    @Test(description = "PU2: Test05 Prova correcta")
    //@Ignore
    public void test05_OK() {
        System.out.println("Test05 - Prova correcta");
    }


}

