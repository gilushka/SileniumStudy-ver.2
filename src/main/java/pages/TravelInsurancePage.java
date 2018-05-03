package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelInsurancePage extends BasePage {
    @FindBy(xpath = "//div[contains(@class,'sbrf-rich-outer')]/h1")
    public WebElement title;

    @FindBy(xpath = "//a//img[contains(@src,'banner-zashita-traveler')]")
    public WebElement sendAppBtn;

    public TravelInsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitAppearence(WebElement link){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(link));
    }

}
