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
public class Crudential {
    
    
    
  private String username;
  private String password;

    public Crudential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Crudential() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    

  
}
