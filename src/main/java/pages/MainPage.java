package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{

    String point;

    @FindBy(xpath = "//div[@class='alt-menu-mid']/ul")
    WebElement altMenuMidList;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectMenuItem(String itemName){
        altMenuMidList.findElement(By.xpath("./li/a[contains(@aria-label,'"+itemName+"')]")).click();
        point = itemName;
    }

    public void selectInsuranceItem(String itemName){
        altMenuMidList.findElement(By.xpath("./li/a[contains(@aria-label,'"+point+"')]/..//div/a[contains(text(),'"+itemName+"')]")).click();
    }

}
