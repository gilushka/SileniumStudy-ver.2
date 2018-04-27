package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{
    @FindBy(xpath = "//*[@class=\"alt-menu-mid\"]/ul")
    WebElement altMenuMidList;

    @FindBy(xpath = "//div[contains(@class,'header_more_nav')]//div[contains(@class,'alt-menu-collapser-hidder')]]")
    WebElement altMenuCollapserHidder;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectMenuItem(String itemName){
        altMenuMidList.findElement(By.xpath("/li/a[contains(@class,'"+itemName+"')]")).click();
    }

    public void selectInsuranceItem(String itemName){
        altMenuCollapserHidder.findElement(By.xpath(".//div/div/a[contains(text(),'"+itemName+"')]")).click();
    }

}
