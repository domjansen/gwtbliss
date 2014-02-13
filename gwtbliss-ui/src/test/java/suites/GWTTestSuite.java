package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.devbliss.gwtbliss.client.ui.DefinitionDefinitionGWTTest;
import com.devbliss.gwtbliss.client.ui.DefinitionListPanelGWTTest;
import com.devbliss.gwtbliss.client.ui.DefinitionTermGWTTest;
import com.devbliss.gwtbliss.client.ui.FormLabelGWTTest;
import com.devbliss.gwtbliss.client.ui.ImageAnchorGWTTest;
import com.devbliss.gwtbliss.client.ui.ListItemPanelGWTTest;
import com.devbliss.gwtbliss.client.ui.ListPanelGWTTest;


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
	FormLabelGWTTest.class, 
	ImageAnchorGWTTest.class, 
	ListItemPanelGWTTest.class, 
	ListPanelGWTTest.class
})
public class GWTTestSuite {
	
	public static final String TEST_MODULE_NAME = "com.devbliss.gwtbliss.GwtblissUI";
}
