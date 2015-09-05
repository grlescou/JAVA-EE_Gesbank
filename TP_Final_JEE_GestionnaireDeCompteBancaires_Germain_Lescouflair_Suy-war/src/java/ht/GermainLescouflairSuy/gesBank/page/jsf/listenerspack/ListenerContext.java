/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.page.jsf.listenerspack;

import ht.GermainLescouflairSuy.gesBank.session.SessionBeanAdmin;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author MyPC
 */
public class ListenerContext implements ServletContextListener {
    SessionBeanAdmin sessionBeanAdmin = lookupSessionBeanAdminBean();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
       System.out.println("Application started....................");
       sessionBeanAdmin.ajouterClientTest();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Application stop....................");
    }

    private SessionBeanAdmin lookupSessionBeanAdminBean() {
        try {
            Context c = new InitialContext();
            return (SessionBeanAdmin) c.lookup("java:global/TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy/TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-ejb/SessionBeanAdmin!ht.GermainLescouflairSuy.gesBank.session.SessionBeanAdmin");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
