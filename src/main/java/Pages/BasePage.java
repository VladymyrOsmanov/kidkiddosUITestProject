package Pages;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;

public class BasePage {
    public static final Logger logger = LogManager.getLogger(BasePage.class);

    protected static WebDriver webDriver;
    protected static WebDriverWait wait;
    public void setWebDriver(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 5);
    }

    protected void clickElementByXpath(String xpath){
       logger.info("Clicking element with xpath: " + xpath);
        findElementByXpath(xpath).click();
    }
    protected void sendTextToElementByXpath(String xpath, String text){
        findElementByXpath(xpath).sendKeys(text);
    }
    protected static boolean elementExists(String xpath){
       try{
           logger.info("Check element with xpath  exists: " + xpath);
           webDriver.findElement(By.xpath(xpath));
           return true;
       }
       catch (Exception err){
           return false;
       }
    }
    protected WebElement findElementByXpath(String xpath){
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = webDriver.findElement(By.xpath(xpath));
        return element;
    }
    protected String getCurrentPageURL(){
        return webDriver.getCurrentUrl();
    }

    public void takeScreenshot(String name){
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("Screenshots/" + name + ".jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
