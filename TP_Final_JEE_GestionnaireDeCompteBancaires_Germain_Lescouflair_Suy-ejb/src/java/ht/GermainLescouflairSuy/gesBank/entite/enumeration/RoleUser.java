/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.entite.enumeration;

/**
 *
 * @author MyPC
 */
public enum RoleUser {
    Utilisateur ("Utilisator"), Client("ClientB"), Admin("Administ");
    
    private String type;
    
    private  RoleUser(String type){
        this.type = type;
        
    }
    
    public String getRole(){
        return this.type;
    }
}
