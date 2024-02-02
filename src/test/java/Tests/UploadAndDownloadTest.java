package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SidebarPage;
import Pages.UploadAndDownloadPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UploadAndDownloadTest extends BaseTest {

    private final String initialURL = "https://demoqa.com/";

    private String imageLoc = "C:\\Users\\dusan\\OneDrive\\Desktop\\";
    private String imageName = "imageUpload.png";
    private String returnedPath = "C:\\fakepath\\" + imageName;

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
        uploadAndDownloadPage = new UploadAndDownloadPage();

        clickCard("Elements");
        sidebarPage.clickSidebar("Upload and Download");
    }

    @Test
    public void userCanUploadImage()
    {
        uploadAndDownloadPage.uploadImage(imageLoc + imageName);
        Assert.assertEquals(uploadAndDownloadPage.filePath.getText(), returnedPath);
    }

}
