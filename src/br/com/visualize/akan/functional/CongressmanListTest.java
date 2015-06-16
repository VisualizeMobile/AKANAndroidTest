package br.com.visualize.akan.functional;

import com.robotium.solo.Solo;

import br.com.visualize.akan.R;
import br.com.visualize.akan.domain.view.DescriptionScreen;
import br.com.visualize.akan.domain.view.ListScreen;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

public class CongressmanListTest extends
		ActivityInstrumentationTestCase2<ListScreen> {

	private Solo solo;

	@SuppressWarnings("deprecation")
	public CongressmanListTest() {
		super("br.com.visualize.akan", ListScreen.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testFollowCongressman() {
		solo.assertCurrentActivity("Verifica se está na primeira activity",
				ListScreen.class);
		solo.scrollDown();
		solo.scrollDown();
		solo.scrollToTop();
		solo.sleep(5);
		Button followCongressman = (Button) solo.getView("list_btn_follow");
		solo.clickOnView(followCongressman);
		assertTrue(solo.waitForDialogToOpen(2000));
		assertTrue(solo.waitForText("Parlamentar MARCELO AGUIAR seguido", 1,
				3000));
		solo.sleep(2000);
	}
}
