package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:DragAndDrop.feature",glue = {"stepdefinations"})
public class Runnner {
  

}
