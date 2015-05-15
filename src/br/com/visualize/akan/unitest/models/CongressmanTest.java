package br.com.visualize.akan.unitest.models;


import junit.framework.Assert;
import android.test.AndroidTestCase;
import br.com.visualize.akan.domain.model.Congressman;


public class CongressmanTest extends AndroidTestCase {
	private Congressman validCongressman = null;
	private Congressman nullCongressman = null;
	
	public void setUp() {
		this.validCongressman = new Congressman();
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
}
