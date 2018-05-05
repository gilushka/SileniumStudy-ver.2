package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class FirstStepInsPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'35')]")
    public WebElement select;

    @FindBy(xpath = "//span[contains(@class,'b-button-block-center')]/span[contains(text(),'Оформить')]")
    public WebElement sendAppBtn;

    public FirstStepInsPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void waitAppearence(WebElement link){
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(link));
    }

    public void selectItem(String itemName) {
        select.findElement(By.xpath("//div[contains(text(),'" + itemName + "')]")).click();
    }
}
