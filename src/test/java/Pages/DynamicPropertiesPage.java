package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicPropertiesPage extends BaseTest {

    public DynamicPropertiesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "enableAfter")
    public WebElement enableAfterButton;

    @FindBy(id = "colorChange")
    public WebElement colorChangeButton;

    @FindBy(id = "visibleAfter")
    public WebElement visibleAfterButton;

}
