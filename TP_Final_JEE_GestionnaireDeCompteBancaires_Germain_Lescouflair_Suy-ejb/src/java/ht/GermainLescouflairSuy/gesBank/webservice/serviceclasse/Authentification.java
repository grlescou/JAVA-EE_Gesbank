/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.webservice.serviceclasse;

import ht.GermainLescouflairSuy.gesBank.entite.ClientBanque;

/**
 *
 * @author MyPC
 */
public class Authentification {
  
 
    
   public boolean success ;
   public ClientBanque clientBanque ;
   public String message;

    public Authentification(boolean success, ClientBanque clientBanque) {
        this.success = success;
        this.clientBanque = clientBanque;
    }

    public Authentification() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ClientBanque getClientBanque() {
        return clientBanque;
    }

    public void setClientBanque(ClientBanque clientBanque) {
        this.clientBanque = clientBanque;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
   
    
   
    

}
