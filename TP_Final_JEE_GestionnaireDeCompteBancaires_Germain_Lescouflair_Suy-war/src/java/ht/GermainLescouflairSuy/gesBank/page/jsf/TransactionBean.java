/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.page.jsf;

import ht.GermainLescouflairSuy.gesBank.entite.Compte;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanClient;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;


/**
 *
 * @author MyPC
 */
@ManagedBean(name = "transactionBean")
@ViewScoped
public class TransactionBean {

  @EJB
  private SessionBeanClient gestionnaireDeCompteBancaire;
  private long idCompte;
  private Compte compte;
  private String typeTransac;
  private int montant;
  private String clientFullName="";

    /**
     * Creates a new instance of TransactionBean
     */
    public TransactionBean() {
    }
    
    
    
  
  

  public void loadClient() {
    if (compte == null) {
      compte = gestionnaireDeCompteBancaire.getCompteByid(idCompte);
      clientFullName ="Jean Bar";
      //clientFullName = compte.getClientBanque().getPrenom() +" "+ compte.getClientBanque().getNom();
    }
  }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

  public Compte getCompte() {
    return compte;
  }

  public long getIdCompte() {
    return idCompte;
  }

  public void setIdCompte(long idCompte) {
    this.idCompte = idCompte;
  }

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String ClientFullName) {
        this.clientFullName = ClientFullName;
    }

  
  public int getMontant() {
    return montant;
  }

  public void setMontant(int montant) {
    this.montant = montant;
  }

    public String getTypeTransac() {
        return typeTransac;
    }

    public void setTypeTransac(String typeTransac) {
        this.typeTransac = typeTransac;
    }



  public String effectuerTransaction() {
    
    
    if (typeTransac.equals("depot")) {
      compte.crediter(montant);
    } else {
      compte.debiter(montant);
    }
    gestionnaireDeCompteBancaire.modifierCompte(compte);
    
    return null;
  }
  
  
    
}
