package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps {

    @Step("Выбор раздел главного меню {0}")
    public void stepSelectMainMenu(String menuItem){
        new MainPage().selectMenuItem(menuItem);
    }

    @Step("Выбор вид страхования {0}")
    public void stepSelectSubMenu(String point, String menuItem){
        new MainPage().selectInsuranceItem(point, menuItem);
    }
}
