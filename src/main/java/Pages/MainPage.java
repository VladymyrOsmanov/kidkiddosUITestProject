package Pages;
import Consts.Consts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MainPage extends BasePage{
    private static final String LOGO_IMG = "//img[@itemprop= 'logo']";
    private static final String CONTACT_US_OPTION= "//a[text()='Contact us']";
    private static final String LOGIN_OPTION ="//*[@class= 'icon icon-login']";
    private static final String CART_OPTION ="//*[@class='icon icon-cart']";
    private static final String GIFT_CARD_OPTION ="//a[@class = 'site-nav__link site-nav__link--main' and text()='Gift Card']";
    private static final String GALLERY_OPTION ="//a[@class = 'site-nav__link site-nav__link--main' and text()='Gallery']";
    private static final String FAQS_OPTION ="//a[@class = 'site-nav__link site-nav__link--main' and text()='FAQs']";
    private static final String BLOG_OPTION ="//a[@class = 'site-nav__link site-nav__link--main' and text()='Blog']";
    public static final String Books_by_Language_OPTION ="//a[@class = 'site-nav__link site-nav__link--main' and @aria-controls= 'SiteNavLabel-books-by-language']";


    public void navigateToMainPage(){
    webDriver.get(Consts.MAIN_URL);
    }
    public boolean isLogoVisible(){
        Boolean isVisible = elementExists(LOGO_IMG);
        return isVisible;
    }
    public ContactUsPage openContactUsTab(){
        clickElementByXpath(CONTACT_US_OPTION);
        return new ContactUsPage();
    }
    public LoginPage openLoginPage(){
        clickElementByXpath(LOGIN_OPTION);
        return new LoginPage();
    }
    public CartPage openCartPage(){
        clickElementByXpath(CART_OPTION);
        return new CartPage();
    }
    public GiftCardPage openGiftCardPage(){
        clickElementByXpath(GIFT_CARD_OPTION);
        return new GiftCardPage();
    }

    public GalleryPage openGalleryPage(){
        clickElementByXpath(GALLERY_OPTION);
        return new GalleryPage();
    }

    public FAQsPage openFAQsPage(){
        clickElementByXpath(FAQS_OPTION);
        return new FAQsPage();
    }

    public BlogPage openBlogPage(){
        clickElementByXpath(BLOG_OPTION);
        return new BlogPage();
    }
    public BookByLanguage_EnglishOnly_Page openBookByLanguage_EnglishOnly_Page(){
        clickElementByXpath(Books_by_Language_OPTION);
        WebElement englishOnly = webDriver.findElement(By.xpath("//a[text() = 'English Only']"));
        englishOnly.click();
        return new BookByLanguage_EnglishOnly_Page();
    }
}
