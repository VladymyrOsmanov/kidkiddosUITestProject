package Pages;

public class GiftCardPage extends BasePage{
    public static final String CART_HEADER = "//h1[text()='Gift Card']";

    public boolean isPageTitleVisible(){
        return elementExists(CART_HEADER);
    }
}
