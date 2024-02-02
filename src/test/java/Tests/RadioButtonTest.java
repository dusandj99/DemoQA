package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.RadioButtonPage;
import Pages.SidebarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RadioButtonTest extends BaseTest {

    private final String initialURL = "https://demoqa.com/";

    @BeforeMethod
    public void pageSetUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(initialURL);

        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        radioButtonPage = new RadioButtonPage();

        clickCard("Elements");
        sidebarPage.clickSidebar("Radio Button");
    }

    @Test
    public void correctRadioButtonMessageIsShown() {
        jsClick(radioButtonPage.radioButtons.get(0));
        Assert.assertEquals(radioButtonPage.getMessageText(), "Yes");

        jsClick(radioButtonPage.radioButtons.get(1));
        Assert.assertEquals(radioButtonPage.getMessageText(), "Impressive");

        jsClick(radioButtonPage.radioButtons.get(2));
        Assert.assertNotEquals(radioButtonPage.getMessageText(), "No"); // "No" radio button is not clickable
    }

}
