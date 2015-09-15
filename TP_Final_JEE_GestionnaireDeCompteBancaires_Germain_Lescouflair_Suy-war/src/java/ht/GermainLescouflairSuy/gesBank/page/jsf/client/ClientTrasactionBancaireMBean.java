/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.page.jsf.client;


import ht.GermainLescouflairSuy.gesBank.entite.ClientBanque;
import ht.GermainLescouflairSuy.gesBank.entite.Compte;
import ht.GermainLescouflairSuy.gesBank.entite.OperationBancaire;
import ht.GermainLescouflairSuy.gesBank.entite.Utilisateur;
import ht.GermainLescouflairSuy.gesBank.page.jsf.LoginMBean;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanAdmin;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanClient;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.util.Locale;

/**
 *
 * @author MyPC
 */

@ManagedBean(name = "clientTrasactionBancaireMBean")
@ViewScoped
public class ClientTrasactionBancaireMBean implements Serializable{
    @EJB
    private SessionBeanAdmin sessionBeanAdmin;
    @EJB
    private SessionBeanClient sessionBeanClient;
    
    private ClientBanque client ;
    private List<Compte> listeComptes;
    private Compte compteBancaire;
    private Compte SelectedcompteBancaire;
    private String btnString ;
    private boolean canModified ;
    private List<Compte> compteBancaireFilter;
    @ManagedProperty(value="#{loginMBean}") 
    LoginMBean loginMBean ;
     
    /**
     * Creates a new instance of ClientTrasactionBancaireMBean
     */
    public ClientTrasactionBancaireMBean() {
        
    }
    
    public void loadClientFromSession(){
        long id = loginMBean.getClient().getId();
        this.client = sessionBeanAdmin.listerClientByid(id);
        listeComptes = client.getComptes();
        System.out.println("==================================size de mes comptes :"+listeComptes.size());
    }
    
    public List<Compte> ListeComptesClient(){
        
            System.out.println("==================================size de mes comptes :"+client.getComptes().size());
       
        return client.getComptes();
    }
    
    public List<OperationBancaire> ListOperationBancaires(Compte compte){
        return compte.getOperations();
    }

    public ClientBanque getClient() {
        return client;
    }

    public void setClient(ClientBanque client) {
        this.client = client;
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
      
      
      
      
}
