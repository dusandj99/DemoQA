package Tests;

import Base.BaseTest;
import Pages.DynamicPropertiesPage;
import Pages.HomePage;
import Pages.SidebarPage;
import Pages.WebTablesPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebTablesTest extends BaseTest {

    private final String initialURL = "https://demoqa.com/";
    private String firstName = "John";

    @BeforeMethod
    public void pageSetUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(initialURL);
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        webTablesPage = new WebTablesPage();

        clickCard("Elements");
        clickSidebar("Web Tables");
    }

    @Test
    public void userCanAddNewRowWithValidData() {
        while (webTablesPage.rowContainsData()){
            webTablesPage.deleteRow();
        }
        webTablesPage.addRow();
        webTablesPage.inputFirstname(firstName);
        webTablesPage.inputLastname("Doe");
        webTablesPage.inputEmail("john@gmail.com");
        webTablesPage.inputAge("30");
        webTablesPage.inputSalary("1000");
        webTablesPage.inputDepartment("qa");
        webTablesPage.submit();
        Assert.assertTrue(webTablesPage.rowContainsData());
        Assert.assertEquals(webTablesPage.getFirstName(), firstName);
    }
}
