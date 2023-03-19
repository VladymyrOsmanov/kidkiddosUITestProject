package Pages;

public class BlogPage extends BasePage{
    public static final String BLOG_HEADER = "//h1[text()='Blog']";

    public boolean isPageTitleVisible(){
        return elementExists(BLOG_HEADER);
    }
}
