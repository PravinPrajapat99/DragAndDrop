package stepdefinations;

import driver.DriverClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import service.DragAndDropService;

public class DragAndDropSteapDefination {
    WebDriver driver= DriverClass.getDriver("chrome");
    DragAndDropService service= new DragAndDropService();

    @Given("am on the drag-and-drop demo page")
    public void am_on_the_drag_and_drop_demo_page() {
       service.getPage(driver);
    }
    @When("I drag the image to the trash")
    public WebElement i_drag_the_image_to_the_trash() {
        return service.getImageForDrag(driver);
    }
    @Then("the image should be dropped onto the trash")
    public void the_image_should_be_dropped_onto_the_trash() {
       service.dropImage(driver , i_drag_the_image_to_the_trash());
    }
    @And("I should see the image in the trashbox")
    public void i_should_see_the_image_in_the_trashbox() {
        service.verifyIfImageDroped(driver);
    }
}
