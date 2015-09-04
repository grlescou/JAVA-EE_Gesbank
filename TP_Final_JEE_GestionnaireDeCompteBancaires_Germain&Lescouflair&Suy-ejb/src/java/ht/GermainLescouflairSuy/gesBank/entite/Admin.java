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

@DiscriminatorValue("Admin")

@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT adm FROM Admin adm")})
public class Admin extends Users implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    private String nom;
    private String prenom;

    public Admin() {
    }

    public Admin(Long id, boolean connected, Date created, String email, String password, Date updateAt, String utilisateur, String nom, String prenom) {
        super(id,connected,created,email,password,updateAt,utilisateur);
        this.nom = nom;
        this.prenom = prenom;
        
    }
    
     public Admin(boolean connected, Date created, String email, String password, Date updateAt, String utilisateur, String nom, String prenom) {
        super(connected,created,email,password,updateAt,utilisateur);
        this.nom = nom;
        this.prenom = prenom;
        
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
        
}
