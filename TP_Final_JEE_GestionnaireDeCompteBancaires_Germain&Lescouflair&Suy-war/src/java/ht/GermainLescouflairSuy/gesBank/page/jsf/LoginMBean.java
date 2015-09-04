/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.page.jsf;

import ht.GermainLescouflairSuy.gesBank.entite.Client;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author MyPC
 */
@ManagedBean
@SessionScoped
public class LoginMBean {

    /**
     * Creates a new instance of LoginMBean
     */
    
    private Client client ;
    private String user;
    private String password ;
    private boolean connected = false;
    
    public LoginMBean() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
    
    
    public void checkConnection(){
        Client client =  null;
        
        if(true){
            
        }
        
        
    }
    
    
    
}
