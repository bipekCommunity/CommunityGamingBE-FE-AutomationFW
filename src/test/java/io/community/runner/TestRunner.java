package io.community.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "me.jvt.cucumber.report.PrettyReports:target",
                "pretty"
        },
        features = "src/test/resources/features",
        glue = "io/community/step_deffinitions",
        dryRun =true,
        tags = "@wip1"
)
public class TestRunner {
}
