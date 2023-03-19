import Pages.*;
import Utils.UseCaseBase;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import static Pages.LoginPage.*;
import static org.junit.jupiter.api.Assertions.*;
public class LoginNegativeTests extends UseCaseBase {
    private static MainPage mainPage;
    public static final Logger logger = LogManager.getLogger(MainPageTest.class);


    @BeforeAll  public static void classSetup(){ mainPage =new MainPage(); }
    @BeforeEach  public void beforeTest(){ mainPage.navigateToMainPage(); }

    //Navigate to the home page
    @Test
    public void mainPageLoadTest(){
        logger.info("Main page load test");
        Boolean success = mainPage.isLogoVisible();
        mainPage.takeScreenshot("MainPageTest");
        assertTrue(success);
    }

    //Press login icon (top right corner, person icon) -> verify login screen is opened
    @Test
    public void mainPagePreesLoginIconTest(){
        logger.info("Main page press login icon test");
        Boolean success = mainPage.isLogoVisible();
        assertTrue(success);

        LoginPage loginPage = mainPage.openLoginPage();
        boolean isPageLoaded = loginPage.isPageTitleVisible();
        assertTrue(isPageLoaded);
    }

    //Try to log in with an empty username and password (verify error message)
    @Test
    public void loginWithEmptyUsernameAndPasswordTest(){
        logger.info("Login with empty username & password test");
        LoginPage loginPage = mainPage.openLoginPage();
        boolean isPageLoaded = loginPage.isPageTitleVisible();
        assertTrue(isPageLoaded);

        boolean isButtonLoaded = loginPage.isSignInButtonVisible();
        assertTrue(isButtonLoaded);

        webDriver.findElement(By.xpath(SING_IN_HEADER)).click();
        WebElement error = webDriver.findElement(By.xpath("//*[text() = 'Incorrect email or password.']"));
        assertNotNull(error);
    }

    //Try to log in with an incorrect username and password (verify error message)
    @Test
    public void loginWithIncorrectUsernameAndPasswordTest(){
        logger.info("Login with incorrect username & password test");
        LoginPage loginPage = mainPage.openLoginPage();
        boolean isPageLoaded = loginPage.isPageTitleVisible();
        assertTrue(isPageLoaded);

        boolean isButtonLoaded = loginPage.isSignInButtonVisible();
        assertTrue(isButtonLoaded);

        WebElement emailTextBox = webDriver.findElement(By.xpath(email_Element));
        assertNotNull(emailTextBox);
        emailTextBox.sendKeys("vova@gmail.com");
        String emailValue = emailTextBox.getAttribute("value") ;
        assertEquals("vova@gmail.com", emailValue);

        WebElement passwordTextBox = webDriver.findElement(By.xpath(password_Element));
        assertNotNull(passwordTextBox);
        passwordTextBox.sendKeys("123456");
        String passValue = passwordTextBox.getAttribute("value") ;
        assertEquals("123456", passValue);

        webDriver.findElement(By.xpath(SING_IN_HEADER)).click();
        WebElement error = webDriver.findElement(By.xpath("//*[text() = 'Incorrect email or password.']"));
        assertNotNull(error);
    }
}
