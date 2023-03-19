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
import static Pages.BookByLanguage_EnglishOnly_Page.*;
import static Pages.MainPage.*;
import static Pages.CartPage.*;
import static org.junit.jupiter.api.Assertions.*;
public class Scenario2 extends UseCaseBase {
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

    //Open the "Books by Language" dropdown menu
    @Test
    public void openBooksByLanguageTest(){
        logger.info("Open the 'Books by Language' dropdown menu test");
        Boolean success = mainPage.isLogoVisible();
        assertTrue(success);

        webDriver.findElement(By.xpath(Books_by_Language_OPTION)).click();

        WebElement englishOnly = webDriver.findElement(By.xpath("//a[text() = 'English Only']"));
        assertNotNull(englishOnly);

        //Choose "English Only" ( wait new page is loaded and add assertion it is loaded)
        englishOnly.click();

        boolean isLoaded = BookByLanguage_EnglishOnly_Page.isPageTitleVisible();
        assertTrue(isLoaded);
    }
    // Click on the book of your choice - add an assertion that the specific book details page is opened
    @Test
    public void openSpecificBookTest(){
        logger.info("Open the specific book page test");
        Boolean success = mainPage.isLogoVisible();
        assertTrue(success);

        webDriver.findElement(By.xpath(Books_by_Language_OPTION)).click();

        WebElement englishOnly = webDriver.findElement(By.xpath("//a[text() = 'English Only']"));
        assertNotNull(englishOnly);

        //Choose "English Only" ( wait new page is loaded and add assertion it is loaded)
        englishOnly.click();

        boolean isLoaded = BookByLanguage_EnglishOnly_Page.isPageTitleVisible();
        assertTrue(isLoaded);

    // Click on the book of your choice

        webDriver.findElement(By.xpath("//div[contains(text(), 'I Love to Brush My Teeth')]")).click();
    //add an assertion that the specific book details page is opened
        WebElement brushMyTeeth = webDriver.findElement(By.xpath("//h1[contains(text(), 'I Love to Brush My Teeth')]"));
        assertNotNull(brushMyTeeth);
    }

    //Change format to hardcover
    @Test
    public void changeFormatToHardcoverTest(){
        //Doing a shortcut to the chosen book from the test before
        logger.info("Change format of the chosen book to hardcover test");
        webDriver.get("https://kidkiddos.com/collections/english-only/products/i-love-to-brush-my-teeth-childrens-book-english-only?variant=33154372929");

        webDriver.findElement(By.xpath("//label[@for='SingleOptionSelector-0']//following-sibling::*")).click();
        WebElement HardcoverOption = webDriver.findElement(By.xpath("//label[@for='SingleOptionSelector-0']//following-sibling::*//descendant::*[@value = 'Hardcover']"));
        assertNotNull(HardcoverOption);
        HardcoverOption.click();
    }

    //Change number of books to 5
    @Test
    public void changeNumberOfBooksTest() {
        //Doing a shortcut to the chosen book from the test before
        logger.info("Change number of books to 5 test");
        webDriver.get("https://kidkiddos.com/collections/english-only/products/i-love-to-brush-my-teeth-childrens-book-english-only?variant=33154372929");

        WebElement NumberOfBooksOption = webDriver.findElement(By.xpath("//div[@class='product-form__item product-form__item--quantity']//descendant::*[@type='number']"));
        assertNotNull(NumberOfBooksOption);
        NumberOfBooksOption.clear();
        NumberOfBooksOption.sendKeys("5");
        String numberOfBooksValue = NumberOfBooksOption.getAttribute("value") ;
        assertEquals("5", numberOfBooksValue);
    }

    //Press the "Add to Cart" button -  add assertion verifying the cart is opened
    @Test
    public void addToCartTest() {
        //Doing a shortcut to the chosen book from the test before
        logger.info("Add to Cart test");
        webDriver.get("https://kidkiddos.com/collections/english-only/products/i-love-to-brush-my-teeth-childrens-book-english-only?variant=33154372929");

        WebElement addToCartButton = webDriver.findElement(By.xpath("//button[@type = 'submit' and @class = 'btn product-form__cart-submit']"));
        assertNotNull(addToCartButton);
        addToCartButton.click();
        //assertion verifying the cart is opened
        Boolean pageTitleVisible = CartPage.isPageTitleVisible();
        assertTrue(pageTitleVisible);

        //Change Books quantity to 6
        logger.info("Change Books quantity to 6");

        WebElement NumberOfBooksOption = webDriver.findElement(By.xpath("//input[@class = 'cart__qty-input' and @name = 'updates[]']"));
        assertNotNull(NumberOfBooksOption);
        NumberOfBooksOption.clear();
        NumberOfBooksOption.sendKeys("6");
        //Verify the amount of the book is changed to 6
        logger.info("Verify the amount of the book is changed to 6 and the price is updated");

        String numberOfBooksValue = NumberOfBooksOption.getAttribute("value") ;
        assertEquals("6", numberOfBooksValue);

        //press the update button
        WebElement updateButton = webDriver.findElement(By.xpath("//input[@class = 'btn btn--secondary cart__update cart__update--large small--hide' and @name = 'update']"));
        assertNotNull(updateButton);
        updateButton.click();


        //Verify that the price is updated
        WebElement price = webDriver.findElement(By.xpath("//span[@class = 'currency-converter-amount-box']//descendant::*[@class = 'cbb-price-digits' and text() = '131.94']"));
        assertNotNull(price);

        String priceValue = price.getText() ;
        assertEquals("131.94", priceValue);
    }
}
