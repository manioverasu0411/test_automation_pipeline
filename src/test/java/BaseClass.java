import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;

    String ActualTitle = "AutomationTalks - Learn Automation Testing";

    @BeforeMethod
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void navigatoURL() {
        driver.get("https://automationtalks.com/");
        System.out.println(driver.getTitle());

    }

    @Test
    public void Test1() {

        driver.get("https://automationtalks.com/");
        String ExpTitle = driver.getTitle();
        System.out.println("Test1 title is: "+driver.getTitle());
        Assert.assertEquals(ActualTitle, ExpTitle);

    }

    @Test
    public void Test2() {

        driver.get("https://automationtalks.com/");
        String ExpTitle = driver.getTitle();
        System.out.println("Test2 title is: "+driver.getTitle());
        Assert.assertEquals(ActualTitle, ExpTitle);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

