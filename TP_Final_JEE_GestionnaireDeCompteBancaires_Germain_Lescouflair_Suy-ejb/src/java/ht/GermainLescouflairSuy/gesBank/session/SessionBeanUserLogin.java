/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.session;

import ht.GermainLescouflairSuy.gesBank.entite.Utilisateur;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rachou
 */
@Stateless
@LocalBean
public class SessionBeanUserLogin  implements Serializable{
   private Utilisateur users;
    @PersistenceContext(unitName = "TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-ejbPU")
    private EntityManager em;
   
    public SessionBeanUserLogin() {
    }

    public SessionBeanUserLogin(Utilisateur users) {
        this.users = users;
    }

    
   public boolean loginController(String utilisateur, String password ){
       
       return false;
   }

    public void persist(Object object) {
        em.persist(object);
    }
   
}
