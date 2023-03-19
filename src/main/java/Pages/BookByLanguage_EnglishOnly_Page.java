package Pages;

public class BookByLanguage_EnglishOnly_Page extends BasePage{
    public static final String CART_HEADER = "//h1[text()='English Only']";

    public static boolean isPageTitleVisible(){
        return elementExists(CART_HEADER);
    }
}
