package br.com.visualize.akan.functional;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import br.com.visualize.akan.domain.view.ListScreen;

import com.robotium.solo.Solo;

public class CongressmanSearchTest extends
		ActivityInstrumentationTestCase2<ListScreen> {

	private Solo solo;

	@SuppressWarnings("deprecation")
	public CongressmanSearchTest() {
		super("br.com.visualize.akan", ListScreen.class);

	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testMatchFirstName() {
		Button searchButton = (Button) solo.getView("btn_search");
		solo.clickOnView(searchButton);
		solo.enterText(0, "tiririca");
		assertTrue(solo.waitForText("TIRIRICA"));
		solo.sleep(3000);
	}

	public void testMatchSecondName() {
		Button searchButton = (Button) solo.getView("btn_search");
		solo.clickOnView(searchButton);
		solo.enterText(0, "campos");
		assertTrue(solo.waitForText("JÚLIO CAMPOS"));
		solo.sleep(3000);
	}

}
