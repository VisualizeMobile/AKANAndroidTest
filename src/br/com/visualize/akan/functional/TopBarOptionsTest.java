package br.com.visualize.akan.functional;

import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.ImageButton;
import br.com.visualize.akan.R;
import br.com.visualize.akan.domain.view.AboutAkanScreen;
import br.com.visualize.akan.domain.view.ListScreen;

public class TopBarOptionsTest extends
		ActivityInstrumentationTestCase2<ListScreen> {

	private Solo solo;
	@SuppressWarnings("deprecation")
	public TopBarOptionsTest() {
		super("br.com.visualize.akan", ListScreen.class);

	}
	
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	   
	    

	}
	
	public void testSelectAboutScreen(){
		solo.assertCurrentActivity("Verifica se está na primeira activity.",
				ListScreen.class);
		ImageButton aboutButon = (ImageButton) solo.getView(R.id.topbar_about_button);
		//solo.assertCurrentActivity("Verifica se está na tela de about.",
			//	AboutAkanScreen.class);
		solo.clickOnView(aboutButon);
		solo.scrollDown();
		solo.sleep(2000);
		solo.scrollDown();
		solo.sleep(2000);
		solo.scrollDown();
		solo.sleep(2000);
		solo.scrollUp();
		solo.sleep(2000);
		solo.scrollUp();
		solo.scrollDown();
		
	}
	public void testSelectConfigurationScreen(){
		solo.assertCurrentActivity("Verifica se está na primeira activity.",
				ListScreen.class);
		ImageButton configurationButon = (ImageButton) solo.getView(R.id.topbar_config_button);
		solo.clickOnView(configurationButon);
		solo.clickOnText("DEM");
		solo.goBack();
		solo.waitForText("DEM");
	}
	

	
}
