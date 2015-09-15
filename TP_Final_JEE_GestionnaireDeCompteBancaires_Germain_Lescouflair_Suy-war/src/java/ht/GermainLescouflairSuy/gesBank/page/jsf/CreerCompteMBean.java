/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.page.jsf;

import ht.GermainLescouflairSuy.gesBank.entite.ClientBanque;
import ht.GermainLescouflairSuy.gesBank.entite.CompteCourant;
import ht.GermainLescouflairSuy.gesBank.entite.CompteEpargne;
import ht.GermainLescouflairSuy.gesBank.entite.enumeration.TypeCompteBancaire;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanAdmin;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author MyPC
 */
@ManagedBean(name = "creerCompteMBean")
@ViewScoped
public class CreerCompteMBean implements Serializable  {
    @EJB
    private SessionBeanAdmin sessionBeanAdmin;

    /**
     * Creates a new instance of CreerCompteMBean
     */
    
    private String TypeCompte ;
    private double Taux ;
    private double montantDecouvertAutorise;
     private ClientBanque newClientBanque;
     private double solde ;
     
    private ClientBanque current;
    private List<SelectItem> listClients;
    private int selectedItemIndex;
   // private DataModel items = null;
    private String numeroCompte;
    
    private SelectItem [] selectedItem;
    private String prenomNom;   
    public CreerCompteMBean() {
    }
    
    public ClientBanque getSelected() {
        if (current == null) {
            current = new ClientBanque();
            selectedItemIndex = -1;
        }
        return current;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }
    
    public ClientBanque getCurrent() {
        return current;
    }

    public void setCurrent(ClientBanque current) {
        this.current = current;
    }

    public List<SelectItem> getListClients() {
        return listClients;
    }

    public void setListClients(List<SelectItem> listClients) {
        this.listClients = listClients;
    }

    public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        this.selectedItemIndex = selectedItemIndex;
    }

  

    
    
     public SelectItem[] getItemsAvailableSelectOne() {
        return getSelectItems(sessionBeanAdmin.listerClientsBanque(), true);
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
            String n = ((ClientBanque)x).getPrenom() +" "+ ((ClientBanque)x).getNom() ;
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

    
//====================creer compte===============================

    public String getTypeCompte() {
        return TypeCompte;
    }

    public void setTypeCompte(String TypeCompte) {
        this.TypeCompte = TypeCompte;
    }

    public double getTaux() {
        return Taux;
    }

    public void setTaux(double Taux) {
        this.Taux = Taux;
    }

    public double getMontantDecouvertAutorise() {
        return montantDecouvertAutorise;
    }

    public void setMontantDecouvertAutorise(double montantDecouvertAutorise) {
        this.montantDecouvertAutorise = montantDecouvertAutorise;
    }

    public ClientBanque getNewClientBanque() {
        return newClientBanque;
    }

    public void setNewClientBanque(ClientBanque newClientBanque) {
        this.newClientBanque = newClientBanque;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
    
 
    public void creerCompte(){
        System.out.println("======================="+numeroCompte+"=========================");
         newClientBanque = sessionBeanAdmin.listerClientByid(Long.parseLong(numeroCompte));
         System.out.println("le client trouver est :"+newClientBanque.getNom()+" "+newClientBanque.getPrenom());
         if(newClientBanque == null){
             
         }
         else{
              System.out.println("le type de compte choisi:"+this.TypeCompte);
             if(this.TypeCompte.equals(TypeCompteBancaire.COURANTDB.getType())){
                 CompteCourant cc= new CompteCourant ();
                 cc.setClientBanque(newClientBanque);
                 cc.setSolde(solde);
                 cc.setMontantDecouvertAutorise(montantDecouvertAutorise);
                 Date d = new Date();
                 cc.setDateCreation(d);
                 
                 sessionBeanAdmin.ajouterCompte(cc);
             }
             
             
             if(this.TypeCompte.equals(TypeCompteBancaire.EPARGNEDB.getType())){
                 CompteEpargne ce= new CompteEpargne ();
                 ce.setClientBanque(newClientBanque);
                 ce.setSolde(solde);
                 ce.setTaux(Taux);
                 Date d = new Date();
                 ce.setDateCreation(d);
                 sessionBeanAdmin.ajouterCompte(ce);
             }
             
             
             
         }
    }
    
    public String getLoadNom(String id){
       String noms = null;
        newClientBanque = sessionBeanAdmin.listerClientByid(Long.getLong(id)); 
        noms =newClientBanque.getPrenom()+" "+ newClientBanque.getNom();
        return noms;
    }

    public String getPrenomNom() {
        
        return prenomNom;
    }

    public void setPrenomNom(String prenomNom) {
        this.prenomNom = prenomNom;
    }
    
    
    
}
