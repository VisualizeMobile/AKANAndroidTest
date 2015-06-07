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
	
	private String validUrlDefault = "http://www.defaulturl.com";
	private String validUrlFirstAlternative = "http://www.firsturl.com";
	private String validUrlSecondAlternative = "http://www.secondurl.com";
	
	private String invalidUrlDefault = "defaulturl.com";
    private String invalidUrlFirstAlternative = "firsturl.com";
    private String invalidUrlSecondAlternative = "secondurl.com";
	
	private Context context = null;
	
	protected void setUp() {
		context = getContext();
		
		instantiateEntitiesToTest();
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
	
	/* TODO: need raise a exception. */
	public void testInsertInvalidUrl() {
		boolean result = validUrlDao.insertUrl( invalidUrl );
		
		Assert.assertFalse( result );
	}
	
	/* TODO: need raise a exception. */
	public void testInsertNullUrl() {
		boolean result = validUrlDao.insertUrl( nullUrl );
		
		Assert.assertFalse( result );
	}
	
	/* TODO: need raise a exception. */
	public void testDeleteValidUrl() {
		boolean result = validUrlDao.deleteUrl( validUrl );
		
		Assert.assertTrue( result );
	}
	
	/* TODO: need raise a exception. */
	public void testDeleteUrlWithoutId() {
		boolean result = validUrlDao.deleteUrl( invalidUrl );
		
		Assert.assertFalse( result );
	}
	
	/* TODO: need raise a exception. */
	public void testDeleteNullUrl() {
		boolean result = validUrlDao.deleteUrl( nullUrl );
		
		Assert.assertFalse( result );
	}
	
	/* TODO: need raise a exception. */
	public void testDeleteValidUrlWithEmptyDatabase() {
		deleteValidEntitiesLocalDatabase();
		
		boolean result = validUrlDao.deleteUrl( validUrl );
		
		Assert.assertFalse( result );
	}
	
	public void testGetValidUrl() {
		Url caughtUrl = validUrlDao.getUrl();
		
		int result = caughtUrl.getIdUpdateUrl();
		int expectedResult = 0;
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testGetUrlWithEmptyDatabase() {
		deleteValidEntitiesLocalDatabase();
		
		Url caughtUrl = validUrlDao.getUrl();
		
		int result = caughtUrl.getIdUpdateUrl();
		int expectedResult = 0;
		
		Assert.assertTrue( ( expectedResult == result ) );
	}
	
	private void deleteValidEntitiesLocalDatabase() {
		validUrlDao.deleteUrl( validUrl );
	}
	
	private void insertValidEntitiesInLocalDatabase() {
		validUrlDao.insertUrl( validUrl );
	}
	
	private void instantiateEntitiesToTest() {
		validUrl = new Url();
		invalidUrl = new Url();
		validUrlDao = UrlDao.getInstance( context );
		
		setEntities();
	}
	
	private void setEntities() {
		this.validUrl.setIdUpdateUrl( 0 );
		this.validUrl.setUpdateVerifierUrl( 0 );
		this.validUrl.setDefaultUrl( validUrlDefault );
		this.validUrl.setFirstAlternativeUrl( validUrlFirstAlternative );
		this.validUrl.setSecondAlternativeUrl( validUrlSecondAlternative );
		
		this.invalidUrl.setIdUpdateUrl( 0 );
        this.invalidUrl.setUpdateVerifierUrl( 0 );
        this.invalidUrl.setDefaultUrl( invalidUrlDefault );
        this.invalidUrl.setFirstAlternativeUrl( invalidUrlFirstAlternative );
        this.invalidUrl.setSecondAlternativeUrl( invalidUrlSecondAlternative );
	}
}
