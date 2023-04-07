package ru.egor.qa.selenidetest.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class KlavaGonkiPageElements {
    protected final SelenideElement closeWindowButton = $x("//input[@value = 'Закрыть']");
    protected final SelenideElement startGameButton = $x("//a[@id='host_start']");
    protected final SelenideElement highlightWord = $x(" //span[@id='typefocus']");
    protected final SelenideElement inputField = $x(" //input[@id='inputtext']");
    protected final SelenideElement afterFocusWord = $x(" //span[@id='afterfocus']");
    protected final SelenideElement resultText = $x("//span[contains(text(), 'зн/мин')]/..//span//span");
    protected final SelenideElement enterPage = $x("//span[text() = 'Вход']");

    protected final SelenideElement login = $("#username");

    protected final SelenideElement password = $("#password");
    protected final SelenideElement fastGameButton = $x("//a[text() ='Быстрый старт']");
}
