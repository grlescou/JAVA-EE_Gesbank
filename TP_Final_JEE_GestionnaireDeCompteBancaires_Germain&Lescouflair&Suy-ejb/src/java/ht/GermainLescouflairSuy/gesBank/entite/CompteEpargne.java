
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.entite;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author lyzzy
 */
@Entity

@DiscriminatorValue("CompteEpargne")

@NamedQueries({
    @NamedQuery(name = "CompteEpargne.findAll", query = "SELECT ce FROM CompteEpargne ce") })
public class CompteEpargne extends Compte implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    private Long taux;

    public CompteEpargne() {
    }
    

    public CompteEpargne(Long taux,Long numeroCompte, Date dateCreation, double solde) {
        super(numeroCompte,dateCreation,solde);
        this.taux = taux;
    }
    
     public CompteEpargne(Long taux,Date dateCreation, double solde) {
        super(dateCreation,solde);
        this.taux = taux;
    }
    
    

    public Long getTaux() {
        return taux;
    }

    public void setTaux(Long taux) {
        this.taux = taux;
    }

    public void ajouterInterets(){
        double newSold = this.getSolde() + ((this.getSolde()*this.getTaux())/100);
        this.setSolde(newSold);
    }
}

