package annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DependencyAttribute {
    @Test
    public void setUp()
    {
        System.out.println("Launch browser");
    }
    @Test(dependsOnMethods = "setUp")
    public void openApplication()
    {
        System.out.println("Open Test Application");
    }
    @Test(dependsOnMethods = "openApplication")
    public void signIN()
    {
        System.out.println("Sign IN");
    }

    @Test(dependsOnMethods = "signIN")
    public void searchCustomer()
    {
        System.out.println("Search For Customer");
    }
    //when one test depends on multiple methods
    @Test(dependsOnMethods = {"openApplication","signIN"})
    public void searchProduct()
    {
        System.out.println("Search For Product");
    }
    @Test(dependsOnMethods = {"openApplication","signIN"})
    public void signOut()
    {
        System.out.println("Sign Out");
    }
    @Test(dependsOnMethods = {"openApplication","signIN"})
    public void tearDown()
    {
        System.out.println("Clear cookies");
    }
}
