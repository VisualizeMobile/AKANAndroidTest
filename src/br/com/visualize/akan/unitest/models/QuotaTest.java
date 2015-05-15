package br.com.visualize.akan.unitest.models;


import junit.framework.Assert;
import android.test.AndroidTestCase;
import br.com.visualize.akan.domain.model.Quota;


public class QuotaTest extends AndroidTestCase {
	private Quota validQuota = null;
	private Quota nullQuota = null;
	
	public void setUp() {
		this.validQuota = new Quota();
	}
	
	public void testValidInstantiationQuota() {
		Assert.assertNotNull( validQuota );
	}
	
	public void testInvalidInstantiationQuota() {
		Assert.assertNull( nullQuota );
	}
	
	public void testIdQuota() {
		this.validQuota.setIdQuota( 1 );
		
		int result = this.validQuota.getIdQuota();
		int expectedResult = 1;
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testIdUpdateQuota() {
		this.validQuota.setIdUpdateQuota( 1 );
		
		int result = this.validQuota.getIdUpdateQuota();
		int expectedResult = 1;
		
		Assert.assertEquals( expectedResult, result );
	}
}
