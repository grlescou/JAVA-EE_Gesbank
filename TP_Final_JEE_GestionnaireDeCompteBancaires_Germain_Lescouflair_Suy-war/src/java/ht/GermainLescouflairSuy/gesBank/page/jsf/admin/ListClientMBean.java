/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.page.jsf.admin;

import ht.GermainLescouflairSuy.gesBank.entite.ClientBanque;
import ht.GermainLescouflairSuy.gesBank.entite.Compte;
import ht.GermainLescouflairSuy.gesBank.page.jsf.LoginMBean;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanAdmin;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanClient;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author MyPC
 */
@ManagedBean(name = "listClientMBean")
@ViewScoped
public class ListClientMBean {

      @EJB
    private SessionBeanAdmin sessionBeanAdmin;
    private ClientBanque client ;
    
     @EJB
    private SessionBeanClient sessionBeanClient;
    private List<ClientBanque> listeClientBanque;
    private Compte compteBancaire;
    private ClientBanque SelectedClientBanque;
    private String btnString ;
    private boolean canModified ;
    private List<ClientBanque> ClientBanqueFilter;
   // @ManagedProperty(value="#{loginMBean}") 
   // LoginMBean loginMBean ;
     
    
    /**
     * Creates a new instance of ListClientMBean
     */
    public ListClientMBean() {
    }

    public ClientBanque getClient() {
        return client;
    }

    public void setClient(ClientBanque client) {
        this.client = client;
    }

    public List<ClientBanque> getListeClientBanque() {
        listeClientBanque = listClientBanque();
        return listeClientBanque;
    }

    public void setListeClientBanque(List<ClientBanque> listeClientBanque) {
        this.listeClientBanque = listeClientBanque;
    }

    public Compte getCompteBancaire() {
        return compteBancaire;
    }

    public void setCompteBancaire(Compte compteBancaire) {
        this.compteBancaire = compteBancaire;
    }

    public ClientBanque getSelectedClientBanque() {
        return SelectedClientBanque;
    }

    public void setSelectedClientBanque(ClientBanque SelectedClientBanque) {
        this.SelectedClientBanque = SelectedClientBanque;
    }

    public boolean isCanModified() {
        return canModified;
    }

    public void setCanModified(boolean canModified) {
        this.canModified = canModified;
    }

    public List<ClientBanque> getClientBanqueFilter() {
        return ClientBanqueFilter;
    }

    public void setClientBanqueFilter(List<ClientBanque> ClientBanqueFilter) {
        this.ClientBanqueFilter = ClientBanqueFilter;
    }
    
    
    
    //================================ajoute list client ================
    
    
    public List<ClientBanque> listClientBanque (){
         return  sessionBeanAdmin.listerClientsBanque();
    }
    
    
    
    
     public String getActiontStringListComptes(long id){
        
        return "ListeComptesClient?idclient="+id+"&amp;faces-redirect=true";
    }
    
     public String getActiontStringTransaction(long id){
        
        return "transfertClient?idcompt="+id;
    }
    
}
