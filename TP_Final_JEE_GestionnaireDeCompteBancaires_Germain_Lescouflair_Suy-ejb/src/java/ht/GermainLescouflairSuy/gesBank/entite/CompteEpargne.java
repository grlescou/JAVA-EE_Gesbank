
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.entite;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lyzzy
 */
@Entity

@DiscriminatorValue("CompteE")

@NamedQueries({
    @NamedQuery(name = "CompteEpargne.findAll", query = "SELECT ce FROM CompteEpargne ce") })
@XmlRootElement
public class CompteEpargne extends Compte implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numeroCompte;
    
    @Column( nullable=false,columnDefinition="Decimal(10,2)")
    private double taux;

    public CompteEpargne() {
        this.taux = 0.0;
    }
    

    public CompteEpargne(double taux,Long numeroCompte, Date dateCreation, double solde) {
        super(numeroCompte,dateCreation,solde);
        this.taux = 0.0;
        this.taux = taux;
    }
    
     public CompteEpargne(double taux,Date dateCreation, double solde) {
        super(dateCreation,solde);
        this.taux = 0.0;
        this.taux = taux;
    }
    
    

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public void ajouterInterets(){
        double newSold = this.getSolde() + ((this.getSolde()*this.getTaux())/100);
        this.setSolde(newSold);
    }
    

}



