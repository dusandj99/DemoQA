package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
        profilePage = new ProfilePage();
        sidebarPage = new SidebarPage();
        bookStorePage = new BookStorePage();
        loginPage = new LoginPage();
        bookPage = new BookPage();

        clickCard("Book Store Application");
        sidebarPage.clickSidebar("Book Store");
        bookStorePage.login();
        loginPage.inputUserName(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.Login();
    }
    @Test
    public void userCanAddBookToCollection() {
        //Assert.assertTrue(profilePage.bookNames.isEmpty()); // profilePage FindBy pokupi knjige sa Bookstore? ista klasa
        bookStorePage.clickOnBook("Learning JavaScript Design Patterns");
        bookPage.click("Add To Your Collection");
        driver.navigate().refresh();
        sidebarPage.clickSidebar("Profile");

        Assert.assertTrue(profilePage.bookExists("Learning JavaScript Design Patterns"));
    }

    @Test
    public void userCanDeleteBook(){
        bookStorePage.clickOnBook("Learning JavaScript Design Patterns");
        bookPage.click("Add To Your Collection");
        driver.navigate().refresh();
        sidebarPage.clickSidebar("Profile");
        profilePage.clickOnButton("Delete All Books");
        profilePage.closeModalOk();
        driver.navigate().refresh();
        //Assert.assertTrue(profilePage.noRows.isDisplayed());
        Assert.assertFalse(profilePage.bookExists("Learning JavaScript Design Patterns"));
    }

    @AfterMethod
    public void deleteBooks() throws InterruptedException {
        profilePage.clickOnButton("Delete All Books");
        profilePage.closeModalOk();
    }
}
