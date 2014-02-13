package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.devbliss.gwtbliss.client.ui.DefinitionDefinitionGWTTest;
import com.devbliss.gwtbliss.client.ui.DefinitionListPanelGWTTest;
import com.devbliss.gwtbliss.client.ui.DefinitionTermGWTTest;
import com.devbliss.gwtbliss.client.ui.FormLabelIntegrationGWTTest;
import com.devbliss.gwtbliss.client.ui.ImageAnchorIntegrationGWTTest;
import com.devbliss.gwtbliss.client.ui.ListItemPanelIntegrationGWTTest;
import com.devbliss.gwtbliss.client.ui.ListPanelIntegrationGWTTest;


/**
 * A utility class to optimize the order in which GWTTestCases are run by 
 * minimizing the number of times the test framework switches modules.
 * 
 * @author bmary
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    // adding GWTTestCases to suite
	DefinitionDefinitionGWTTest.class,
	DefinitionListPanelGWTTest.class,
	DefinitionTermGWTTest.class,
	FormLabelIntegrationGWTTest.class, 
	ImageAnchorIntegrationGWTTest.class, 
	ListItemPanelIntegrationGWTTest.class, 
	ListPanelIntegrationGWTTest.class
})
public class GWTTestSuite {
	
	public static final String TEST_MODULE_NAME = "com.devbliss.gwtbliss.GwtblissUI";
}
