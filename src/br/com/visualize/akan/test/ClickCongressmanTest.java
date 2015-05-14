package br.com.visualize.akan.test;

import com.robotium.solo.Solo;

import br.com.visualize.akan.domain.view.DescriptionScreen;
import br.com.visualize.akan.domain.view.ListScreen;
import android.test.ActivityInstrumentationTestCase2;

public class ClickCongressmanTest extends
		ActivityInstrumentationTestCase2<ListScreen> {
	
	// TODO: O que esse Solo faz?
	private Solo solo;
	
	@SuppressWarnings("deprecation")
	public ClickCongressmanTest() {
		super("br.com.visualize.akan", ListScreen.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testSelectCongressman() {
		solo.assertCurrentActivity("Verifica se está na primeira activity.", ListScreen.class);
		solo.clickOnText("NILTON CAPIXABA"); // TODO: Generalizar
		solo.assertCurrentActivity("Verifica se está na activity de descrição do parlamentar.", DescriptionScreen.class);
		solo.scrollDown();
		solo.scrollUp();
		solo.sleep(5);
		solo.goBack();
		solo.assertCurrentActivity("Verifica se voltou para a primeira activity", ListScreen.class);
	}
}













