package ru.egor.qa.selenidetest.steps;
import com.codeborne.selenide.ElementsCollection;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import ru.egor.qa.selenidetest.elements.KlavaGonkiPageElements;
import ru.egor.qa.selenidetest.elements.SwagLabsPageElements;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;

public class SwagLabsStep extends SwagLabsPageElements {
        @Когда("пользователь выполняет вход")
        public void inputLogin(){
                login.setValue("");
                password.setValue("").pressEnter();
                loginButton.click();
        }

        @И("Он проверяет что количество элементов на странице ровно {int}")
        public void checkElementPage(int quantity) {
                inventoryList.shouldHave(sizeGreaterThanOrEqual(quantity));
        }
}
