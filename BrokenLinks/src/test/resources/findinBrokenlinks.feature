Feature: finding broken links
  Scenario: check for the broken links in the footer
    Given nba page is open
    Then get the footer element
    And get all links from footer
    Then move them into excel
    And check for broken link