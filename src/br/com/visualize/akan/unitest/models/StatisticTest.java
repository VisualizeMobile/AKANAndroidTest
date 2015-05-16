package br.com.visualize.akan.unitest.models;


import junit.framework.Assert;
import android.test.AndroidTestCase;
import br.com.visualize.akan.domain.enumeration.Month;
import br.com.visualize.akan.domain.enumeration.SubQuota;
import br.com.visualize.akan.domain.model.Statistic;


public class StatisticTest extends AndroidTestCase {
	private Statistic validStatistic = null;
	private Statistic nullStatistic = null;
	
	private SubQuota validSubQuota = null;
	private Month validMonth = null;
	
	public void setUp() {
		this.validStatistic = new Statistic();
		this.validSubQuota = SubQuota.WITHOUT_TYPE;
		this.validMonth = Month.WITHOUT_MONTH;
	}
	
	public void testValidInstantiationStatistic() {
		Assert.assertNotNull( validStatistic );
	}
	
	public void testInvalidInstantiationStatistic() {
		Assert.assertNull( nullStatistic );
	}
	
	public void testSubQuota() {
		this.validStatistic.setSubquota( validSubQuota );
		
		SubQuota result = this.validStatistic.getSubquota();
		SubQuota expectedResult = SubQuota.WITHOUT_TYPE;
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testYear() {
		this.validStatistic.setYear( 2010 );
		
		int result = this.validStatistic.getYear();
		int expectedResult = 2010;
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testMonth() {
		this.validStatistic.setMonth( validMonth );
		
		Month result = this.validStatistic.getMonth();
		Month expectedResult = Month.WITHOUT_MONTH;
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testStdDeviation() {
		this.validStatistic.setStdDeviation( 15.887 );
		
		double result = this.validStatistic.getStdDeviation();
		double expectedResult = 15.887;
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testAverage() {
		this.validStatistic.setAverage( 20.05 );
		
		double result = this.validStatistic.getAverage();
		double expectedResult = 20.05;
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testMaxValue() {
		this.validStatistic.setMaxValue( 25000.05 );
		
		double result = this.validStatistic.getMaxValue();
		double expectedResult = 25000.05;
		
		Assert.assertEquals( expectedResult, result );
	}
}
