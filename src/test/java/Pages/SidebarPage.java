package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SidebarPage extends BaseTest {

    public SidebarPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "ul.menu-list li")
    public List<WebElement> sidebarLinks;
    //----------------------

    public void clickSidebar(String sidebarLinkName)
    {
        for (WebElement s : sidebarLinks){
            if (s.getText().equalsIgnoreCase(sidebarLinkName))
            {
                scrollToElement(s);
                s.click();
                break;
            }
        }
    }

}
