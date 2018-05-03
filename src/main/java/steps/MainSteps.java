package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps {

    @Step("Выбор раздела - Страхование")
    public void stepSelectMainMenu(String menuItem){
        new MainPage(driver).selectMenuItem(menuItem);
    }

    @Step("Выбор пункт меню - Страхование путешественников")
    public void stepSelectSubMenu(String menuItem){
        new MainPage(driver).selectInsuranceItem(menuItem);
    }
}
