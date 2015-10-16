/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.webservice.serviceclasse.Compte;

import java.util.Date;

/**
 *
 * @author MyPC
 */
public class CompteServices {
  
private long numeroCompte;
    private Date dateCreation;
    private double solde;



    public CompteServices() {
    }

    public CompteServices(Long numeroCompte, Date dateCreation, double solde) {
        this.numeroCompte = numeroCompte;
        this.dateCreation = dateCreation;
        this.solde = solde;


    }

    //getter and setter
    public long getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(long numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    
}
    
    

