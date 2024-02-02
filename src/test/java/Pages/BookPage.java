package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookPage extends BaseTest {

    public BookPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    public List<WebElement> Buttons;

    //---------------

    public void click(String buttonName){
        for (WebElement button: Buttons){
            if (button.getText().equalsIgnoreCase(buttonName)){
                scrollToElement(button);
                button.click();
                break;
            }
        }
    }


}
