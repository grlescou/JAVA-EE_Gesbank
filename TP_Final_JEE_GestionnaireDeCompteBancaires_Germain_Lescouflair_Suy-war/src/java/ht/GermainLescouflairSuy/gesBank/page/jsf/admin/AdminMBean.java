/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.page.jsf.admin;

import ht.GermainLescouflairSuy.gesBank.entite.ClientBanque;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanAdmin;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author MyPC
 */
@Named(value = "adminMBean")
@ViewScoped
public class AdminMBean {
    @EJB
    private SessionBeanAdmin sessionBeanAdmin;
    private ClientBanque client ;
    /**
     * Creates a new instance of AdminMBean
     */
    public AdminMBean() {
    }

    public ClientBanque getClient() {
        return client;
    }

    public void setClient(ClientBanque client) {
        this.client = client;
    }
    
    
    public void CreerClient(){
        sessionBeanAdmin.ajouterClient(client);
    }
    
}
