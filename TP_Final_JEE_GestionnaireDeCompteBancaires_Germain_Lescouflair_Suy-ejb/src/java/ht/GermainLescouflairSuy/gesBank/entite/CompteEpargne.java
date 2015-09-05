
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

@DiscriminatorValue("CompteEpargne")

@NamedQueries({
    @NamedQuery(name = "CompteEpargne.findAll", query = "SELECT ce FROM CompteEpargne ce") })
@XmlRootElement
public class CompteEpargne extends Compte implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numeroCompte;
    
    @Column(nullable=false)
    private double taux;

    public CompteEpargne() {
    }
    

    public CompteEpargne(double taux,Long numeroCompte, Date dateCreation, double solde) {
        super(numeroCompte,dateCreation,solde);
        this.taux = taux;
    }
    
     public CompteEpargne(double taux,Date dateCreation, double solde) {
        super(dateCreation,solde);
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
    
     @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroCompte != null ? numeroCompte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        CompteEpargne other = (CompteEpargne) object;
        if ((this.numeroCompte == null && other.numeroCompte != null) || (this.numeroCompte != null && !this.numeroCompte.equals(other.numeroCompte))) {
            return false;
        }
        return true;
    }
}

