/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.session;

import ht.GermainLescouflairSuy.gesBank.entite.Users;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Rachou
 */
@Stateless
@LocalBean
public class SessionBeanUserLogin {
   private Users users;

    public SessionBeanUserLogin() {
    }

    public SessionBeanUserLogin(Users users) {
        this.users = users;
    }

    
   public boolean loginController(String utilisateur, String password ){
       
       return false;
   }
}
