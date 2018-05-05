package steps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import static junit.framework.TestCase.assertTrue;

public class TravelInsuranceSteps{

    @Step("Заголовок страницы - Стразование путешественников равен {0}")
    public void checkPageTitle(String expectedTitle){
        String actualTitle = new TravelInsurancePage().title.getText();
        WebElement link = new TravelInsurancePage().title;
        new TravelInsurancePage().waitAppearence(link);
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("Нажатие кнопки - Оформить сейчас")
    public void stepSendAppButton(){
        new TravelInsurancePage().sendAppBtn.click();
    }
}
