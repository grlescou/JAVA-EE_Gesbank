/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.page.jsf.client;

import ht.GermainLescouflairSuy.gesBank.entite.ClientBanque;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanAdmin;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanClient;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author lyzzy
 */
@ManagedBean(name = "clientMBean")
@ViewScoped
public class ClientMBean implements Serializable {
    public List<ClientBanque> clients;
    
    @EJB
    private SessionBeanClient sessionBeanClient;

    /**
     * Creates a new instance of ClientMBean
     */
    
    public ClientMBean() {
    }
    
    /** 
     * Renvoie la liste des clients pour affichage dans une DataTable
     *
     * @return  */
    
    
//     public Collection getClient() {  
//         return sessionBeanAdmin.listerClients();
//     }
//     public String showDetails(int clientId) {  
//        return "CustomerDetails?id=" + clientId;    }  
}
