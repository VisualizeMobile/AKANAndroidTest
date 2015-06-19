package br.com.visualize.akan.functional;

import java.util.regex.Pattern;

import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import br.com.visualize.akan.R;
import br.com.visualize.akan.domain.view.ListScreen;

public class CongressmanFollowedTest extends
		ActivityInstrumentationTestCase2<ListScreen> {

	private Solo solo;

	@SuppressWarnings("deprecation")
	public CongressmanFollowedTest() {
		super("br.com.visualize.akan", ListScreen.class);

	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testFollwedList() {
		solo.clickOnText("FELIPE MAIA");
		Button followCongressmanOnDescription = (Button) solo
				.getView("description_btn_follow");
		solo.clickOnView(followCongressmanOnDescription);
		solo.sleep(2000);
		solo.goBack();

		Button listOfFollowedCongressman = (Button) solo.getView("btn_follow");
		solo.clickOnView(listOfFollowedCongressman);
		assertTrue(solo.searchText("FELIPE MAIA"));

		solo.sleep(2000);

		Button followCongressmanOnList = (Button) solo
				.getView("list_btn_follow");
		solo.clickOnView(followCongressmanOnList);
		solo.sleep(1000);

		solo.clickOnView(listOfFollowedCongressman);
		solo.sleep(1000);
	}

	public void testRankingInFollwedList() {
		solo.clickOnText("MENDONÇA FILHO");
		Button followCongressman1 = (Button) solo
				.getView("description_btn_follow");
		solo.clickOnView(followCongressman1);
		solo.sleep(2000);
		solo.goBack();
		
		solo.clickOnText("HÉLIO LEITE");
		Button followCongressman2 = (Button) solo
				.getView("description_btn_follow");
		solo.clickOnView(followCongressman2);
		solo.sleep(2000);
		solo.goBack();
		
		Button listFollowedCongressman = (Button) solo.getView("btn_follow");
		solo.clickOnView(listFollowedCongressman);
		Button rankingButton = (Button) solo.getView("btn_ranking");
		solo.clickOnView(rankingButton);

		solo.sleep(1000);

		ListView myList = (ListView) solo.getView(R.id.listView);

		View followedCongressman1 = myList.getChildAt(0);
		TextView ranking_position1 = (TextView) (followedCongressman1
				.findViewById(R.id.ranking_layout_position));
		TextView valueSpend1 = (TextView) (followedCongressman1
				.findViewById(R.id.ranking_layout_txt_value));
		Button followCongressmanOnList1 = (Button) (followedCongressman1
				.findViewById(R.id.list_btn_follow));

		View followedCongressman2 = myList.getChildAt(1);
		TextView ranking_position2 = (TextView) (followedCongressman2
				.findViewById(R.id.ranking_layout_position));
		TextView valueSpend2 = (TextView) (followedCongressman2
				.findViewById(R.id.ranking_layout_txt_value));
		Button followCongressmanOnList2 = (Button) (followedCongressman1
				.findViewById(R.id.list_btn_follow));

		assertNotNull( valueSpend1.getText().toString());
		assertNotNull( valueSpend2.getText().toString());

		assertNotNull(ranking_position1.getText().toString());
		assertNotNull(ranking_position2.getText().toString());
		
		solo.sleep(2000);
		
		solo.clickOnView(followCongressmanOnList1);
		solo.clickOnView(followCongressmanOnList2);

		solo.clickOnView(rankingButton);
		solo.clickOnView(listFollowedCongressman);

		solo.sleep(1000);
	}

}
