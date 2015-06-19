package br.com.visualize.akan.functional;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import br.com.visualize.akan.domain.view.DescriptionScreen;
import br.com.visualize.akan.domain.view.ListScreen;

import com.robotium.solo.Solo;

public class CongressmanDescriptionTest extends
		ActivityInstrumentationTestCase2<ListScreen> {

	private Solo solo;
	@SuppressWarnings("deprecation")
	public CongressmanDescriptionTest() {
		super("br.com.visualize.akan", ListScreen.class);

	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	   
	    

	}

	public void testSelectCongressman() {
		solo.assertCurrentActivity("Verifica se está na primeira activity.",
				ListScreen.class);
		
		ListView myList = (ListView) solo.getView(R.id.listView);

		View congressman = myList.getChildAt(2);
		TextView congressmanName = (TextView) (congressman
				.findViewById(R.id.ranking_layout_txt_congressman_name));
		solo.clickOnView(congressman);
		solo.assertCurrentActivity(
				"Verifica se está na activity de descrição do parlamentar.",
				DescriptionScreen.class);
		solo.sleep(4000);
		solo.goBack();
		solo.assertCurrentActivity(
				"Verifica se voltou para a primeira activity", ListScreen.class);
		solo.sleep(2000);
	}

	public void testFollowCongressmanInDescriptionScreen() {
		solo.assertCurrentActivity("Verifica se está na primeira activity.",
				ListScreen.class);
		ListView myList = (ListView) solo.getView(R.id.listView);

		View congressman = myList.getChildAt(4);
		TextView congressmanName = (TextView) (congressman
				.findViewById(R.id.ranking_layout_txt_congressman_name));
		solo.clickOnView(congressman);
		solo.assertCurrentActivity(
				"Verifica se está na activity de descrição do parlamentar.",
				DescriptionScreen.class);
		Button followCongressman = (Button) solo
				.getView("description_btn_follow");
		solo.clickOnView(followCongressman);
		//assertTrue(solo.waitForDialogToOpen(2000));
		assertTrue(solo.waitForText("Parlamentar "+congressmanName.getText().toString()+ " seguido"));
		solo.sleep(2000);
		solo.clickOnView(followCongressman);
	}

	public void testSelectReferenceMonth() {
		solo.assertCurrentActivity("Verifica se está na primeira activity.",
				ListScreen.class);
		ListView myList = (ListView) solo.getView(R.id.listView);

		View congressman = myList.getChildAt(1);
		solo.clickOnView(congressman);
		solo.assertCurrentActivity(
				"Verifica se está na activity de descrição do parlamentar.",
				DescriptionScreen.class);
		TextView referenceMonth = (TextView) solo.getView("reference_month");
		solo.clickOnView(referenceMonth);
		assertTrue(solo.waitForDialogToOpen(2000));
		assertTrue(solo.waitForText("Período"));
		solo.sleep(2000);
		solo.setDatePicker(0, 2015, 0, 1);
		solo.clickOnText("Concluído");
		solo.sleep(3000);
	}

	public void testSelectQuota() {
		solo.assertCurrentActivity("Verifica se está na primeira activity.",
				ListScreen.class);

		solo.clickOnText("OSMAR BERTOLDI");
		solo.sleep(5000);
		solo.assertCurrentActivity(
				"Verifica se está na activity de descrição do parlamentar.",
				DescriptionScreen.class);
		// The number 4 represents the first quota on the grid from left to
		// right
		solo.clickOnImage(4);
		solo.sleep(2000);
		assertTrue(solo.waitForText("Combustível"));
		solo.goBack();
		solo.sleep(1000);

		solo.clickOnImage(6);
		solo.sleep(2000);
		assertTrue(solo.waitForText("Pesquisas e Consultorias"));
		solo.goBack();

		solo.sleep(1000);
		solo.clickOnImage(12);
		solo.sleep(2000);
		assertTrue(solo.waitForText("Telefonia"));
		solo.goBack();

		solo.assertCurrentActivity(
				"Verifica se está na activity de descrição do parlamentar.",
				DescriptionScreen.class);
	}

}
