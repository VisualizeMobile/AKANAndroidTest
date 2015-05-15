package br.com.visualize.akan.unitest.models;


import junit.framework.Assert;
import android.test.AndroidTestCase;
import br.com.visualize.akan.domain.enumeration.SubQuota;
import br.com.visualize.akan.domain.model.Statistic;


public class StatisticTest extends AndroidTestCase {
	private Statistic validStatistic = null;
	private Statistic nullStatistic = null;
	private SubQuota validSubQuota = null;
	
	public void setUp() {
		this.validStatistic = new Statistic();
		this.validSubQuota = SubQuota.WITHOUT_TYPE;
	}
	
	public void testValidInstantiationStatistic() {
		Assert.assertNotNull( validStatistic );
	}
	
	public void testInvalidInstantiationStatistic() {
		Assert.assertNotNull( nullStatistic );
	}
	
	public void testSubQuota() {
		this.validStatistic.setSubquota( validSubQuota );
		
		SubQuota result = this.validStatistic.getSubquota();
		SubQuota expectedResult = SubQuota.WITHOUT_TYPE;
		
		Assert.assertEquals( expectedResult, result );
	}
}
