/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.page.jsf.admin;

import ht.GermainLescouflairSuy.gesBank.entite.ClientBanque;
import ht.GermainLescouflairSuy.gesBank.entite.Compte;
import ht.GermainLescouflairSuy.gesBank.entite.OperationBancaire;
import ht.GermainLescouflairSuy.gesBank.page.jsf.LoginMBean;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanAdmin;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanClient;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author MyPC
 */
@ManagedBean(name = "adminMBean")
@ViewScoped
public class AdminMBean {
    @EJB
    private SessionBeanAdmin sessionBeanAdmin;
    private ClientBanque client ;
    private long idClient ;
    
     @EJB
    private SessionBeanClient sessionBeanClient;
    private List<Compte> listeComptes;
    private Compte compteBancaire;
    private Compte SelectedcompteBancaire;
    private String btnString ;
    private boolean canModified ;
    private List<Compte> compteBancaireFilter;
    @ManagedProperty(value="#{loginMBean}") 
    LoginMBean loginMBean ;
     
    private List<Compte> listeComptesClient;
    
    /**
     * Creates a new instance of AdminMBean
     */
    public AdminMBean() {
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
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
    
    public String list() {  
    System.out.println("***LIST***");  
    return "ListeComptes";  
  }  
    
    
    
    //===================ajouter ===================================
    
     public void loadClientFromSession(){
       // this.client = loginMBean.getClient();
        listeComptes =  sessionBeanAdmin.listerComptes();
        System.out.println("==================================size de mes comptes :"+listeComptes.size());
    }
    
    public List<Compte> listeComptesClient(){
        
            System.out.println("==================================size de mes comptes :"+client.getComptes().size());
       
        return client.getComptes();
    }
    
    
    
    
    public List<OperationBancaire> ListOperationBancaires(Compte compte){
        return compte.getOperations();
    }

 
    public List<Compte> getListeComptes() {
       // this.client = loginMBean.getClient();
        //listeComptes = client.getComptes();
        loadClientFromSession();
        return listeComptes;
    }

    public void setListeComptes(List<Compte> listeComptes) {
        this.listeComptes = listeComptes;
    }

    public Compte getSelectedcompteBancaire() {
        return SelectedcompteBancaire;
    }

    public void setSelectedcompteBancaire(Compte SelectedcompteBancaire) {
        this.SelectedcompteBancaire = SelectedcompteBancaire;
    }

    public boolean isCanModified() {
        return canModified;
    }

    public void setCanModified(boolean canModified) {
        this.canModified = canModified;
    }

    public List<Compte> getCompteBancaireFilter() {
        return compteBancaireFilter;
    }

    public void setCompteBancaireFilter(List<Compte> compteBancaireFilter) {
        this.compteBancaireFilter = compteBancaireFilter;
    }

    public LoginMBean getLoginMBean() {
        return loginMBean;
    }

    public void setLoginMBean(LoginMBean loginMBean) {
        this.loginMBean = loginMBean;
    }
    
      public boolean filterByMontant(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }
      
      
     public String getActiontString(){
        
        return "formulaire1?idcompt=0&amp;btn=Ajouter&amp;canModif=false&amp;faces-redirect=true";
    }
    
    public String getActiontStringModif(long id){
        
        return "formulaireModif?idcompt="+id+"&amp;btn=Modifier&amp;canModif=true&amp;faces-redirect=true";
    }
      
   //============ ajout pour detail  liste des comptes  a partir de list des clients de la banque  
    
    public void loadListeCompte() {
        ClientBanque c =(ClientBanque) sessionBeanAdmin.listerClientByid(idClient);
        
        listeComptesClient = c.getComptes();
    }

    public List<Compte> getListeComptesClient() {
        return listeComptesClient;
    }

    public void setListeComptesClient(List<Compte> listeComptesClient) {
        this.listeComptesClient = listeComptesClient;
    }
    
    
    
}
