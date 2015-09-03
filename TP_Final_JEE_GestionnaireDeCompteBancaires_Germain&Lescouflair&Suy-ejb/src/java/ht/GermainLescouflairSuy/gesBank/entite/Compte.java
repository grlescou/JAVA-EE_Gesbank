/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.entite;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author lyzzy
 */
@Entity
public class Compte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numeroCompte;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreation;
    private double solde;
    @ManyToOne
    private Client client;
    
    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER,mappedBy="Compte")
    private List<OperationBancaire> Operations;
    
    public Compte() {
    }

    public Compte(Long numeroCompte, Date dateCreation, double solde) {
        this.numeroCompte = numeroCompte;
        this.dateCreation = dateCreation;
        this.solde = solde;
    }
    
    

    public Long getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(Long numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OperationBancaire> getOperations() {
        return Operations;
    }

    public void setOperations(List<OperationBancaire> Operations) {
        this.Operations = Operations;
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
        if (!(object instanceof Compte)) {
            return false;
        }
        Compte other = (Compte) object;
        if ((this.numeroCompte == null && other.numeroCompte != null) || (this.numeroCompte != null && !this.numeroCompte.equals(other.numeroCompte))) {
            return false;
        }
        return true;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
   
   public void crediter(double montant){
    
        solde+=montant;
    
    }
   
    public void debiter(double montant){
    
        solde-=montant;
    }

    @Override
    public String toString() {
        return "ht.GermainLescouflairSuy.gesBank.entite.Compte[ id=" + numeroCompte + " ]";
    }
    
}
