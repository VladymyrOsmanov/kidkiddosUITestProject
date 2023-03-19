package Pages;

public class LoginPage extends BasePage{
    public static final String LOGIN_HEADER = "//h1[text()='Login']";
    public static final String SING_IN_HEADER = "//input[@value ='Sign In']";
    public static final String password_Element = "//input[@type = 'password']";
    public static final String email_Element = "//input[@type = 'email' and @name = 'customer[email]']";


    public boolean isPageTitleVisible(){
        return elementExists(LOGIN_HEADER);
    }
    public boolean isSignInButtonVisible(){
        return elementExists(SING_IN_HEADER);
    }



}


