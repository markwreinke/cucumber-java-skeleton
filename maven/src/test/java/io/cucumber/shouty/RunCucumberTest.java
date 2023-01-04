package io.cucumber.shouty;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("io/cucumber/shouty")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:reports/output.html, rerun:reports/rerun.txt")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "io.cucumber.shouty")
@ConfigurationParameter(key = SNIPPET_TYPE_PROPERTY_NAME, value = "camelcase")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "not @slow")
public class RunCucumberTest {
}
