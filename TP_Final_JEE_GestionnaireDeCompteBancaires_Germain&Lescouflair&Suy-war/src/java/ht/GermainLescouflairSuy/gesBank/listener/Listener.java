/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.listener;

import ht.GermainLescouflairSuy.gesBank.session.SessionBeanAdmin;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author MBDS
 */
public class Listener implements ServletContextListener {
   
    private SessionBeanAdmin sessionBeanAdmin = lookupsessionBeanAdmin();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sessionBeanAdmin.ajouterCompteTest();
        sessionBeanAdmin.ajouterClientTest();
        System.out.println("the application is starting");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
                System.out.println("the application is stopping"); 

    }
    private SessionBeanAdmin lookupsessionBeanAdmin() {
        try {
            Context c = new InitialContext();
            return (SessionBeanAdmin) c.lookup("java:global/TpGesCompteBancaire/TpGesCompteBancaire-ejb/GesCompteBanqSession!ht.mbds.banque.session.GesCompteBanqSession");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
   
    
}
