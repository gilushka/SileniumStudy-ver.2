package steps;

import org.openqa.selenium.WebElement;
import pages.FirstStepInsPage;
import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class FirstStepInsSteps{

    @Step("Выбор суммы страховой защиты")
    public void selectValueIns(){
        WebElement select = new FirstStepInsPage().select;
        new TravelInsurancePage().waitAppearence(select);
        new FirstStepInsPage().select.click();
    }

    @Step("Нажатие кнопки - Отправить")
    public void stepSendAppButton(){
        new FirstStepInsPage().sendAppBtn.click();
    }
}
