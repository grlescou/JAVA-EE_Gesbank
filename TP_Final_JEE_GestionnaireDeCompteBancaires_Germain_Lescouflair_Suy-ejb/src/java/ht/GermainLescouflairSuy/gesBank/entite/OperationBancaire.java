/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.entite;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.metamodel.SingularAttribute;
import javax.xml.bind.annotation.XmlRootElement;




/**
 *
 * @author lyzzy
 */
@Entity
@XmlRootElement
public class OperationBancaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOperation;
     @Column(nullable=false,length=100)
    private String description;
      @Column(nullable=false)
    private double montant;
    
    @ManyToOne
    @JoinColumn(name="Compte_ID")
    private Compte compte;

    public OperationBancaire(){}
    
    public OperationBancaire(Long id, Date dateOperation, String description, double montant) {
        this.id = id;
        dateOperation = new Date();
        this.description = description;
        this.montant = montant;
    }
    
    /**
     *
     * @param description
     * @param montant
     */

    /**
     *@param  dateOperation
     * @param description
     * @param montant
     */
    public OperationBancaire(String description, Date dateOperation, double montant){
        this.description = description;
        dateOperation = new Date();
        this.montant = montant;

    }

    public OperationBancaire(Date dateOperation, String description, double montant) {
        this.dateOperation = dateOperation;
        this.description = description;
        this.montant = montant;
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperationBancaire)) {
            return false;
        }
        OperationBancaire other = (OperationBancaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ht.GermainLescouflairSuy.gesBank.entite.OperationBancaire[ id=" + id + " ]";
    }
    
}


