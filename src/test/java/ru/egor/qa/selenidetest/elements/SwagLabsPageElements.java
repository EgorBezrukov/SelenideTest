package ru.egor.qa.selenidetest.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

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
    protected final SelenideElement errorMessage = $("[data-test=error]");
    protected final ElementsCollection productNames = $$(".inventory_item_name");
    protected final ElementsCollection products = $$(".inventory_item");
    protected final ElementsCollection productPrices = $$(".inventory_item_price");
    protected final SelenideElement productSortContainer = $("select.product_sort_container");


    public SelenideElement getLogin() {
        return login;
    }

    public SelenideElement getPassword() {
        return password;
    }

    public ElementsCollection getInventoryList() {
        return inventoryList;
    }

    public SelenideElement getBackPackOpenPage() {
        return backPackOpenPage;
    }

    public SelenideElement getBackPackPrice() {
        return backPackPrice;
    }

    public SelenideElement getAddToCartButton() {
        return addToCartButton;
    }

    public SelenideElement getCartBadge() {
        return cartBadge;
    }

    public SelenideElement getCartButton() {
        return cartButton;
    }

    public SelenideElement getItemPrise() {
        return itemPrise;
    }

    public SelenideElement getErrorMessage() {
        return errorMessage;
    }

    public ElementsCollection getProductNames() {
        return productNames;
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
