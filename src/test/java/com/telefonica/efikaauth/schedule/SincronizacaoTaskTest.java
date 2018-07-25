/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikaauth.schedule;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author A0077749
 */
public class SincronizacaoTaskTest {
    
    public SincronizacaoTaskTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sincronizaAWS method, of class SincronizacaoTask.
     */
    @Test
    public void testSincronizaAWS() {
        System.out.println("sincronizaAWS");
        SincronizacaoTask instance = new SincronizacaoTask();
        instance.sincronizaAWS();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sincronizaCluster method, of class SincronizacaoTask.
     */
    @Test
    public void testSincronizaCluster() {
        System.out.println("sincronizaCluster");
        SincronizacaoTask instance = new SincronizacaoTask();
        boolean expResult = false;
        boolean result = instance.sincronizaCluster();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
