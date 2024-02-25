import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Feature("Test02")
public class Test02 {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    @Test(description = "Test02 TC01 - Prova correcta")
    @Description("PU2: Test02 TC01 - Prova correcta")
    public void tc01_OK() {
        pas1();
        pas2();
        System.out.println("Prova correcta");
    }

    @Step("Test02 PU2: Step01")
    public void pas1() {
        System.out.println("Step 01");
    }

    @Step("Test02 PU2: Step02")
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

    @Test(description = "Test02 PU2: Test04 - Prova correcta")
    public void PU2_tc04_OK(){
        Assert.assertTrue(true, "Prova passed: true == true");
    }

    @Test(description = "Test02 - TC05 Prova correcta")
    //@Ignore
    public void tc05_OK() {
        System.out.println("Test05 - Prova correcta");
    }


}

