/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.webservice.serviceclasse.Compte;

/**
 *
 * @author MyPC
 */
public class OurvrirCompteService {
    private long idClient ;
    private double solde;
    private String typeCompte;

    public OurvrirCompteService(long idClient, double solde, String typeCompte) {
        this.idClient = idClient;
        this.solde = solde;
        this.typeCompte = typeCompte;
    }

   

    public OurvrirCompteService() {
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }
    
    
    
}
