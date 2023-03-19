package Pages;

public class CartPage extends BasePage{
    public static final String CART_HEADER = "//h1[text()='Your cart']";

    public static boolean isPageTitleVisible(){
        return elementExists(CART_HEADER);
    }
}
