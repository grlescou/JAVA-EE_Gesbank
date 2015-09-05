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
public enum TypeOperation {
    
    CREATION("creation"), DEBIT("debit"), CREDIT("credit"), TRANSFERT("transfert"), MONTANT("montant");
    
    private String type;
    
    private TypeOperation(String type){
        this.type = type;
        
    }
    
    public String getType(){
        return this.type;
    }
}
