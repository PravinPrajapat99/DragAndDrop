package stepdefinations;

import driver.DriverClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import service.ShopingService;

public class ShopingStepDefinations {
    WebDriver driver= DriverClass.getDriver("chrome");
    ShopingService service = new ShopingService();

    @Then("go to shop menu")
    public void go_to_shop_menu() {
        service.goToShopMenu(driver);
    }
    @And("click on mens")
    public void click_on_mens() {
        service.clickOnMens(driver);
    }
    @Then("print names and prices of first {int} items")
    public void print_names_and_prices_of_first_items(Integer int1) {
        service.printData(driver,int1);
    }
}
