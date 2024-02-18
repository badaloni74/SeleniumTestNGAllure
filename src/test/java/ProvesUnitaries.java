import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.qameta.allure.Feature;

@Feature("ProvesUnitaries")
public class ProvesUnitaries {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    @Test(description = "Test01 - Prova correcta")
    public void test01_OK() {
        pas1();
        pas2();
        System.out.println("Prova correcta");
    }

    @Step("Step01")
    private void pas1() {
        System.out.println("Step 01");
    }

    @Step("Step02")
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

    @Test
    public void test04_OK(){
        Assert.assertTrue(true, "Prova passed: true == true");
    }

    @BeforeTest
    public void setUp() {
        System.out.println("BeforeTest");
    }

    @AfterTest
    public void tearDown() {
        System.out.println("AfterTest");
    }

    @Test(description = "Test05 Prova correcta")
    //@Ignore
    public void test05_OK() {
        System.out.println("Test05 - Prova correcta");
    }


}

