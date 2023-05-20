//runner class is used to excute all feature files
package feature;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

public class Runner {
  @RunWith(Cucumber.class)
  // this is used when files are stored in different packages or some specific
  // tags

  @CucumberOptions(
      plugin = {"html:target/cucumber_html_report.html"},
      features = "src/test/java/feature", glue = "Stepdefinition", tags = "@ninja"

  )

  public class runner {

  }

}
