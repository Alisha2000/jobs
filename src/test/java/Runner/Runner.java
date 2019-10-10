package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"pretty", "html:target/cucumberHTMLreport",
        "json:target/cucumber.json"},
        features="src\\test\\resourses\\UIFeatures",
        glue="StepDefs",

       // tags="@etsy3",
       // tags="@etsy3",
       // tags="@etsy4",
        //  tags="@uidb",
       // tags="@db3",
       // tags = {"@orders2, @orders3"},
        tags="@login",
        dryRun =false




)


public class Runner {

}
