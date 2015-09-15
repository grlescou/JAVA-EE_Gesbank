/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.page.jsf;

import javax.inject.Named;

/**
 *
 * @author MyPC
 */
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import ht.GermainLescouflairSuy.gesBank.entite.Compte;//CompteBancaire;
import ht.GermainLescouflairSuy.gesBank.entite.OperationBancaire;

/**
 *
 * @author MyPC
 */

import ht.GermainLescouflairSuy.gesBank.session.SessionBeanClient;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanOperationBancaire;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedProperty;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 *
 * @author MyPC
 */

@ManagedBean
@ViewScoped
public class DetailsComptesBeans implements Serializable {
    @EJB
    SessionBeanOperationBancaire sessionBeanOperationBancaire ;
    @EJB
    SessionBeanClient sessionBeanClient ;
    
  //  @ManagedProperty(value="#{loginMBean}") 
  //  LoginMBean loginMBean ;
    
    private OperationBancaire operationBancaire;
    List<OperationBancaire> listOperation;
    List<OperationBancaire> listOperationFilters;
    private long idCompte;

    public long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(long idCompte) {
        this.idCompte = idCompte;
    }
    
    public DetailsComptesBeans() {
    }

    public List<OperationBancaire> getListOperationFilters() {
        return listOperationFilters;
    }

    public void setListOperationFilters(List<OperationBancaire> listOperationFilters) {
        this.listOperationFilters = listOperationFilters;
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
    
    public List<OperationBancaire> getAllOperationBancaire(long idCompteBancaire) {
        return sessionBeanOperationBancaire.getOperationBancaire(idCompteBancaire);
    } 
    
     public OperationBancaire getOperationBancaire() {
        return operationBancaire;
    } 
    
     public void loadOperationBancaire() {
        listOperation= sessionBeanOperationBancaire.getOperationBancaire(idCompte);
    } 
     
     
     public void loadOperationBancairebyCompte() {
        Compte compte =sessionBeanClient.getCompteByid(idCompte);
        listOperation= sessionBeanOperationBancaire.getOperationBancaire(compte);
    } 

    public SessionBeanClient getSessionBeanClient() {
        return sessionBeanClient;
    }

    public void setSessionBeanClient(SessionBeanClient sessionBeanClient) {
        this.sessionBeanClient = sessionBeanClient;
    }

    public List<OperationBancaire> getListOperation() {
        return listOperation;
    }

    public void setListOperation(List<OperationBancaire> listOperation) {
        this.listOperation = listOperation;
    }
     
     
     
     public List<OperationBancaire> getDetailOperationBancaire() {
        return listOperation;
    } 
    
    public String getActiontStringDetail(long id){
        
        return "details?idcompt="+id+"&amp;faces-redirect=true";
    }
    
     public String getActiontStringTransaction(long id){
        
        return "transfertClient?idcompt="+id;
    }

      public String getActiontStringTransfert(long id){
        
        return "transferetcompteacompte?idcompt="+id;
    }

}
