package annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DemoAnnotations {
    public WebDriver driver;
    @BeforeSuite
    public void beforeSuite()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PMonaheng\\Desktop\\selenium tools\\chromedriver.exe");
        System.out.println("Chrome - Set Up System Property");
    }

    @BeforeTest
    public void beforeTest()
    {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("Open Chrome");
    }

    @BeforeClass
    public void beforeClass()
    {
        String baseURL = "http://demo.guru99.com/payment-gateway/index.php";
        driver.get(baseURL);
        System.out.println("Open Test Application");
    }

    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("Sign In");
    }

    @Test
    public void searchCustomer()
    {

        //Selecting quantity
        Select options= new Select(driver.findElement(By.xpath("//select")));
        options.selectByIndex(4);
        List<WebElement> elementCount = options.getOptions();
        int quantity =Integer.parseInt(elementCount.get(4).getText());
        System.out.println(elementCount.get(4).getText());

        //Clicking Buy Now button
        driver.findElement(By.xpath("//input[@class='button special']")).click();

        //Validating the price on The Pay Amount and the Pay button
        String price= driver.findElement(By.xpath("//section/div/form/input")).getAttribute("value");
        Double convertPrice= Double.parseDouble(price);
        System.out.println("The price is $"+(convertPrice/quantity));

        System.out.println(convertPrice);
        String price2= driver.findElement(By.xpath("//input[@name='submit']")).getAttribute("value");
        //price2String substring(int beginIndex, int endIndex)
        Double convertPrice2= Double.parseDouble(price2.substring(5,price2.length()-1));
        System.out.println(convertPrice2);
        if(convertPrice.equals(convertPrice2))
        {
            System.out.println("The price on the Pay Amount is $"+convertPrice+" and the price on the Pay button is $"+convertPrice2+". Therefore the prices are the same");
        }
        else
        { driver.close();
            System.out.println("The prices are NOT the same");
        }
        System.out.println("Search For Customer");
    }

    @Test
    public void searchProduct()
    {
        //inputting the Card number
        driver.findElement(By.xpath("//input[@id='card_nmuber']")).sendKeys("5454545454545454");
        //selecting the Expiry month
        Select month= new Select(driver.findElement(By.id("month")));
        month.selectByIndex(4);
        //selecting the expiry year
        Select year= new Select(driver.findElement(By.id("year")));
        year.selectByIndex(6);
        //inputting the CVV number
        driver.findElement(By.id("cvv_code")).sendKeys("545");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        System.out.println("Search For Product");
    }

    @AfterMethod
    public void afterMethod()
    {
        System.out.println("Sign Out");
    }

    @AfterClass
    public void afterClass()
    {
        System.out.println("Close Test Application");
    }

    @AfterTest
    public void afterTest()
    {
        driver.close();
        System.out.println("Close Chrome");
    }

    @AfterSuite
    public void afterSuite()
    {
        System.out.println("Chrome - Clean Up All Cookies");
    }
}
