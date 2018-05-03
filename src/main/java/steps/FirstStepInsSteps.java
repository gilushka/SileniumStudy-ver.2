package steps;

import pages.FirstStepInsPage;
import ru.yandex.qatools.allure.annotations.Step;

public class FirstStepInsSteps extends BaseSteps {

    @Step("Нажатие кнопки - Отправить")
    public void stepSendAppButton(){
        new FirstStepInsPage(driver).sendAppBtn.click();
    }
}
