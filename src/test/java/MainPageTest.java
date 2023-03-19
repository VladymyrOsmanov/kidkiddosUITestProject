import Pages.*;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MainPageTest extends UseCaseBase {
    private static MainPage mainPage;
    public static final Logger logger = LogManager.getLogger(MainPageTest.class);

    @BeforeAll
    public static void classSetup(){ mainPage =new MainPage(); }
    @BeforeEach
    public void beforeTest(){ mainPage.navigateToMainPage(); }

    @Test
    public void mainPageLoadTest(){
        logger.info("Main page load text");
        Boolean success = mainPage.isLogoVisible();
        mainPage.takeScreenshot("MainPageTest");
        assertTrue(success);
    }

    @Test
    public void openContactUsPageTest(){
        logger.info("Contact Us page load text");
        ContactUsPage contactUsPage = mainPage.openContactUsTab();
        boolean isLoaded = contactUsPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }

    @Test
    public void openLoginPageTest(){
        logger.info("Login page load text");
        LoginPage loginPage = mainPage.openLoginPage();
        boolean isLoaded = loginPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }

    @Test
    public void openCartPageTest(){
        logger.info("Cart page load text");
        CartPage cartPage = mainPage.openCartPage();
        boolean isLoaded = cartPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }

    @Test
    public void openGiftCardPageTest(){
        logger.info("Gift Card page load text");
        GiftCardPage giftCardPage = mainPage.openGiftCardPage();
        boolean isLoaded = giftCardPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }

    @Test
    public void openGalleryPageTest(){
        logger.info("Gallery page load text");
        GalleryPage galleryPage = mainPage.openGalleryPage();
        boolean isLoaded = galleryPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }

    @Test
    public void openFAQsPageTest(){
        logger.info("FAQs page load text");
        FAQsPage faQsPage = mainPage.openFAQsPage();
        boolean isLoaded = faQsPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }

    @Test
    public void openBlogPageTest(){
        logger.info("Blog page load text");
        BlogPage blogPage = mainPage.openBlogPage();
        boolean isLoaded = blogPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }

    @Test
    public void openBookByLanguage_EnglishOnly_PageTest(){
        logger.info("'Book by Language' - 'English Only' page load text");
        BookByLanguage_EnglishOnly_Page bookByLanguageEnglishOnlyPage = mainPage.openBookByLanguage_EnglishOnly_Page();
        boolean isLoaded = bookByLanguageEnglishOnlyPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }
}
