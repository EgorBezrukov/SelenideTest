#language: ru

Функционал: Проверка функционала формы регистрации

  Предыстория: открывается сайт
    Пусть пользователь открывает сайт "https://www.saucedemo.com/"

  @CheckRegistrationForm

  Сценарий: Проверить, что при вводе правильного логина и пароля пользователь успешно авторизуется

    Когда пользователь вводит в поле "Логин" знчение "standard_user"
    И он вводит в поле "Пароль" знчение "secret_sauce"
    И он нажимает на "login-button"
    Тогда пользователь проверяет что адрес сайта равен "https://www.saucedemo.com/inventory.html"

  Сценарий: Проверить, что при попытке войти без логина и пароля отображается сообщение об ошибка

    Когда пользователь вводит в поле "Логин" знчение ""
    И он вводит в поле "Пароль" знчение ""
    И он нажимает на "login-button"
    Тогда пользователь проверяет, что отображается сообщение об ошибке "Epic sadface: Username is required"

  Сценарий: Проверить, что при вводе неправильного логина или пароля отображается сообщение об ошибке

    Когда пользователь вводит в поле "Логин" знчение "efsd"
    И он вводит в поле "Пароль" знчение "1324"
    И он нажимает на "login-button"
    Тогда пользователь проверяет, что отображается сообщение об ошибке "Epic sadface: Username and password do not match any user in this service"