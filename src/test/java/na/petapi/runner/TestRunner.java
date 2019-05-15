package na.petapi.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/featureFiles/pet.feature",
				glue = {"na.petapi.stepdef" },
				plugin = {"rerun:target/rerun.txt",
						"html:output/cucumber-reports"},
				dryRun = false,
				monochrome = true,
				snippets = SnippetType.CAMELCASE

)
public class TestRunner {

}
