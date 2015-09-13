
package ht.GermainLescouflairSuy.gesBank.entite;


import ht.GermainLescouflairSuy.gesBank.entite.enumeration.TypeOperation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.metamodel.SingularAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lyzzy
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypeCompte",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("CompteB")
@NamedQueries({
    @NamedQuery(name = "Compte.findAll", query = "SELECT c FROM Compte c")})
@XmlRootElement
public abstract class Compte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numeroCompte;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreation;
    @Column(nullable=false,length=30)
    private double solde;
    @ManyToOne
    private ClientBanque clientBanque;

    @Column(name="TypeCompte")
    private String typeCompte;
   
    
    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER,mappedBy="Compte")
    private List<OperationBancaire> Operations = new ArrayList<>();
    
    public Compte() {
    }

    public Compte(Long numeroCompte, Date dateCreation, double solde) {
        this.numeroCompte = numeroCompte;
        this.dateCreation = dateCreation;
        this.solde = solde;
        Date dateOperation = new Date();
        this.Operations.add(new OperationBancaire (dateOperation,TypeOperation.CREATION.getType(),solde));
    }
    
    public Compte(Date dateCreation, double solde) {
        this.dateCreation = dateCreation;
        this.solde = solde;
         Date dateOperation = new Date();
        this.Operations.add(new OperationBancaire (dateOperation,TypeOperation.CREATION.getType(),solde));
    }


    @Id
    public String getTypeCompte() {
        typeCompte = getDiscriminatorValue();
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }
    

    public Long getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(Long numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public ClientBanque getClientBanque() {
        return clientBanque;
    }

    public void setClientBanque(ClientBanque clientBanque) {
        this.clientBanque = clientBanque;
    }

    public List<OperationBancaire> getOperations() {
        return Operations;
    }

    public void setOperations(List<OperationBancaire> Operations) {
        this.Operations = Operations;
    }

    @Transient
    public String getDiscriminatorValue(){
    DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );

    return val == null ? null : val.value();
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
        return "Compte[ id=" + numeroCompte + " ]";
    }
    
}



