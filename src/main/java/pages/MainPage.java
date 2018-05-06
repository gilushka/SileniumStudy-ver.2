package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage extends BasePage{

    @FindBy(xpath = "//div[@class='alt-menu-mid']/ul")
    WebElement altMenuMidList;

    public MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenuItem(String itemName){
        altMenuMidList.findElement(By.xpath("./li/a[contains(@aria-label,'"+itemName+"')]")).click();
//        this.point = itemName;
    }

    public void selectInsuranceItem(String point, String itemName){
        altMenuMidList.findElement(By.xpath("./li/a[contains(@aria-label,'"+point+"')]/..//div/a[contains(text(),'"+itemName+"')]")).click();
    }

}
