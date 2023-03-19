package Utils;
import Pages.BasePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;

public class UseCaseBase {

    public static WebDriver webDriver;
    private static BasePage page;

    @BeforeAll
    public static void setupMain() {
        page = new BasePage();
        webDriver = SharedDriver.getWebDriver(SharedDriver.Broswer.CHROME);
        page.setWebDriver(webDriver);


    }

    @AfterAll
    public static void tearDownMain() {
    SharedDriver.closeDriver();
    webDriver = null;
    }
}
