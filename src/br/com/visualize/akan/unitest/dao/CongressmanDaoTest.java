package br.com.visualize.akan.unitest.dao;

import junit.framework.Assert;
import android.content.Context;
import android.test.AndroidTestCase;
import br.com.visualize.akan.api.dao.CongressmanDao;
import br.com.visualize.akan.domain.model.Congressman;

public class CongressmanDaoTest extends AndroidTestCase {
	private Context context = null;;
	private CongressmanDao validCongressmanDao = null;
	
	private Congressman validCongressmanA = null;
	private Congressman validCongressmanB = null;
	private Congressman validCongressmanC = null;
	
	protected void setUp() {
		this.context = getContext();
		this.validCongressmanDao = CongressmanDao.getInstance( context );
		this.validCongressmanA = new Congressman();
		this.validCongressmanB = new Congressman();
		this.validCongressmanC = new Congressman();
	}
	
	public void testInstatitationNotNullCongressmanDao() {
		Assert.assertNotNull( validCongressmanDao );
	}
	
	public void testSameInstanceWithSingleton() {
		CongressmanDao expectedCongressmanDao = 
				CongressmanDao.getInstance( context );
		
		Assert.assertSame( expectedCongressmanDao, validCongressmanDao );
	}
}
