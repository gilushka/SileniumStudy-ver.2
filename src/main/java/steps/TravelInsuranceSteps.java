package steps;

import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelInsuranceSteps extends BaseSteps {

    @Step("Нажатие кнопки - Оформить сейчас")
    public void stepSendAppButton(){
        new TravelInsurancePage(driver).sendAppBtn.click();
    }
}
