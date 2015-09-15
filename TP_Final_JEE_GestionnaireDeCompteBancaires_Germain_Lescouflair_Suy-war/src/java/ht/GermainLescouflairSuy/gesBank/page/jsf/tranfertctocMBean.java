/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.page.jsf;

import ht.GermainLescouflairSuy.gesBank.entite.ClientBanque;
import ht.GermainLescouflairSuy.gesBank.entite.Compte;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanAdmin;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author MyPC
 */
@ManagedBean(name = "tranfertctocMBean")
@ViewScoped
public class tranfertctocMBean implements Serializable {
    @EJB
    SessionBeanAdmin sessionBeanAdmin ;
      
    /**
     * Creates a new instance of tranfertctocMBean
     */
    public tranfertctocMBean() {
    }
    
    
    private long srcId;
    private long dstId;
    private double montantTr;
    
    //============ loading account number list ===============
      private int selectedItemIndex;
     // private DataModel items = null;
     private String numeroCompte;
     private long idCompte;
    
    private SelectItem [] selectedItem;
    

    public long getDstId(){
        return dstId;
    }
    
    public void setDstId(long dstId){
        this.dstId=dstId;
    }
    
    public double getMontantTr(){
        return montantTr;
    }
     
    public void setMontantTr(double montantTr){
        this.montantTr=montantTr;
    }

    public long getSrcId() {
        return srcId;
    }

    public void setSrcId(long srcId) {
        this.srcId = srcId;
    }
    
    
     public void transfer(){
         boolean ok=true;
         Compte compteSrc= sessionBeanAdmin.listerCompteByid(srcId);
         if(compteSrc==null){
             String mess="Compte source inexistant";
             FacesMessage facesmss= new FacesMessage(FacesMessage.SEVERITY_ERROR,mess,mess);
             FacesContext.getCurrentInstance().addMessage("transfert:source", facesmss);
             ok=false;
         }
         Compte compteDst= sessionBeanAdmin.listerCompteByid(dstId);
         if(compteDst == null){
              String mess="Compte destination inexistant";
             FacesMessage facesmss= new FacesMessage(FacesMessage.SEVERITY_ERROR,mess,mess);
             FacesContext.getCurrentInstance().addMessage("transfert:destination", facesmss);
             ok=false;
         }
         if (compteSrc != null) {
      double soldeCompteSource = compteSrc.getSolde();
        if (soldeCompteSource < montantTr) {
        String mess = "Pas assez d'argent sur le compte de "
                + compteSrc.getNumeroCompte();
        FacesMessage facesmss =new FacesMessage(FacesMessage.SEVERITY_ERROR, mess, mess);
        FacesContext.getCurrentInstance().addMessage("transfert:montant", facesmss);
        ok = false;
      }
      }
      if (ok) {
      sessionBeanAdmin.transferer(montantTr,compteSrc, compteDst);
    }
   // return null;
     }

     
     
     //============== loading account number ================
     
      public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        this.selectedItemIndex = selectedItemIndex;
    }

  

    
    
     public SelectItem[] getItemsAvailableSelectOne() {
        return getSelectItems(sessionBeanAdmin.listerComptes(), true);
    }
     
     
     public  SelectItem[] getSelectItems(List<?> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "---------------------------------");
            i++;
        }
        for (Object x : entities) {
            String n = String.format("%d",((Compte)x).getNumeroCompte());
            items[i++] = new SelectItem( x.toString(), n);
          // SelectItem  it=  new SelectItem(x, x.toString());
           
        }
        return items;
    }
     
     
    @PostConstruct
    public void init() {
        selectedItem  =getItemsAvailableSelectOne();
    }

    public SelectItem[] getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(SelectItem[] selectedItem) {
        this.selectedItem = selectedItem;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(long idCompte) {
        this.idCompte = idCompte;
    }

    
   
     
    
}
