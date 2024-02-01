package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UploadAndDownloadPage extends BaseTest {

    public UploadAndDownloadPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "uploadFile")
    public WebElement chooseFileButton;
    @FindBy(id = "uploadedFilePath")
    public WebElement filePath;
    //----------------
    public void uploadImage(String location)
    {
        chooseFileButton.sendKeys(location);
    }
}
