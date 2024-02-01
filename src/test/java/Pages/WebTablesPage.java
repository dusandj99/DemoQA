package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage extends BaseTest {

    public WebTablesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addButton;

    @FindBy(id = "firstName")
    public WebElement firstnameInput;
    @FindBy(id = "lastName")
    public WebElement lastnameInput;
    @FindBy(id = "userEmail")
    public WebElement emailInput;
    @FindBy(id = "age")
    public WebElement ageInput;
    @FindBy(id = "salary")
    public WebElement salaryInput;
    @FindBy(id = "department")
    public WebElement departmentInput;
    @FindBy(id = "submit")
    public WebElement submitButton;
    @FindBy(css = "span[title='Delete']")
    public WebElement deleteButton;
    @FindBy(css = "span[title='Edit']")
    public WebElement editButton;
    @FindBy(className = "rt-td")
    public WebElement rowData;
    //---------------------
    public void editRow()
    {
        editButton.click();
    }
    public void deleteRow()
    {
       deleteButton.click();
    }
    public void addRow()
    {
        addButton.click();
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
    public void inputEmail(String email)
    {
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    public void inputAge(String age)
    {
        ageInput.clear();
        ageInput.sendKeys(age);
    }
    public void inputSalary(String salary)
    {
        salaryInput.clear();
        salaryInput.sendKeys(salary);
    }
    public void inputDepartment(String department)
    {
        departmentInput.clear();
        departmentInput.sendKeys(department);
    }
    public void submit()
    {
        submitButton.click();
    }
    public boolean rowContainsData()
    {
        try {
            if (deleteButton.isDisplayed())
                return true;
        } catch (Exception e){
           // we do not want program to stop after we delete all buttons
        }
        return false;
    }
    public String getFirstName()
    {
        return rowData.getText();
    }
}
