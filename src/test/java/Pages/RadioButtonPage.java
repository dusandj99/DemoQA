package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButtonPage extends BaseTest {

    public RadioButtonPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "custom-control-input")
    public List<WebElement> radioButtons;

    @FindBy(className = "text-success")
    public WebElement message;

    //----------------

    public void checkRadioButton(int number)
    {
        radioButtons.get(number).click();
    }
    public String getMessageText()
    {
        return message.getText();
    }
}
