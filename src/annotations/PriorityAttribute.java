package annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class PriorityAttribute {
    @BeforeClass
    public void SetUp()
    {
        System.out.println("Launch browser");
    }
    @Test(priority = 1)
    public void signIN()
    {
        System.out.println("Sign IN");
    }
    @Test(priority = 2)
    public void searchCustomer()
    {
        System.out.println("Search For Customer");
    }

    @Test(priority = 3)
    public void searchProduct()
    {
        System.out.println("Search For Product");
    }
    @Test(priority = 4)
    public void signOut()
    {
        System.out.println("Sign Out");
    }
    @AfterClass
    public void tearDown()
    {
        System.out.println("Clear cookies");
    }
}
