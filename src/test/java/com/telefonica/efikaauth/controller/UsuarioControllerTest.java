/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikaauth.controller;

import com.telefonica.efikaauth.model.Enuns;
import com.telefonica.efikaauth.model.UsuarioModel;
import java.util.List;
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
public class UsuarioControllerTest {
    
    public UsuarioControllerTest() {
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
     * Test of create method, of class UsuarioController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        UsuarioModel usuario = null;
        UsuarioController instance = new UsuarioController();
        UsuarioModel expResult = null;
        UsuarioModel result = instance.create(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class UsuarioController.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        UsuarioModel usuario = null;
        UsuarioController instance = new UsuarioController();
        UsuarioModel expResult = null;
        UsuarioModel result = instance.update(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class UsuarioController.
     */
    @Test
    public void testGet_int() throws Exception {
        System.out.println("get");
        int uid = 0;
        UsuarioController instance = new UsuarioController();
        UsuarioModel expResult = null;
        UsuarioModel result = instance.get(uid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class UsuarioController.
     */
    @Test
    public void testGet_String() throws Exception {
        System.out.println("get");
        String matricula = "";
        UsuarioController instance = new UsuarioController();
        UsuarioModel expResult = null;
        UsuarioModel result = instance.get(matricula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class UsuarioController.
     */
    @Test
    public void testList() {
        System.out.println("list");
        int page = 0;
        int count = 0;
        int size = 0;
        UsuarioController instance = new UsuarioController();
        List<UsuarioModel> expResult = null;
        List<UsuarioModel> result = instance.list(page, count, size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSetores method, of class UsuarioController.
     */
    @Test
    public void testGetSetores() {
        System.out.println("getSetores");
        UsuarioController instance = new UsuarioController();
        List<Enuns.Strin> expResult = null;
        List<Enuns.Strin> result = instance.getSetores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSetorUsuario method, of class UsuarioController.
     */
    @Test
    public void testGetSetorUsuario() throws Exception {
        System.out.println("getSetorUsuario");
        String usuario = "03384535";
        UsuarioController instance = new UsuarioController();
        String expResult = "";
        String result = instance.getSetorUsuario(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solicitarAcesso method, of class UsuarioController.
     */
    @Test
    public void testSolicitarAcesso() {
        System.out.println("solicitarAcesso");
        UsuarioModel usuario = null;
        UsuarioController instance = new UsuarioController();
        boolean expResult = false;
        boolean result = instance.solicitarAcesso(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
