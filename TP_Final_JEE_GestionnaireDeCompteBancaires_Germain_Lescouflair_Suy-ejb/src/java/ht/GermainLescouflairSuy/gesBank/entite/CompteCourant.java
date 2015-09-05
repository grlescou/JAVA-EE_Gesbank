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

@DiscriminatorValue("CompteCourant")

@NamedQueries({
    @NamedQuery(name = "CompteCourant.findAll", query = "SELECT cc FROM CompteCourant cc")})
public class CompteCourant extends Compte implements Serializable {
    private static final long serialVersionUID = 1L;
   
   
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
   

   
}
