Feature: Проверка возможностей
  Проверяем тайтл этой фичей

  @otladish
  Scenario: Тайтл Верен
    Given перейти на сайт 'https://www.google.ru/'
    Then тайтл равен 'Google'
    Then закончить работу