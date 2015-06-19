package br.com.visualize.akan.functional;

import java.util.regex.Pattern;

import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;
import br.com.visualize.akan.domain.view.ListScreen;

public class CongressmanRankingTest extends
		ActivityInstrumentationTestCase2<ListScreen> {

	public CongressmanRankingTest() {
		super(ListScreen.class);
		// TODO Auto-generated constructor stub
	}

	private Solo solo;

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testShowRankingPositionAndSpendValue() {
		solo.assertCurrentActivity("Verifica se está na primeira activity.",
				ListScreen.class);
		Button rankingButton = (Button) solo.getView("btn_ranking");
		solo.clickOnView(rankingButton);
		TextView ranking_position = (TextView) solo
				.getView("ranking_layout_position");
		TextView valueSpend = (TextView) solo
				.getView("ranking_layout_txt_value");
		assertNotNull(valueSpend.getText().toString());
		assertNotNull(ranking_position.getText().toString());
		solo.sleep(3000);

	}

	public void testFollowCongressmanOnRankingList() {
		solo.assertCurrentActivity("Verifica se está na primeira activity.",
				ListScreen.class);
		Button rankingButton = (Button) solo.getView("btn_ranking");
		solo.clickOnView(rankingButton);
		Button followCongressman = (Button) solo.getView("list_btn_follow");
		solo.clickOnView(followCongressman);
		//assertTrue(solo.waitForDialogToOpen(2000));
		assertTrue(solo.waitForText("Parlamentar MARCELO AGUIAR seguido", 1,
				3000));
		solo.sleep(2000);
		Button UnfollowCongressman = (Button) solo.getView("list_btn_follow");
		solo.clickOnView(UnfollowCongressman);
		solo.sleep(2000);
	}

}
