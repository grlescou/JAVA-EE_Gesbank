/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.entite;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author MyPC
 */
@Entity

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ROLE",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Users")

@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT usr FROM Users usr")})
public abstract class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean connected;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created;
    private String email;
    private String password;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updateAt;
    private String utilisateur;
    

    public Users() {
    }

    public Users(Long id, boolean connected, Date created, String email, String password, Date updateAt, String utilisateur) {
        this.id = id;
        this.connected = connected;
        this.created = created;
        this.email = email;
        this.password = password;
        this.updateAt = updateAt;
        this.utilisateur = utilisateur;
    }
    
    
    public Users(boolean connected, Date created, String email, String password, Date updateAt, String utilisateur) {
        this.connected = connected;
        this.created = created;
        this.email = email;
        this.password = password;
        this.updateAt = updateAt;
        this.utilisateur = utilisateur;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    
    public String getRole(){
        return DiscriminatorValue.class.getName();
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

    @Override
    public String toString() {
        return "ht.GermainLescouflairSuy.gesBank.entite.Users[ id=" + id + " ]";
    }
    
}
