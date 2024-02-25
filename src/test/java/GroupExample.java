import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupExample
{

    @Test(groups = {"Grup1"})
    public void engeguemCotxe(){
        System.out.println("Cotxe engegat");
    }

    @Test(groups = {"Grup1"}, dependsOnMethods = {"engeguemCotxe"})
    public void conduimCotxe(){
        System.out.println("Cotxe conduit");
    }

    @Test(groups = {"Grup2"}, dependsOnMethods = {"conduimCotxe", "engeguemCotxe"})
    public void apaguemCotxe(){
        System.out.println("Cotxe apagat");
        Assert.fail();
    }

    @Test(groups = {"Grup2"}, dependsOnMethods = {"apaguemCotxe"})
    public void apaguemCotxe2(){
        System.out.println("Cotxe apagat");
    }

}
