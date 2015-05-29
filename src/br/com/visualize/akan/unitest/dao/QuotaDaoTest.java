package br.com.visualize.akan.unitest.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.test.AndroidTestCase;
import br.com.visualize.akan.api.dao.QuotaDao;
import br.com.visualize.akan.domain.model.Quota;
import br.com.visualize.akan.domain.model.Statistic;

public class QuotaDaoTest extends AndroidTestCase {
	private QuotaDao validQuotaDao = null;
	private Quota validQuota = null;
	
	private Context context = null;
	
	protected void setUp() {
		this.context = getContext();
		
		instantiateValidEntitiesToTest();
		insertValidEntitiesInLocalDatabase();
	}

	protected void tearDown() {
		deleteValidEntitiesLocalDatabase();
	}
	
	private void instantiateValidEntitiesToTest() {
		this.validQuotaDao = QuotaDao.getInstance( context );
		this.validQuota = new Quota();
		
		setValidQuota();
	    
    }

	private void insertValidEntitiesInLocalDatabase() {
		List<Quota> insertedQuotas = new ArrayList<Quota>();
		insertedQuotas.add( validQuota );
		
		validQuotaDao.insertQuotasById( insertedQuotas );
	}

	private void deleteValidEntitiesLocalDatabase() {
	    validQuotaDao.deleteQuotasFromCongressman( 1 );
    }
	
	private void setValidQuota() {
		Statistic statisticQuota = new Statistic();
		
	    validQuota.setIdCongressmanQuota( 1 );
	    validQuota.setValueQuota( 250000.00 );
	    validQuota.setDescriptionQuota( "valid description" );
	    validQuota.setIdQuota( 1 );
	    validQuota.setIdUpdateQuota( 1 );
	    validQuota.setTypeMonthByNumber( 3 );
	    validQuota.setTypeQuotaByNumber( 1 );
	    validQuota.setYearReferenceQuota( 2010 );
	    validQuota.setStatisticQuota( statisticQuota );
    }
}
