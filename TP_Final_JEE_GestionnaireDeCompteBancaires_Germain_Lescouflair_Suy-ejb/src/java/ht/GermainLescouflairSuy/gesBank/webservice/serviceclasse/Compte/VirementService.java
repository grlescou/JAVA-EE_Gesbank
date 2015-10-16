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
public class VirementService {
    private long idclient ;
    private long idclientDestination;
    private double montant ;

    public VirementService() {
    }

    public VirementService(long idclient, long idclientDestination, double montant) {
        this.idclient = idclient;
        this.idclientDestination = idclientDestination;
        this.montant = montant;
    }

    public long getIdclient() {
        return idclient;
    }

    public void setIdclient(long idclient) {
        this.idclient = idclient;
    }

    public long getIdclientDestination() {
        return idclientDestination;
    }

    public void setIdclientDestination(long idclientDestination) {
        this.idclientDestination = idclientDestination;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
    
    
    
}
