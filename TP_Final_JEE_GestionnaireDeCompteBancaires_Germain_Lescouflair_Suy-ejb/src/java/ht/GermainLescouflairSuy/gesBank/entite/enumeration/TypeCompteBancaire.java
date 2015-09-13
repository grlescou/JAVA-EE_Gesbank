/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.entite.enumeration;

/**
 *
 * @author lyzzy
 */
public enum TypeCompteBancaire {


    
    COURANT("Courant"), EPARGNE("Epargne"), COURANTDB("CompteC"), EPARGNEDB("CompteC");
    
    private String type;
    
    private TypeCompteBancaire(String type){
        this.type = type;
        
    }
    
    public String getType(){
        return this.type;
    } 
}
