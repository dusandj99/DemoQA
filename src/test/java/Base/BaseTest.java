package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {

    public static WebDriver driver;
    //svi pages
    public LoginPage loginPage;
    public ProfilePage profilePage;
    public BookStorePage bookStorePage;

    //public RegisterPage registerPage;
    public HomePage homePage;
    public SidebarPage sidebarPage;
    public RadioButtonPage radioButtonPage;
    public DynamicPropertiesPage dynamicPropertiesPage;
    public WebTablesPage webTablesPage;
    public UploadAndDownloadPage uploadAndDownloadPage;
    public BookPage bookPage;
    public ExcelReader excelReader;
    public WebDriverWait wait;

    public final String validUsername = "finalProject";
    public final String validPassword = "finalProject123!"; // used on bookstore not only on login


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        excelReader = new ExcelReader("InputData.xlsx");
    }

    @AfterMethod
    public void clear()
    {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void clickCard(String cardName)
    {
        for (WebElement c: homePage.cards){
            if (c.getText().equalsIgnoreCase(cardName)){
                scrollToElement(c);
                c.click();
                break;
            }
        }
    }
    public void jsClick(WebElement e)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", e);
    }

}
