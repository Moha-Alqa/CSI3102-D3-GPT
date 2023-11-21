package group26_HMS.pms.contracts
import io.cucumber.junit.platform.engine.Constants
import org.junit.platform.suite.api.ConfigurationParameter
import org.junit.platform.suite.api.IncludeEngines
import org.junit.platform.suite.api.SelectClasspathResource
import org.junit.platform.suite.api.Suite

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("group26_HMS/pms/contracts")
@ConfigurationParameter(
    key = Constants.GLUE_PROPERTY_NAME,
    value = "group26_HMS/pms/contracts"
)
class CucumberContracts {
}