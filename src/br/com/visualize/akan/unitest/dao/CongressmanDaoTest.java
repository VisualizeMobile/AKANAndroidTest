package br.com.visualize.akan.unitest.dao;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import junit.framework.Assert;
import android.content.Context;
import android.test.AndroidTestCase;
import br.com.visualize.akan.api.dao.CongressmanDao;
import br.com.visualize.akan.domain.exception.NullCongressmanException;
import br.com.visualize.akan.domain.model.Congressman;


public class CongressmanDaoTest extends AndroidTestCase {
	static final boolean FOLLOWED = true;
	static final boolean NOT_FOLLOWED = false;
	
	private Context context = null;;
	private CongressmanDao validCongressmanDao = null;
	
	private Congressman validCongressmanA = null;
	private Congressman validCongressmanB = null;
	private Congressman validCongressmanC = null;
	
	private Congressman nullCongressman = null;
	
	protected void setUp() {
		this.context = getContext();
		
		instantiateValidEntitiesToTest();
		insertValidEntitiesInLocalDatabase();
	}
	
	protected void tearDown() {
		deleteValidEntitiesLocalDatabase();
	}
	
	public void testInstatitationNotNullCongressmanDao() {
		Assert.assertNotNull( validCongressmanDao );
	}
	
	public void testSameInstanceWithSingleton() {
		CongressmanDao expectedCongressmanDao = CongressmanDao
		        .getInstance( context );
		
		Assert.assertSame( expectedCongressmanDao, validCongressmanDao );
	}
	
	public void testLocalDatabaseIsNotEmpty() {
		boolean result = validCongressmanDao.checkEmptyLocalDb();
		
		Assert.assertFalse( result );
	}
	
	public void testLocalDatabaseIsEmpty() {
		deleteValidEntitiesLocalDatabase();
		
		boolean result = validCongressmanDao.checkEmptyLocalDb();
		
		Assert.assertTrue( result );
	}
	
	public void testInsertAllValidCongressman() {
		List<Congressman> congressmanList = new ArrayList<Congressman>();
		
		congressmanList.add( validCongressmanA );
		congressmanList.add( validCongressmanB );
		congressmanList.add( validCongressmanC );
		
		boolean result = 
				validCongressmanDao.insertAllCongressman( congressmanList );
		
		Assert.assertTrue( result );
	}
	
	public void testInsertAllNullCongressman() {
		List<Congressman> congressmanList = new ArrayList<Congressman>();
		
		congressmanList.add( nullCongressman );
		congressmanList.add( nullCongressman );
		congressmanList.add( nullCongressman );
		
		boolean result = 
				validCongressmanDao.insertAllCongressman( congressmanList );
		
		Assert.assertFalse( result );
	}
	
	public void testDeleteAllCongressman() {
		boolean result = false;
		
        try {
	        result = validCongressmanDao.deleteAllCongressman();

        } catch( NullCongressmanException e ) {
	        e.printStackTrace();
        }
		
		Assert.assertTrue( result );
	}
	
	public void testDeleteAllCongressmanWithEmptyDatabase() {
		deleteValidEntitiesLocalDatabase();
		
		boolean result = true;
		
		try {
			result = validCongressmanDao.deleteAllCongressman();
			
		} catch( NullCongressmanException e ) {
	        e.printStackTrace();
        }

		Assert.assertFalse( result );
	}
	
	public void testCongressmanIsFollowed() {
		boolean result = NOT_FOLLOWED;
		
		validCongressmanA.setStatusCogressman( FOLLOWED );
		
		try {
	        result = validCongressmanDao.
	        		setFollowedCongressman( validCongressmanA );
	        
        } catch( NullCongressmanException e ) {
	        e.printStackTrace();
        }
		
		Assert.assertTrue( result );
	}
	
	public void testCongressmanIsNotFollowed() {
		boolean result = FOLLOWED;
		
		validCongressmanA.setStatusCogressman( NOT_FOLLOWED );
		
		try {
	        result = validCongressmanDao.
	        		setFollowedCongressman( validCongressmanA );
	        
        } catch( NullCongressmanException e ) {
	        e.printStackTrace();
        }
		
		Assert.assertTrue( result );
	}

	public void testNullCongressmanIsFollowed() {
		boolean result = NOT_FOLLOWED;
		
		try {
	        result = validCongressmanDao.
	        		setFollowedCongressman( nullCongressman );
	        
        } catch( NullCongressmanException e ) {
	        e.printStackTrace();
        }
		
		Assert.assertFalse( result );
	}
	
	public void testListAllCongressmen() {
		List<Congressman> result = new ArrayList<Congressman>();
		result = validCongressmanDao.getAll();
		
		List<Congressman> expectedResult = new ArrayList<Congressman>();
		
		Assert.assertEquals( expectedResult.getClass(), result.getClass() );
	}
	
	public void testListAllCongressmenWithEmptyDatabase() {
		deleteValidEntitiesLocalDatabase();
		
		List<Congressman> result = new ArrayList<Congressman>();
		result = validCongressmanDao.getAll();
		
		List<Congressman> expectedResult = new ArrayList<Congressman>();
		
		Assert.assertEquals( expectedResult, result );
	}
	
	public void testListAllCongressmenWithoutForgettingAnyone() {
		List<Congressman> congressmanList = new ArrayList<Congressman>();
		congressmanList = validCongressmanDao.getAll();
		
		int expectedResult = 3;
		int result = congressmanList.size();
		
		Assert.assertEquals( expectedResult, result );
	}
	
	/* TODO: Create a issue, because this identify a error. */
	public void testSelectCongressmanByName() {
		List<Congressman> congressmanList = 
				validCongressmanDao.selectCongressmanByName( "valid name A" );
		
		List<Congressman> expectedList = new ArrayList<Congressman>();
		expectedList.add( validCongressmanA );
		
		boolean result = compareListCongressman( congressmanList, 
				expectedList );
		
		Assert.assertTrue( result );
	}
	
	/* TODO: Create a issue, because this identify a error. */
	public void testSelectCongressmanThatNotExist() {
		List<Congressman> congressmanList = 
				validCongressmanDao.selectCongressmanByName( "valid name D" );
		
		List<Congressman> expectedList = new ArrayList<Congressman>();
		expectedList.add( validCongressmanA );
		
		boolean result = compareListCongressman( congressmanList, 
				expectedList );
		
		Assert.assertFalse( result );
	}
	
	public void testSearchCongressmanBynameWithEmptyDatabase() {
		/*! Write Test Here. */
	}
	
	public void testSearchNullCongressmanByName() {
		/*! Write Test Here. */
	}
	
	private void instantiateValidEntitiesToTest() {
		this.validCongressmanDao = CongressmanDao.getInstance( context );
		this.validCongressmanA = new Congressman();
		this.validCongressmanB = new Congressman();
		this.validCongressmanC = new Congressman();
		
		setValidCongressmanA();
		setValidCongressmanB();
		setValidCongressmanC();
	}
	
	private void insertValidEntitiesInLocalDatabase() {
		List<Congressman> congressmanList = new ArrayList<Congressman>();
		
		congressmanList.add( validCongressmanA );
		congressmanList.add( validCongressmanB );
		congressmanList.add( validCongressmanC );
		
		validCongressmanDao.insertAllCongressman( congressmanList );
	}
	
	private void deleteValidEntitiesLocalDatabase() {
		try {
	        validCongressmanDao.deleteAllCongressman();
	        
        } catch( NullCongressmanException e ) {
	        e.printStackTrace();
        }
	}
	
	private void setValidCongressmanA() {
		this.validCongressmanA.setIdCongressman( 1 );
		this.validCongressmanA.setIdUpdateCongressman( 1 );
		this.validCongressmanA.setNameCongressman( "valid name A" );
		this.validCongressmanA.setPartyCongressman( "valid party A" );
		this.validCongressmanA.setRankingCongressman( 1 );
		this.validCongressmanA.setStatusCogressman( FOLLOWED );
		this.validCongressmanA.setTotalSpentCongressman( 25000.00 );
		this.validCongressmanA.setTypeCongressman( "Deputy" );
		this.validCongressmanA.setUfCongressman( "valid UF A" );
	}
	
	private void setValidCongressmanB() {
		this.validCongressmanB.setIdCongressman( 2 );
		this.validCongressmanB.setIdUpdateCongressman( 2 );
		this.validCongressmanB.setNameCongressman( "valid name B" );
		this.validCongressmanB.setPartyCongressman( "valid party B" );
		this.validCongressmanB.setRankingCongressman( 2 );
		this.validCongressmanB.setStatusCogressman( NOT_FOLLOWED );
		this.validCongressmanB.setTotalSpentCongressman( 25000.00 );
		this.validCongressmanB.setTypeCongressman( "Deputy" );
		this.validCongressmanB.setUfCongressman( "valid UF B" );
	}
	
	private void setValidCongressmanC() {
		this.validCongressmanC.setIdCongressman( 3 );
		this.validCongressmanC.setIdUpdateCongressman( 3 );
		this.validCongressmanC.setNameCongressman( "valid name B" );
		this.validCongressmanC.setPartyCongressman( "valid party B" );
		this.validCongressmanC.setRankingCongressman( 3 );
		this.validCongressmanC.setStatusCogressman( NOT_FOLLOWED );
		this.validCongressmanC.setTotalSpentCongressman( 25000.00 );
		this.validCongressmanC.setTypeCongressman( "Deputy" );
		this.validCongressmanC.setUfCongressman( "valid UF B" );
	}
	
	private boolean compareListCongressman( List<Congressman> congressmanList, 
			List<Congressman> expectedList ) {

		boolean result = false;
		
	    Collections.sort( congressmanList, new Comparator<Congressman>() {
			public int compare( Congressman c1, Congressman c2 ) {
				return c2.getNameCongressman().compareTo( c1.getNameCongressman() );
			}
		});
		
		Collections.sort( expectedList, new Comparator<Congressman>() {
			public int compare( Congressman c1, Congressman c2 ) {
				return c2.getNameCongressman().compareTo( c1.getNameCongressman() );
			}
		});
		
		int sizeCongressmanList = congressmanList.size();
		int sizeExpectedList = expectedList.size();
		
		if( sizeCongressmanList == sizeExpectedList ) {
			for( int index = 0; index < sizeCongressmanList; index++ ) {
				String nameCongressman = congressmanList.get( 0 ).getNameCongressman();
				String expectedName = expectedList.get( 0 ).getNameCongressman();
				
				if( nameCongressman.equals( expectedName ) ) {
					result = true;
				} else {
					result = false;
				}
			}
		} else {
			result = false;
		}

	    return result;
    }
}
