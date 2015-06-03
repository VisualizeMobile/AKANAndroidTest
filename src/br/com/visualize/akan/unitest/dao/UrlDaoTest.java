package br.com.visualize.akan.unitest.dao;

import junit.framework.Assert;
import android.content.Context;
import android.test.AndroidTestCase;
import br.com.visualize.akan.api.dao.UrlDao;
import br.com.visualize.akan.domain.model.Url;


public class UrlDaoTest extends AndroidTestCase {
	private Url validUrl = null;
	private Url invalidUrl = null;
	private Url nullUrl = null;
	
	private UrlDao validUrlDao = null;
	
	private String urlDefault = "http://www.defaulturl.com";
	private String urlFirstAlternative = "http://www.firsturl.com";
	private String urlSecondAlternative = "http://www.secondurl.com";
	
	private Context context = null;
	
	protected void setUp() {
		context = getContext();
		
		instantiateValidEntitiesToTest();
		insertValidEntitiesInLocalDatabase();
	}

	protected void tearDown() {
		deleteValidEntitiesLocalDatabase();
	}
	
	public void testInstatiationNotNullUrlDao() {
		Assert.assertNotNull( validUrlDao );
	}
	
	public void testSameInstanceWithSingleton() {
		UrlDao expectedUrlDao = UrlDao.getInstance( context );
		
		Assert.assertSame( expectedUrlDao, validUrlDao );
	}
	
	public void testLocalDatabaseIsNotEmpty() {
		boolean result = validUrlDao.checkEmptyLocalDb();
		
		Assert.assertFalse( result );
	}
	
	public void testLocalDatabaseIsEmpty() {
		deleteValidEntitiesLocalDatabase();
		
		boolean result = validUrlDao.checkEmptyLocalDb();
		
		Assert.assertTrue( result );
	}
	
	public void testInsertValidUrl() {
		boolean result = validUrlDao.insertUrl( validUrl );
		Assert.assertTrue( result );
	}
	
	/*TODO: need raise a exception. */
	public void testInsertInvalidUrl() {
		boolean result = validUrlDao.insertUrl( invalidUrl );
		
		Assert.assertFalse( result );
	}
	
	/*TODO: need raise a exception. */
	public void testInsertNullUrl() {
		boolean result = validUrlDao.insertUrl( nullUrl );
		
		Assert.assertFalse( result );
	}
	
	public void testDeleteValidUrl() {
		boolean result = validUrlDao.deleteUrl( validUrl );
		
		Assert.assertTrue( result );
	}

	
	
	private void deleteValidEntitiesLocalDatabase() {
		validUrlDao.deleteUrl( validUrl );
    }

	private void insertValidEntitiesInLocalDatabase() {
	    validUrlDao.insertUrl( validUrl );
	    
    }

	private void instantiateValidEntitiesToTest() {
	    validUrl = new Url();
	    invalidUrl = new Url();
	    validUrlDao = UrlDao.getInstance( context );
	    
	    setValidUrl();
    }

	private void setValidUrl() {
		this.validUrl.setIdUpdateUrl( 1 );
		
	    this.validUrl.setDefaultUrl( urlDefault );
	    this.validUrl.setFirstAlternativeUrl( urlFirstAlternative );
	    this.validUrl.setSecondAlternativeUrl( urlSecondAlternative );
    }
}
