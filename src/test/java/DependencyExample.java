import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyExample
{

    @Test
    public void engeguemCotxe(){
        System.out.println("Cotxe engegat");
    }

    @Test(dependsOnMethods = {"engeguemCotxe"})
    public void conduimCotxe(){
        System.out.println("Cotxe conduit");
    }

    @Test(dependsOnMethods = {"conduimCotxe", "engeguemCotxe"})
    public void apaguemCotxe(){
        System.out.println("Cotxe apagat");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = {"apaguemCotxe"})
    public void apaguemCotxe2(){
        System.out.println("Cotxe apagat");
    }

}
