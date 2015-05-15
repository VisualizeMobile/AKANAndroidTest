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
}
