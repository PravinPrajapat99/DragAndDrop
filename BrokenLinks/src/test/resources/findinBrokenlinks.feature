Feature: finding broken links
  Scenario: check for the broken links in the footer
    Given nba page is open
    Then get the footer element
    And get all links from footer
    Then move them into excel
    And check for broken link

  Scenario: print the names and prices of first 10 items
    Given nba page is open
    Then go to shop menu
    And click on mens
    Then print names and prices of first 10 items