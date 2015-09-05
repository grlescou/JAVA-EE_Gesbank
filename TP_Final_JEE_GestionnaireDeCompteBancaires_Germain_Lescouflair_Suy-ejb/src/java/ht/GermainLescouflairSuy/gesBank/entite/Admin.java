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
@DiscriminatorValue("Admin")
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT adm FROM Admin adm")})
@XmlRootElement
public class Admin extends Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="nom",nullable=false)
    private String nom;
    @Column(name="prenom",nullable=false)
    private String prenom;

    public Admin() {
    }

    public Admin(Long id, boolean connected, Date created, String email, String password, Date updateAt, String utilisateur, String nom, String prenom) {
        super(connected,created,email,password,updateAt,utilisateur);
        this.id=id;
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
     @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
        
}
