package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePage extends BaseTest {
    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName-value")
    public WebElement usernameLabel;

    @FindBy(className = "mr-2")
    public List<WebElement> bookNames;
    @FindBy(id = "submit")
    public List<WebElement> buttons;
    @FindBy(id = "closeSmallModal-ok")
    public WebElement okModalButton;
    @FindBy(className = "rt-noData")
    public WebElement noRows;
    //--------------------------
    public void clickOnButton(String buttonName)
    {
        for (WebElement button: buttons){
            if (button.getText().equalsIgnoreCase(buttonName)){
                jsClick(button);
                break;
            }
        }
    }
    public void closeModalOk()
    {
        okModalButton.click();
    }
    public boolean bookExists(String bookName)
    {
        for (WebElement book: bookNames){
            if (book.getText().equalsIgnoreCase(bookName)){
                return true;
            }
        }
        return false;
    }
}
