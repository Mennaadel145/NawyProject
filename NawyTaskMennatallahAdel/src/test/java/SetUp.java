import org.example.HomePage;
import org.example.LoginPage;
import org.example.OrderPage;
import org.example.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SetUp {
    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegistrationPage registrationPage;
    protected OrderPage orderPage;

    @BeforeClass
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--ignore-ssl-errors=yes");
        driver = new ChromeDriver(chromeOptions);
        goHomePage();


    }
    public void goHomePage(){
        driver.get("https://www.demoblaze.com");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
//        homePage.clickLoginButton();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
