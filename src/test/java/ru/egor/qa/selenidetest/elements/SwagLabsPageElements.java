package ru.egor.qa.selenidetest.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SwagLabsPageElements {

    protected final SelenideElement backPackPrice = $(".inventory_details_price");
    protected final SelenideElement cartBadge = $(".shopping_cart_badge");
    protected final SelenideElement itemPrise = $(".inventory_item_price");
    protected final ElementsCollection productNames = $$(".inventory_item_name");
    protected final SelenideElement productSortContainer = $("select.product_sort_container");

    public String getBackPackPrice() {
        return backPackPrice.getText();
    }

    public String getCartBadge() {
        return cartBadge.getText();
    }

    public String getItemPrise() {
        return itemPrise.getText();
    }

    public ElementsCollection getProductNames(int quantity) {
        return productNames.shouldHave(sizeGreaterThanOrEqual(quantity));
    }

    public SelenideElement getProductSortContainer() {
        return productSortContainer;
    }
}
