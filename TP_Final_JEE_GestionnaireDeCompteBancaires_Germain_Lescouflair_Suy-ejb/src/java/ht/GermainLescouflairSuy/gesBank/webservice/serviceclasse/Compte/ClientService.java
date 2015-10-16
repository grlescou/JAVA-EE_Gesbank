/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.webservice.serviceclasse.Compte;

import java.util.Date;

/**
 *
 * @author MyPC
 */
public class ClientService {
        //private long id;
        private boolean connected;
        private Date created;
        private String email;
        private String password;
        private Date updateAt;
        private String utilisateur;
        private String nifCin;
        private String nom;
        private String prenom;

    public ClientService( boolean connected, Date created, String email, String password, Date updateAt, String utilisateur, String nifCin, String nom, String prenom) {
        //this.id = id;
        this.connected = connected;
        this.created = created;
        this.email = email;
        this.password = password;
        this.updateAt = updateAt;
        this.utilisateur = utilisateur;
        this.nifCin = nifCin;
        this.nom = nom;
        this.prenom = prenom;
    }

    public ClientService() {
    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
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
        
        
        
        
}
