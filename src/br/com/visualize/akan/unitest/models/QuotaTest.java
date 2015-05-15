package br.com.visualize.akan.unitest.models;


import junit.framework.Assert;
import android.test.AndroidTestCase;
import br.com.visualize.akan.domain.model.Quota;
import br.com.visualize.akan.domain.enumeration.Month;
import br.com.visualize.akan.domain.enumeration.SubQuota;


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
	
	public void testTypeQuota() {
		this.validQuota.setTypeQuotaByNumber( 0 );
		
		SubQuota result = this.validQuota.getTypeQuota();
		SubQuota expectedResult = SubQuota.WITHOUT_TYPE;
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testMonthReferenceQuota() {
		this.validQuota.setTypeMonthByNumber( 1 );
		
		Month result = this.validQuota.getMonthReferenceQuota();
		Month expectedResult = Month.JANUARY;
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testYearQuota() {
		this.validQuota.setYearReferenceQuota( 2010 );
		
		int result = this.validQuota.getYearReferenceQuota();
		int expectedResult = 2010;
		
		Assert.assertEquals( expectedResult, result );
	}
}
