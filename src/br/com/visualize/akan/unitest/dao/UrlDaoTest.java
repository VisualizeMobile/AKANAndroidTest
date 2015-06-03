package br.com.visualize.akan.unitest.dao;

import android.content.Context;
import android.test.AndroidTestCase;
import br.com.visualize.akan.api.dao.UrlDao;
import br.com.visualize.akan.domain.model.Url;


public class UrlDaoTest extends AndroidTestCase {
	private Url validUrl = null;
	private Url invalidUrl = null;
	private Url nullUrl = null;
	
	private UrlDao validUrlDao = null;
	
	private Context context = null;
	
	protected void setUp() {
		context = getContext();
		
		instantiateValidEntitiesToTest();
		insertValidEntitiesInLocalDatabase();
	}

	protected void tearDown() {
		deleteValidEntitiesLocalDatabase();
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
	 
    }
}
