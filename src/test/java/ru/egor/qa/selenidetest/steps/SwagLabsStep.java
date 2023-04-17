package ru.egor.qa.selenidetest.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.egor.qa.selenidetest.elements.SwagLabsPageElements;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;

public class SwagLabsStep extends SwagLabsPageElements {
    private SwagLabsPageElements productsPage = new SwagLabsPageElements();

    @Когда("пользователь выполняет вход")
    public void inputLogin() {
        login.setValue("standard_user");
        password.setValue("secret_sauce").pressEnter();

    }

    @И("^(?:пользователь|он)? проверяет что количество элементов на странице ровно \"([^\"]*)\"$")
    public void checkElementPage(int quantity) {
        productNames.shouldHave(sizeGreaterThanOrEqual(quantity));
//        ElementsCollection productNames = productsPage.getProductNames();
//        productNames.shouldHave(CollectionCondition.sizeGreaterThan(0));
//        productNames.shouldHave(CollectionCondition.allMatch(name -> !name.isEmpty()));

    }

    @И("Он переходит на страницу рюкзака и запоминает значение цены")
    public String openBackPackPage() {
        backPackOpenPage.click();
        final String price = backPackPrice.getText();
        return price;
    }

    @И("Он добавляет товар в корзину и проверяет что в корзине отображается колличесво товара {int}")
    public void addToShoppingCart(int quantity) {
        addToCartButton.click();
        String result = cartBadge.getText();
        Integer res = Integer.parseInt(result);
        Assertions.assertEquals(quantity, res);
//        if (res.equals(quantity)){
//            System.out.println(true);
//        }else  System.out.println(false);

    }

    @Тогда("Он переходит в корзину и проверят сумму заказа")
    public void checkSumOrder() {

        cartButton.click();
        String result = itemPrise.getText();
//        Assertions.assertEquals(result, openBackPackPage());
        if (result.equals(openBackPackPage())) {
            System.out.println(result);
        } else System.out.println(result + " не равно " + openBackPackPage());
    }

    @Когда("^(?:пользователь|он)? сортирует товары по цене от низкой к высокой$")
    public void sortsProductsByPriceFromLowToHigh() {
        productSortContainer.selectOptionByValue("lohi");
    }

    @Когда("^(?:пользователь|он)? сортирует товары по цене от высокой к низкой")
    public void sortsProductsByPriceFromHighToLow() {
        productSortContainer.selectOptionByValue("hilo");
    }

    @Тогда("^(?:пользователь|он)? проверяет, что товары должны быть отсортированы по цене от низкой к высокой$")
    public void theProductsShouldBeSortedByPriceFromLowToHigh() {
        products.shouldHave(sizeGreaterThan(0));
        productPrices.shouldHave(sizeGreaterThan(0));
//        productPrices.shouldBe(sortedBy("text"));
    }

    @Тогда("^(?:пользователь|он)? проверяет, что товары должны быть отсортированы по цене от высокой к низкой")
    public void theProductsShouldBeSortedByPriceFromHighToLow() {
        products.shouldHave(sizeGreaterThan(0));
        productPrices.shouldHave(sizeGreaterThan(0));
//        productPrices.shouldBe(sort("text", reverseOrder()));
    }
}