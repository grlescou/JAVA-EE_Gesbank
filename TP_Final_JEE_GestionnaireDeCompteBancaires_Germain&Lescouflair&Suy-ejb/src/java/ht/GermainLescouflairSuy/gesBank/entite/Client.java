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
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author lyzzy
 */
@Entity

@DiscriminatorValue("Client")

@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT cl FROM Client cl")})
public class Client extends Users implements Serializable  {
    private static final long serialVersionUID = 1L;
    
    private String nifCin;
    private String nom;
    private String prenom;
    
   
    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER, mappedBy="Client")
    private List<Compte> comptes;
    
    public Client(){}
    
    public Client(String nifCin,String nom,String prenom,Long id, boolean connected, Date created, String email, String password, Date updateAt, String utilisateur){
        super(id,connected,created,email,password,updateAt,utilisateur);
        this.nifCin=nifCin;
        this.nom=nom;
        this.prenom=prenom;
    }
    
   public Client(String nifCin,String nom,String prenom,boolean connected, Date created, String email, String password, Date updateAt, String utilisateur){
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

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

   
   
}
