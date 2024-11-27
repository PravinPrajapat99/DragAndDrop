Feature: drag and drop the element
  Scenario: pick and drop image to trash box
    Given  am on the drag-and-drop demo page
    When I drag the image to the trash
    Then the image should be dropped onto the trash
    And I should see the image in the trashbox