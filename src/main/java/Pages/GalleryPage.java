package Pages;

public class GalleryPage extends BasePage{
    public static final String GALLERY_HEADER = "//h1[text()='Gallery']";

    public boolean isPageTitleVisible(){
        return elementExists(GALLERY_HEADER);
    }
}
