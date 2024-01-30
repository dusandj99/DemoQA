package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    public WebElement userNameInput;
    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(id = "login")
    public WebElement loginButton;
    @FindBy(id = "name")
    public WebElement error;
    @FindBy(id = "newUser")
    public WebElement newUserButton;

    @FindBy(id = "firstname")
    public WebElement firstnameInput;
    @FindBy(id = "lastname")
    public WebElement lastnameInput;

    //--------------------------

    public void inputUserName(String userName)
    {
        userNameInput.clear();
        userNameInput.sendKeys(userName);
    }
    public void inputPassword(String password)
    {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    public void inputFirstname(String firstname)
    {
        firstnameInput.clear();
        firstnameInput.sendKeys(firstname);
    }
    public void inputLastname(String lastname)
    {
        lastnameInput.clear();
        lastnameInput.sendKeys(lastname);
    }

    public String errorMessage()
    {
        return error.getText();
    }
    public void Login()
    {
        loginButton.click();
    }
    public void Register()
    {
        newUserButton.click();
    }
}
