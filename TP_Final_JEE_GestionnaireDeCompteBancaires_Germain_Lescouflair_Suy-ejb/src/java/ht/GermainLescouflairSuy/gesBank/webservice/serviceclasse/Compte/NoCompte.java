/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.webservice.serviceclasse.Compte;

/**
 *
 * @author MyPC
 */
public class NoCompte {
    
    private long noCompte ;
    private String typeCompte;

    public NoCompte(long noCompte, String typeCompte) {
        this.noCompte = noCompte;
        this.typeCompte = typeCompte;
    }

    public NoCompte() {
    }

    public long getNoCompte() {
        return noCompte;
    }

    public void setNoCompte(long noCompte) {
        this.noCompte = noCompte;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }
    
    
    
    
}
