package ru.egor.qa.selenidetest.elements;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class SwagLabsPageElements {

    protected final SelenideElement login = $("#user-name");
    protected final SelenideElement password = $("#password");
    protected final SelenideElement loginButton = $("#login-button");
    protected final ElementsCollection inventoryList = $$(".inventory_list");

}
