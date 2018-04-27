package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{
    @FindBy(xpath = "//*[@class=\"alt-menu-mid\"]")
    WebElement menuItems;

    @FindBy(xpath = "//div[contains(@class,'header_more_nav')]//*[contains(text(), 'Страхование путешественников')]")
    WebElement menuInsurance;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectMenuItem(){
        menuItems.findElement(By.xpath("/ul/li[5]/a")).click();
    }

    public void selectInsuranceItem(String itemName){
        menuInsurance.findElement(By.xpath(".//li[contains(@class,'line3-link')]//a[contains(text(),'"+itemName+"')]")).click();
    }

}
