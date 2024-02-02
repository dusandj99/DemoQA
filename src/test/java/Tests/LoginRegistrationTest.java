package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginRegistrationTest extends BaseTest {

    private final String invalidUsername = "invalid123";
    private final String invalidPassword = "badPassword11!";
    private final String formInvalidPassword = "testingreg12"; //Uppercase + numeric + special char
    //private String errorRegMessage = "Passwords must have at least one non-alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.";

    private final String initialURL = "https://demoqa.com/login";

    @BeforeMethod
    public void pageSetUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(initialURL);

        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        //registerPage = new RegisterPage();
    }

    @Test
    public void userCanLoginWithValidCredetials()
    {
        loginPage.inputUserName(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.Login();

        Assert.assertEquals(profilePage.usernameLabel.getText(), validUsername);
        Assert.assertNotEquals(driver.getCurrentUrl(), initialURL);
    }
    @Test
    public void userCanNotLoginWithInvalidCredetials()
    {
        loginPage.inputUserName(invalidUsername);
        loginPage.inputPassword(invalidPassword);
        loginPage.Login();

        Assert.assertEquals(driver.getCurrentUrl(), initialURL);
        Assert.assertEquals(loginPage.errorMessage(), "Invalid username or password!");
    }
    @Test
    public void userCanNotLoginWithInvalidUsername()
    {
        loginPage.inputUserName(invalidUsername);
        loginPage.inputPassword(validPassword);
        loginPage.Login();

        Assert.assertEquals(driver.getCurrentUrl(), initialURL);
        Assert.assertEquals(loginPage.errorMessage(), "Invalid username or password!");
    }
    @Test
    public void userCanNotLoginWithInvalidPassword()
    {
        loginPage.inputUserName(validUsername);
        loginPage.inputPassword(invalidPassword);
        loginPage.Login();

        Assert.assertEquals(driver.getCurrentUrl(), initialURL);
        Assert.assertEquals(loginPage.errorMessage(), "Invalid username or password!");
    }

//    @Test
//    public void userCanNotRegisterWithIncorrectInput() // captcha on site
//    {
//        loginPage.Register();
//        registerPage.inputFirstname("Firstname");
//        registerPage.inputLastname("Lastname");
//        registerPage.inputUserName("username22");
//        registerPage.inputPassword(formInvalidPassword);
//        registerPage.Register();
//
//        Assert.assertEquals(registerPage.getErrorMessage(),errorRegMessage);
//        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/register");
//    }

}
