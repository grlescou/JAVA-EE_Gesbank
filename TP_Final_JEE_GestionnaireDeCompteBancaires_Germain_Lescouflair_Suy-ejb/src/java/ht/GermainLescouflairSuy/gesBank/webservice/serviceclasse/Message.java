/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.webservice.serviceclasse;

/**
 *
 * @author MyPC
 */
public class Message {
 
   private boolean success ;
   private String message;

    public Message(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Message() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
   
    
   
    
}
