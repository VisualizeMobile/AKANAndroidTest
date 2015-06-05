package br.com.visualize.akan.unitest.controller;


import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import android.content.Context;
import android.test.AndroidTestCase;
import br.com.visualize.akan.api.dao.CongressmanDao;
import br.com.visualize.akan.domain.controller.CongressmanController;
import br.com.visualize.akan.domain.exception.LocalDatabaseInvalidOperationException;
import br.com.visualize.akan.domain.exception.NullCongressmanException;
import br.com.visualize.akan.domain.model.Congressman;


public class CongressmanControllerTest extends AndroidTestCase {
    static final boolean FOLLOWED = true;
    static final boolean NOT_FOLLOWED = false;
    
    private CongressmanController validCongressmanController = null;
    
    private CongressmanDao validCongressmanDao = null;
    private Congressman validCongressman = null;
    private Context context = null;
    
    public void setUp() {
        this.context = getContext();
        
        instantiateValidEntitiesToTest();
        insertValidEntitiesInLocalDatabase();
    }
    
    public void tearDown() {
        deleteEntitiesLocalDatabase();
    }
    
    public void testInstatitationNotNullCongressmanController() {
        Assert.assertNotNull( validCongressmanController );
    }
    
    public void testSameInstanceWithSingleton() {
        CongressmanController expectedCongressmanController = CongressmanController
                .getInstance( context );
        
        Assert.assertSame( expectedCongressmanController,
                validCongressmanController );
    }
    
    public void testSetCongressmanControllerWithValidCongressman() {
        validCongressmanController.setCongressman( validCongressman );

        int result = validCongressmanController.getCongresman().
                getIdCongressman();
        
        int expectedResult = validCongressman.getIdCongressman();
        
        Assert.assertEquals( expectedResult, result );
    }
    
    public void testCongressmanSetupInCongressmanControllerShouldNotBeNull() {
        validCongressmanController.setCongressman( validCongressman );
        Congressman result = validCongressmanController.getCongresman();
        
        Assert.assertNotNull( result );
    }
    

    private void instantiateValidEntitiesToTest() {
        validCongressmanController = CongressmanController
                .getInstance( context );
        validCongressmanDao = CongressmanDao.getInstance( context );
        validCongressman = new Congressman();
        
        setValidCongressman();
    }
    
    private void insertValidEntitiesInLocalDatabase() {
        List<Congressman> congressmanList = new ArrayList<Congressman>();
        
        congressmanList.add( validCongressman );
        
        validCongressmanDao.insertAllCongressman( congressmanList );
    }
    
    private void deleteEntitiesLocalDatabase() {
        try {
            validCongressmanDao.deleteAllCongressman();
        } catch( NullCongressmanException nce ) {
            nce.printStackTrace();
        } catch( LocalDatabaseInvalidOperationException ldioe ) {
            ldioe.printStackTrace();
        }
    }
    
    private void setValidCongressman() {
        this.validCongressman.setIdCongressman( 1 );
        this.validCongressman.setIdUpdateCongressman( 1 );
        this.validCongressman.setNameCongressman( "valid name" );
        this.validCongressman.setPartyCongressman( "valid party" );
        this.validCongressman.setRankingCongressman( 1 );
        this.validCongressman.setStatusCogressman( FOLLOWED );
        this.validCongressman.setTotalSpentCongressman( 25000.00 );
        this.validCongressman.setTypeCongressman( "Deputy" );
        this.validCongressman.setUfCongressman( "valid UF" );
    }
}
