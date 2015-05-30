package br.com.visualize.akan.unitest.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	
	private Quota invalidQuota = null;
	private Quota validQuota = null;
	private Quota nullQuota = null;
	
	private int validId = 0;
	private int invalidId = 0;
	
	private List<Congressman> congressmanList = null;
	
	private Context context = null;
	
	protected void setUp() {
		this.context = getContext();
		
		instantiateValidEntitiesToTest();
		insertValidEntitiesInLocalDatabase();
		
		validId = congressmanList.get( 0 ).getIdCongressman();
		invalidId = 2;
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
		
		Assert.assertFalse( result );
	}
	
	public void testInsertQuotaWithoutReferenceToCongressman() {
		List<Quota> quotas = new ArrayList<Quota>();
		
		quotas.add( invalidQuota );
		
		boolean result = validQuotaDao.insertQuotasById( quotas );
		
		Assert.assertFalse( result );
	}
	
	public void testDeleteQuotasFromValidCongressman() {
		boolean result = validQuotaDao.deleteQuotasFromCongressman( 1 );
		
		Assert.assertTrue( result );
	}
	
	public void testDeleteQuotasFromCongressmanThatNoExist() {
		boolean result = validQuotaDao.deleteQuotasFromCongressman( 2 );
		
		Assert.assertFalse( result );
	}
	
	public void testDeleteQuotasWithEmptyDatabase() {
		deleteValidEntitiesLocalDatabase();
		
		boolean result = validQuotaDao.deleteQuotasFromCongressman( 1 );
		
		Assert.assertFalse( result );
	}
	
	public void testGetQuotasOfValidCongressman() {
		List<Quota> quotaList = new ArrayList<Quota>();
		quotaList = validQuotaDao.getQuotasByIdCongressman( validId );
		
		List<Quota> expectedList = new ArrayList<Quota>();
		expectedList.add( validQuota );
		
		boolean result = compareListQuota( quotaList, expectedList );
		
		Assert.assertTrue( result );
	}
	
	/* TODO: Need raise a exception. */
	public void testGetQuotasOfCongressmanThatNoExist() {
		List<Quota> quotaList = new ArrayList<Quota>();
		quotaList = validQuotaDao.getQuotasByIdCongressman( invalidId );
		
		List<Quota> expectedList = new ArrayList<Quota>();
		
		boolean result = compareListQuota( quotaList, expectedList );
		
		Assert.assertTrue( result );
	}
	
	/* TODO: Need raise a exception. */
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
		this.invalidQuota = new Quota();
		
		includeCongressmanInDatabase();
		setValidQuota();
    }

	private void insertValidEntitiesInLocalDatabase() {
		List<Quota> insertedQuotas = new ArrayList<Quota>();
		insertedQuotas.add( validQuota );
		
		validQuotaDao.insertQuotasById( insertedQuotas );
	}

	private void deleteValidEntitiesLocalDatabase() {
	    validQuotaDao.deleteQuotasFromCongressman( validId );
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
	
	private boolean compareListQuota( List<Quota> quotaList, 
			List<Quota> expectedList ) {

		boolean result = false;
		
	    sortListQuota( quotaList );
		sortListQuota( expectedList );
		
		result = isListQuotaEquals( quotaList, expectedList );

	    return result;
    }
	
	private boolean isListQuotaEquals( List<Quota> quotaList,
            List<Quota> expectedList ) {
		boolean result = false;
		
	    int sizeQuotaList = quotaList.size();
		int sizeExpectedList = expectedList.size();
		
		if( sizeQuotaList == sizeExpectedList ) {
			if( sizeQuotaList != 0 ) {
				for( int index = 0; index < sizeQuotaList; index++ ) {
					int quotaId = quotaList.get( index ).getIdQuota();
					int expectedId = expectedList.get( index ).getIdQuota();
					
					if( quotaId == expectedId ) {
						result = true;
					} else {
						result = false;
					}
				}
			} else {
				result = true;
			}
		} else {
			result = false;
		}
		
	    return result;
    }
	
	private void sortListQuota( List<Quota> quotaList ) {
	    Collections.sort( quotaList, new Comparator<Quota>() {
			public int compare( Quota c1, Quota c2 ) {
				return Integer.valueOf( c1.getIdQuota() ).
						compareTo( c2.getIdQuota() );
			}
		});
    }
}
