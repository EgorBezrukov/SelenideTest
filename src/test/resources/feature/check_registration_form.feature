#language: ru

Функционал: Проверка функционала формы регистрации

  Предыстория: открывается сайт
    Пусть пользователь открывает сайт "https://www.saucedemo.com/"

  @CheckRegistrationForm

  Сценарий: Проверяем валидные значения логина и пароля

    Когда пользователь вводит в поле "Логин" знчение "standard_user"
    И он вводит в поле "Пароль" знчение "secret_sauce"
    И он нажимает на "login-button"
    Тогда пользователь проверяет что адрес сайта равен "https://www.saucedemo.com/inventory.html"

