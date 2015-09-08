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

//creation de la classe administrateur

@Entity
@DiscriminatorValue("Administ")
@NamedQueries({
    @NamedQuery(name = "Administrateur.findAll", query = "SELECT adm FROM Administrateur adm")})
@XmlRootElement
public class Administrateur extends Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
  //  @Id
    
   // private Long idUser; 
    @Column(nullable=false)
    private String nom;
    @Column(nullable=false)
    private String prenom;

    //constructeur par defaut
    public Administrateur() {
    }
    

    public Administrateur(Long id, boolean connected, Date created, String email, String password, Date updateAt, String utilisateur, String nom, String prenom) {
        super(id,connected,created,email,password,updateAt,utilisateur);
        
        this.nom = nom;
        this.prenom = prenom;
        
    }
    
     public Administrateur(boolean connected, Date created, String email, String password, Date updateAt, String utilisateur, String nom, String prenom) {
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
