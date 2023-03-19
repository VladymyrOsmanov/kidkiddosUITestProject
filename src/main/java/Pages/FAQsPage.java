package Pages;

public class FAQsPage extends BasePage{
    public static final String FAQS_HEADER = "//h1[text()='FAQ/addition info']";

    public boolean isPageTitleVisible(){
        return elementExists(FAQS_HEADER);
    }
}
