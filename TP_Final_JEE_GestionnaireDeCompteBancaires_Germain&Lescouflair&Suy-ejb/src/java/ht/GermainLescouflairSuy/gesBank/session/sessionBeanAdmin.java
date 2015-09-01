/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.session;

import ht.GermainLescouflairSuy.gesBank.entite.Admin;
import ht.GermainLescouflairSuy.gesBank.entite.Client;
import ht.GermainLescouflairSuy.gesBank.entite.Compte;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author MyPC
 */
@Stateful
@LocalBean
public class sessionBeanAdmin {
    
    private Admin admin;
    @PersistenceContext(unitName = "TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-ejbPU")
    private EntityManager em;

     public void persist(Object object) {
        em.persist(object);
    }
     
    public sessionBeanAdmin() {
    }

    public sessionBeanAdmin(Admin admin) {
        this.admin = admin;
    }
    
    
    
    public boolean ajouterClient(Client client){
        
        return false;
    }
    
    public boolean ajouterCompte(Compte compte){
        
        return true;
            
    }
    
    public Client listerClientByid(long idClient){
        
        return null;
    }
    public List<Client> listerClients(){
    
       Query query = em.createNamedQuery("Client.findAll");
       return query.getResultList();
    }
    
      public Compte listerCompteByid(long idCompte){
        
        return null;
    }
      //?
      public List<Compte> listerCompteClient(Client client){
       Query query = em.createNamedQuery("Compte.findAll");
       return query.getResultList();
    }
     
  
      public List<Client> listerComptes(){
    
        return null;
    }
      public boolean modifierClient(Client client){
          
           em.merge(client);
           return true;
          
      }
      
       public boolean modifierCompte(Compte compte){
          
           em.merge(compte);
           return true;
          
      }
       
          public boolean supprimerClient(Client client){
          em.remove(client);
          return true;
          
      }
      
       public boolean supprimerCompte(Compte compte){
          em.remove(compte);
          return true;
          
      }

   


}
