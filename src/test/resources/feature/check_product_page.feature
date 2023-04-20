#language: ru

Функционал: Проверка функционала траницы с продуктами

  Предыстория: открывается сайт
    Пусть пользователь открывает сайт "https://www.saucedemo.com/"

  @CheckProductPage

  Сценарий: Проверить, что все продукты отображаются на странице

    * h1(1. Выполняется вход)
    Когда пользователь вводит в поле "Логин" знчение "standard_user"
    И он вводит в поле "Пароль" знчение "secret_sauce"
    И он нажимает на "login-button"

    * h1(2. Проверка отображени яэлементов)
    Тогда пользователь проверяет что количество элементов на странице ровно "6"


  Сценарий: Проверить, что продукты можно отсортировать по цене от большего к меньшему
    * h1(1. Выполняется вход)
    Когда пользователь вводит в поле "Логин" знчение "standard_user"
    И он вводит в поле "Пароль" знчение "secret_sauce"
    И он нажимает на "login-button"

    * h1(2.Проверка правильной сортировки)
    Когда пользователь сортирует товары по цене от низкой к высокой


  Сценарий: Проверить, что продукты можно отсортировать по цене от меньшего к большему
    * h1(1. Выполняется вход)
    Когда пользователь вводит в поле "Логин" знчение "standard_user"
    И он вводит в поле "Пароль" знчение "secret_sauce"
    И он нажимает на "login-button"

    * h1(2. Проверка правильной сортировки)
    Когда пользователь сортирует товары по цене от высокой к низкой
