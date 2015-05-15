package br.com.visualize.akan.unitest.models;


import junit.framework.Assert;
import android.test.AndroidTestCase;
import br.com.visualize.akan.domain.model.Url;


public class UrlTest extends AndroidTestCase {
	private Url validUrl = null;
	private Url nullUrl = null;
	
	public void setUp() {
		this.validUrl = new Url();
	}
	
	public void testValidInstantiationUrl() {
		Assert.assertNotNull( validUrl );
	}
	
	public void testInvalidInstantiationUrl() {
		Assert.assertNull( nullUrl );
	}
	
	public void testIdUpdateUrl() {
		this.validUrl.setIdUpdateUrl( 1 );
		
		int result = this.validUrl.getIdUpdateUrl();
		int expectedResult = 1;
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testUpdateVerifierUrl() {
		this.validUrl.setUpdateVerifierUrl( 1 );
		
		int result = this.validUrl.getUpdateVerifierUrl();
		int expectedResult = 1;
				
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testDefaultUrl() {
		this.validUrl.setDefaultUrl( "url test" );
		
		String result = this.validUrl.getDefaultUrl();
		String expectedResult = "url test";
				
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testFirstAlternativeUrl() {
		this.validUrl.setFirstAlternativeUrl( "url test" );
		
		String result = this.validUrl.getFirstAlternativeUrl();
		String expectedResult = "url test";
				
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testSecondAlternativeUrl() {
		this.validUrl.setSecondAlternativeUrl( "url test" );
		
		String result = this.validUrl.getSecondAlternativeUrl();
		String expectedResult = "url test";
				
		Assert.assertEquals( expectedResult, result );
	}
}
