package ru.egor.qa.selenidetest.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import ru.egor.qa.selenidetest.elements.KlavaGonkiPageElements;

import static com.codeborne.selenide.Selenide.$;

public class KlavaGonkiStep extends KlavaGonkiPageElements {


    private String getCurrentWord() {
        return highlightWord.getText().replaceAll("c", "с").replaceAll("o", "о");
    }

    @Когда("начинаем игру")
    public void startGame() {
        closeWindowButton.click();
        if (startGameButton.isDisplayed()) {
            startGameButton.click();
        }
    }

    @И("ждем начала игры")
    public void waiForStartGame() {
        highlightWord.click();
    }

    @И("вводим подсвеченное слово в цикле")
    public void playGame() {
        while (true) {
            String currentWord = getCurrentWord();
            String afterFocusSymbol = afterFocusWord.getText();
            inputField.sendKeys(currentWord);
            if (afterFocusSymbol.equals(".")) {
                inputField.sendKeys(".");
                break;
            }
            inputField.sendKeys(Keys.SPACE);
        }
    }

    @Тогда("фиксируем что игра завершена и символов в минуту больше чем {int}")
    public void endGame(int minValue) {
        String result = resultText.getText();
        int resulNumber = Integer.parseInt(result);
        System.out.println("Колличесво знаков в минуту " + resulNumber);
        Assertions.assertTrue(resulNumber > minValue, "Актуальный результат = " + resulNumber);
    }

    @Когда("бот выполняет вход")
    public void inputLogin() {
        enterPage.click();
        login.setValue("Ssnail_");
        password.setValue("Abrakadabra1-").pressEnter();


    }

    @Тогда("Запускается быстрая игра")
    public void fastGameStart() {
        fastGameButton.click();
        if (startGameButton.isDisplayed()) {
            startGameButton.click();
        }
    }
}
