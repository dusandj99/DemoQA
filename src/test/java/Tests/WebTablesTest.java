package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SidebarPage;
import Pages.WebTablesPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebTablesTest extends BaseTest {

    private final String initialURL = "https://demoqa.com/";
    private String newFirstName = "Stefan";


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

    @Test(priority = 0)
    public void userCanAddNewRowWithValidData() {
        while (webTablesPage.rowContainsData()){
            webTablesPage.deleteRow();
        }
        webTablesPage.addRow();
        fillOutForm();
        webTablesPage.submit();
        Assert.assertTrue(webTablesPage.rowContainsData());
        Assert.assertEquals(webTablesPage.getFirstName(), "Dusan");
    }
    @Test(priority = 10)
    public void userCanDeleteRow()
    {
        while (webTablesPage.rowContainsData()){
            webTablesPage.deleteRow();
        }
        webTablesPage.addRow();
        fillOutForm();
        webTablesPage.submit();
        webTablesPage.deleteRow();

    }
    @Test(priority = 20)
    public void userCanEditRow() {
        while (webTablesPage.rowContainsData()){ //delete all rows
            webTablesPage.deleteRow();
        }
        webTablesPage.addRow();
        fillOutForm();
        webTablesPage.submit();  // add new row with our data
        webTablesPage.editRow();
        webTablesPage.inputFirstname(newFirstName); // change firstname
        webTablesPage.submit();
        Assert.assertEquals(webTablesPage.getFirstName(), newFirstName); // assert the name changed
    }
    @Test(priority = 30)
    public void userCanSearchForRowByFirstname()
    {
        String searchName = "Random";
        webTablesPage.addRow();
        webTablesPage.inputFirstname(searchName);
        webTablesPage.inputLastname(excelReader.getStringData("RowData", 1, 1));
        webTablesPage.inputEmail(excelReader.getStringData("RowData", 1, 2));
        webTablesPage.inputAge(String.valueOf(excelReader.getIntegerData("RowData", 1, 3)));
        webTablesPage.inputSalary(String.valueOf(excelReader.getIntegerData("RowData", 1, 4)));
        webTablesPage.inputDepartment(excelReader.getStringData("RowData", 1, 5));
        webTablesPage.submit();  // add new row with our data onto 3 existing onces
        webTablesPage.search(searchName);
        Assert.assertEquals(webTablesPage.getFirstName(), searchName);
    }
    public void fillOutForm()
    {
        webTablesPage.inputFirstname(excelReader.getStringData("RowData", 1, 0));
        webTablesPage.inputLastname(excelReader.getStringData("RowData", 1, 1));
        webTablesPage.inputEmail(excelReader.getStringData("RowData", 1, 2));
        webTablesPage.inputAge(String.valueOf(excelReader.getIntegerData("RowData", 1, 3)));
        webTablesPage.inputSalary(String.valueOf(excelReader.getIntegerData("RowData", 1, 4)));
        webTablesPage.inputDepartment(excelReader.getStringData("RowData", 1, 5));
    }
}
