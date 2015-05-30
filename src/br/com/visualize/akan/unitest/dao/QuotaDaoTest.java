package br.com.visualize.akan.unitest.dao;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import android.content.Context;
import android.test.AndroidTestCase;
import br.com.visualize.akan.api.dao.CongressmanDao;
import br.com.visualize.akan.api.dao.QuotaDao;
import br.com.visualize.akan.domain.exception.NullCongressmanException;
import br.com.visualize.akan.domain.model.Congressman;
import br.com.visualize.akan.domain.model.Quota;
import br.com.visualize.akan.domain.model.Statistic;


public class QuotaDaoTest extends AndroidTestCase {
	private QuotaDao validQuotaDao = null;
	private Quota validQuota = null;
	private Quota nullQuota = null;
	private List<Congressman> congressmanList = null;
	
	private Context context = null;
	
	protected void setUp() {
		this.context = getContext();
		
		instantiateValidEntitiesToTest();
		insertValidEntitiesInLocalDatabase();
	}

	protected void tearDown() {
		deleteValidEntitiesLocalDatabase();
	}
	
	public void testInstatiationNotNullQuotaDao() {
		Assert.assertNotNull( validQuotaDao );
	}
	
	public void testSameInstanceWithSingleton() {
		QuotaDao expectedQuotaDao = QuotaDao
		        .getInstance( context );
		
		Assert.assertSame( expectedQuotaDao, validQuotaDao );
	}
	
	public void testLocalDatabaseIsNotEmpty() {
		boolean result = validQuotaDao.checkEmptyLocalDb();
		
		Assert.assertFalse( result );
	}
	
	public void testLocalDatabaseIsEmpty() {
		deleteValidEntitiesLocalDatabase();
		
		boolean result = validQuotaDao.checkEmptyLocalDb();
		
		Assert.assertTrue( result );
	}
	
	public void testInsertValidQuota() {
		deleteValidEntitiesLocalDatabase();
		
		List<Quota> quotas = new ArrayList<Quota>();
		quotas.add( validQuota );
		
		boolean result = validQuotaDao.insertQuotasById( quotas );
		
		Assert.assertTrue( result );
	}
	
	public void testInsertNullQuota() {
		List<Quota> quotas = new ArrayList<Quota>();
		
		quotas.add( nullQuota );
		
		boolean result = validQuotaDao.insertQuotasById( quotas );
		
		Assert.assertTrue( result );
	}
	
	public void testInsertQuotaWithoutReferenceToCongressman() {
		/*! Write Test Here. */
	}
	
	public void testDeleteQuotasFromValidCongressman() {
		/*! Write Test Here. */
	}
	
	public void testDeleteQuotasFromCongressmanThatNoExist() {
		/*! Write Test Here. */
	}
	
	public void testDeleteQuotasWithEmptyDatabase() {
		/*! Write Test Here. */
	}
	
	public void testGetQuotasOfValidCongressman() {
		/*! Write Test Here. */
	}
	
	public void testGetQuotasOfCongressmanThatNoExist() {
		/*! Write Test Here. */
	}
	
	public void testGetQuotasOfCongressmanWithoutQuotas() {
		/*! Write Test Here. */
	}
	
	public void testGetYears() {
		/*! Write Test Here. */
	}
	
	public void testGetYearsWhenThereAreNotQuotas() {
		/*! Write Test Here. */
	}
	
	public void testGetYearsWhenQuotasDontHaveYear() {
		/*! Write Test Here. */
	}
	
	
	private void instantiateValidEntitiesToTest() {
		this.validQuotaDao = QuotaDao.getInstance( context );
		this.validQuota = new Quota();
		
		includeCongressmanInDatabase();
		setValidQuota();
    }

	private void insertValidEntitiesInLocalDatabase() {
		List<Quota> insertedQuotas = new ArrayList<Quota>();
		insertedQuotas.add( validQuota );
		
		validQuotaDao.insertQuotasById( insertedQuotas );
	}

	private void deleteValidEntitiesLocalDatabase() {
	    validQuotaDao.deleteQuotasFromCongressman( 1 );
	    deleteCongressmanOfDatabase();
    }
	
	private void setValidQuota() {
		Statistic statisticQuota = new Statistic();
		
		int congressmanId = congressmanList.get( 0 ).getIdCongressman();
		
	    this.validQuota.setIdCongressmanQuota( congressmanId );
	    this.validQuota.setValueQuota( 25000.00 );
	    this.validQuota.setDescriptionQuota( "valid description" );
	    this.validQuota.setIdQuota( 1 );
	    this.validQuota.setIdUpdateQuota( 1 );
	    this.validQuota.setTypeMonthByNumber( 3 );
	    this.validQuota.setTypeQuotaByNumber( 1 );
	    this.validQuota.setYearReferenceQuota( 2010 );
	    this.validQuota.setStatisticQuota( statisticQuota );
    }

	private void includeCongressmanInDatabase() {
		congressmanList = new ArrayList<Congressman>();
		
	    congressmanList.add( new Congressman() );
		congressmanList.get( 0 ).setIdCongressman( 1 );
		
		CongressmanDao congressmanDao = CongressmanDao.getInstance( context );
		congressmanDao.insertAllCongressman( congressmanList );
    }
	
	private void deleteCongressmanOfDatabase() {
		CongressmanDao congressmanDao = CongressmanDao.getInstance( context );
		try {
	        congressmanDao.deleteAllCongressman();
        } catch( NullCongressmanException e ) {
	        e.printStackTrace();
        }
	}
}
