/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lyzzy
 */
@Entity
@DiscriminatorValue("ClientB")
@NamedQueries({
    @NamedQuery(name = "ClientBanque.findAll", query = "SELECT cl FROM ClientBanque cl")})
@XmlRootElement
public class ClientBanque extends Utilisateur implements Serializable  {
    private static final long serialVersionUID = 1L;

    @Column(nullable=true)
    private String nifCin="N/A";
     @Column(nullable=false,length=20)
    private String nom;
    @Column(nullable=false,length=50)
    private String prenom;
    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY, mappedBy="ClientBanque")
    private List<Compte> comptes=new ArrayList<>();
    
    public ClientBanque(){
        
}
    
    public ClientBanque(String nifCin,String nom,String prenom,Long id, boolean connected, Date created, String email, String password, Date updateAt, String utilisateur){
        super(id,connected,created,email,password,updateAt,utilisateur);
        
        this.nifCin=nifCin;
        this.nom=nom;
        this.prenom=prenom;
        
        
    }
    
   public ClientBanque(String nifCin,String nom,String prenom,boolean connected, Date created, String email, String password, Date updateAt, String utilisateur){
       super(connected,created,email,password,updateAt,utilisateur);
       

        this.nifCin=nifCin;
        this.nom=nom;
        this.prenom=prenom;
    
   }

  


    public String getNifCin() {
        return nifCin;
    }

    public void setNifCin(String nifCin) {
        this.nifCin = nifCin;
    }
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @XmlTransient
    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    @Override
    public String toString() {
        //return   nom + " " +prenom;
        return String.format("%d", this.getId());
    }

    

   

   
}


