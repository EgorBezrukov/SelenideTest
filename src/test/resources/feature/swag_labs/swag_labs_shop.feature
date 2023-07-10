#language: ru

Функционал: Выполнение пользовательского сценария покупки товара


  Предыстория: Открывается страница
    Пусть пользователь открывает сайт "https://www.saucedemo.com/"

  @All
  @SwagLabsShop
  Сценарий: Совершить покупку

    * h1(1. Выполяется вход)
    Тогда пользователь заполняет поля значениями:
      | Field     | Key           |
      | user-name | standard_user |
      | password  | secret_sauce  |
    И он нажимает на "login-button"

    * h1(2. Запоминаем цену на странице рюкзака)
    Когда пользователь нажимает на "#item_4_title_link"
    И он запоминает значение поля ".inventory_details_price"


    * h1(3. Проверяем отображение товара в корзине)
    Когда пользователь нажимает на "#add-to-cart-sauce-labs-backpack"
    Тогда пользователь проверяет, что значение поля ".shopping_cart_badge" равно "1"

    * h1(4. Проверяем сумму заказа)
    Когда пользователь нажимает на ".shopping_cart_link"
    Тогда пользователь проверяет, что значение поля ".inventory_item_price" равно "$29.99"

    * h1(5. Проверяем сумму заказа)
    Когда пользователь нажимает на "#checkout"
    И он заполняет поля значениями:
      | Field      | Key      |
      | firstName  | Selenide |
      | lastName   | Test     |
      | postalCode | 606324   |
    Тогда он нажимает на "continue"

    * h1(6. Проверяем сумму заказа)
    Тогда пользователь проверяет что значение "$29.99" равно сохраненному знечению
    И он нажимает на "finish"

