import org.example.HomePage;
import org.example.LoginPage;
import org.example.OrderPage;
import org.example.RegistrationPage;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.util.logging.Logger;

public class TestCases extends SetUp {
//    private static final Logger log = (Logger) LoggerFactory.getLogger(TestCases.class);
//    SoftAssert softAssert = new SoftAssert();
    @Test (priority = 0)
    public void register(){
//        goHomePage();
        RegistrationPage registrationPage = homePage.clickSignUpButton();
        registrationPage.register("Testingtest@test.com","testing");
        Assert.assertEquals(registrationPage.getAlertMessage(),"This user already exist.");
        registrationPage.handleRegisterAlert();
        registrationPage.closeRegisterForm();
    }
    @Test (priority = 1)
    public void login(){
//        goHomePage();
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.enterUserName("testing1@test.com");
        loginPage.enterPassWord("test");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.logged());

//       softAssert.assertEquals();
    }
    @Test (priority = 2)
    public void placeOrder(){
        homePage.scrollToBottom();
        homePage.goToNextPage();
        homePage.goToNextPage();
        System.out.println("gggggggg");
        OrderPage orderPage1 = homePage.clickOnTheItem();
        orderPage.addToCart();
        orderPage.addToCart();
        orderPage.placeOrder();
        orderPage.fillInData("test-name",
                "test-country","test-city",
                "testcard","test-month",
                "test-year");
    }
    @Test (priority = 3)
    public void logout(){
        homePage.clickLogoutButton();

    }

}
