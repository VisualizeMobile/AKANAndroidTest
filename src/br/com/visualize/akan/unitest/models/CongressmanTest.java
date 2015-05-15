package br.com.visualize.akan.unitest.models;


import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import android.test.AndroidTestCase;
import br.com.visualize.akan.domain.model.Congressman;
import br.com.visualize.akan.domain.model.Quota;


public class CongressmanTest extends AndroidTestCase {
	private Congressman validCongressman = null;
	private Congressman nullCongressman = null;
	private List<Quota> validQuotas = null;
	private Quota validQuota = null;
	
	public void setUp() {
		this.validCongressman = new Congressman();
		this.validQuota = new Quota();
		this.validQuotas = new ArrayList<Quota>();
	}
	
	public void testValidInstantiationCongressman() {
		Assert.assertNotNull( validCongressman );
	}
	
	public void testInvalidInstantiationCongressman() {
		Assert.assertNull( nullCongressman );
	}
	
	public void testIdCongressman() {
		this.validCongressman.setIdCongressman( 1 );
		
		int result = this.validCongressman.getIdCongressman();
		int expectedResult = 1;
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testIdUpdateCongressman() {
		this.validCongressman.setIdUpdateCongressman( 1 );
		
		int result = this.validCongressman.getIdUpdateCongressman();
		int expectedResult = 1;
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testIsFollowedCongressman() {
		final boolean FOLLOWED = true;
		
		this.validCongressman.setStatusCogressman( FOLLOWED );
		
		boolean result = this.validCongressman.isStatusCogressman();
		boolean expectedResult = FOLLOWED;
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testIsNotFollowedCongressman() {
		final boolean NOT_FOLLOWED = false;
		
		this.validCongressman.setStatusCogressman( NOT_FOLLOWED );
		
		boolean result = this.validCongressman.isStatusCogressman();
		boolean expectedResult = NOT_FOLLOWED;
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testNameCongressman() {
		this.validCongressman.setNameCongressman( "tested congressman" );
		
		String result = this.validCongressman.getNameCongressman();
		String expectedResult = "tested congressman";
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testPartyCongressman() {
		this.validCongressman.setPartyCongressman( "tested party" );
		
		String result = this.validCongressman.getPartyCongressman();
		String expectedResult = "tested party";
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testUfCongressman() {
		this.validCongressman.setUfCongressman( "tested UF" );
		
		String result = this.validCongressman.getUfCongressman();
		String expectedResult = "tested UF";
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testQuotasCongressman() {
		validQuotas.add( validQuota );
		this.validCongressman.setQuotasCongressman( validQuotas );
		
		List<Quota> result = this.validCongressman.getQuotasCongressman();
		List<Quota> expectedResult = validQuotas;
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testTotalSpentCongressman() {
		this.validCongressman.setTotalSpentCongressman( 1000.00 );
		
		double result = this.validCongressman.getTotalSpentCongressman();
		double expectedResult = 1000.00;
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testRankingCongressman() {
		this.validCongressman.setRankingCongressman( 100 );
		
		int result = this.validCongressman.getRankingCongressman();
		int expectedResult = 100;
		
		Assert.assertEquals( expectedResult, result );
	}
}
