package ru.egor.qa.selenidetest.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SwagLabsPageElements {

    protected final ElementsCollection inventoryList = $$(".inventory_list");
    protected final SelenideElement backPackOpenPage = $("#item_4_title_link");
    protected final SelenideElement backPackPrice = $(".inventory_details_price");
    protected final SelenideElement addToCartButton = $("#add-to-cart-sauce-labs-backpack");
    protected final SelenideElement cartBadge = $(".shopping_cart_badge");
    protected final SelenideElement cartButton = $(".shopping_cart_link");
    protected final SelenideElement itemPrise = $(".inventory_item_price");
    protected final SelenideElement errorMessage = $("[data-test=error]");
    protected final ElementsCollection productNames = $$(".inventory_item_name");
    protected final ElementsCollection products = $$(".inventory_item");
    protected final ElementsCollection productPrices = $$(".inventory_item_price");
    protected final SelenideElement productSortContainer = $("select.product_sort_container");


    public ElementsCollection getInventoryList() {
        return inventoryList;
    }

    public SelenideElement getBackPackOpenPage() {
        return backPackOpenPage;
    }

    public String getBackPackPrice() {
        return backPackPrice.getText();
    }

    public SelenideElement getAddToCartButton() {
        return addToCartButton;
    }

    public String getCartBadge() {
        return cartBadge.getText();
    }

    public SelenideElement getCartButton() {
        return cartButton;
    }

    public String getItemPrise() {
        return itemPrise.getText();
    }

    public SelenideElement getErrorMessage() {
        return errorMessage;
    }

    public ElementsCollection getProductNames(int quantity) {
        return productNames.shouldHave(sizeGreaterThanOrEqual(quantity));
    }

    public ElementsCollection getProducts() {
        return products;
    }

    public ElementsCollection getProductPrices() {
        return productPrices;
    }

    public SelenideElement getProductSortContainer() {
        return productSortContainer;
    }
}
