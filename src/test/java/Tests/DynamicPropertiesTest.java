package Tests;

import Base.BaseTest;
import Pages.DynamicPropertiesPage;
import Pages.HomePage;
import Pages.SidebarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicPropertiesTest extends BaseTest {

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
        dynamicPropertiesPage = new DynamicPropertiesPage();

        clickCard("Elements");
        sidebarPage.clickSidebar("Dynamic Properties");
    }

    @Test
    public void elementIsAvailableAfter5Seconds()
    {
        wait.until(ExpectedConditions.elementToBeClickable(dynamicPropertiesPage.enableAfterButton));
        Assert.assertTrue(dynamicPropertiesPage.enableAfterButton.isEnabled());
    }

    @Test
    public void colorChangesAfter5Seconds() throws InterruptedException {
        Assert.assertTrue(dynamicPropertiesPage.colorChangeButton.isDisplayed());
        String firstColor = dynamicPropertiesPage.colorChangeButton.getCssValue("color");
        Thread.sleep(5000);
        String secondColor = dynamicPropertiesPage.colorChangeButton.getCssValue("color");

        Assert.assertNotEquals(firstColor, secondColor);
    }
}
