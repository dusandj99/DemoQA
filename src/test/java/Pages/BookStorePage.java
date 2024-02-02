package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookStorePage extends BaseTest {

    public BookStorePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login")
    public WebElement loginButton;
    @FindBy(id = "action-buttons")
    public List<WebElement> bookLinks;
    //---------------

    public void login()
    {
        loginButton.click();
    }

}
