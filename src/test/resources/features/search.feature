# encoding: CP1251
Feature: I want to search in bing.com

  Scenario: Finding some query
    Given I am on the Bing search page
    When I search for "�����"
    Then Search result page contains title "����� � ���������"
    And Search result page contains url "https://ru.wikipedia.org/wiki/�����"