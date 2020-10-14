Feature: Проверка названия страницы на Википедии
  Название должно содержать гладиолус

  @otladTest
  Scenario: В названии нет слова гладиолус
    Given перейти на сайт 'https://www.google.ru/'
    Then Осуществить поиск по запросу 'Гладиолус'
    Then Проверить отсутствие слова 'Гладиолус' в ссылке на Википедию
    Then закончить работу
