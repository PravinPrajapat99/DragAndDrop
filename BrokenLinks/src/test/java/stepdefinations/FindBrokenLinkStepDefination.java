package stepdefinations;

import driver.DriverClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import service.BrokenLinkService;

import java.util.List;


public class FindBrokenLinkStepDefination {
    WebDriver driver= DriverClass.getDriver("chrome");
    BrokenLinkService service = new BrokenLinkService();
    @Given("nba page is open")
    public void nba_page_is_open() {
        service.openPage(driver);
    }
    @Then("get the footer element")
    public WebElement get_the_footer_element() {
        return  service.getFooter(driver);
    }
    @And("get all links from footer")
    public List<String> get_all_links_from_footer() {
        return  service.getLinks(driver,get_the_footer_element());
    }
    @Then("move them into excel")
    public void move_them_into_excel() {
        service.moveLinksToExcel(driver,get_all_links_from_footer());
    }
    @And("check for broken link")
    public void check_for_broken_link() {
        service.checkForBrokenLink(driver,get_all_links_from_footer());
    }



}
