# language:ru

Функционал: Бот для сайта klavagonki.ru

  1.Выполняется вход в быструю игру
  3.Ожидается начало игры
  4.После запуска игры бот вводит слова
  5.По окончанию игры проверяем что кол.знаков в мин. больше чем указанное значение


  Предыстория: я нахожусь на главной страниц сайта
    Пусть открыт сайт "https://klavogonki.ru/go?type=normal"

  @Test
  Сценарий: Бот запускает игру и вводит слова

    Когда начинаем игру
    И ждем начала игры
    И вводим подсвеченное слово в цикле
    Тогда фиксируем что игра завершена и символов в минуту больше чем 800


