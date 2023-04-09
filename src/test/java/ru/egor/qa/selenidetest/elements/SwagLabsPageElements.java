package ru.egor.qa.selenidetest.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class SwagLabsPageElements {

    protected final SelenideElement login = $("#user-name");
    protected final SelenideElement password = $("#password");
    protected final ElementsCollection inventoryList = $$(".inventory_list");
    protected final SelenideElement backPackOpenPage = $("#item_4_title_link");
    protected final SelenideElement backPackPrice = $(".inventory_details_price");
    protected final SelenideElement addToCartButton = $("#add-to-cart-sauce-labs-backpack");
    protected final SelenideElement cartBadge = $(".shopping_cart_badge");
    protected final SelenideElement cartButton = $(".shopping_cart_link");
    protected final SelenideElement itemPrise = $(".inventory_item_price");
}
