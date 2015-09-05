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

@DiscriminatorValue("CompteCourant")

@NamedQueries({
    @NamedQuery(name = "CompteCourant.findAll", query = "SELECT cc FROM CompteCourant cc")})
@XmlRootElement
public class CompteCourant extends Compte implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numeroCompte;
    
    @Column(nullable=false,length=30)
    private double montantDecouvertAutorise;

    public CompteCourant() {
    }
      
    public CompteCourant(double montantDecouvertAutorise,Long numeroCompte, Date dateCreation, double solde) {
        super(numeroCompte,dateCreation,solde);
        this.montantDecouvertAutorise = montantDecouvertAutorise;
    }

    public CompteCourant(double montantDecouvertAutorise,Date dateCreation, double solde) {
        super(dateCreation,solde);
        this.montantDecouvertAutorise = montantDecouvertAutorise;
    }
    
    
    public double getMontantDecouvertAutorise() {
        return montantDecouvertAutorise;
    }

    public void setMontantDecouvertAutorise(double montantDecouvertAutorise) {
        this.montantDecouvertAutorise = montantDecouvertAutorise;
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
        CompteCourant other = (CompteCourant) object;
        if ((this.numeroCompte== null && other.numeroCompte != null) || (this.numeroCompte != null && !this.numeroCompte.equals(other.numeroCompte))) {
            return false;
        }
        return true;
    }
   
}
