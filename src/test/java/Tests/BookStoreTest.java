package Tests;

import Base.BaseTest;
import Pages.BookStorePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SidebarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BookStoreTest extends BaseTest {

    private final String initialURL = "https://demoqa.com/";

    @BeforeMethod
    public void pageSetUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(initialURL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        bookStorePage = new BookStorePage();
        loginPage = new LoginPage();

        clickCard("Book Store Application");
        clickSidebar("Book Store");
        bookStorePage.login();
        loginPage.inputUserName(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.Login();
    }
    @Test
    public  void userCanAddBookToCollection()
    {

    }
}
