/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.session;

import ht.GermainLescouflairSuy.gesBank.entite.Admin;
import ht.GermainLescouflairSuy.gesBank.entite.Client;
import ht.GermainLescouflairSuy.gesBank.entite.Compte;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author MyPC
 */
@Stateless
@LocalBean
public class SessionBeanAdmin implements Serializable{
    
    
    private Admin admin;
    @PersistenceContext(unitName = "TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-ejbPU")
    private EntityManager em;

     public void persist(Object object) {
        em.persist(object);
    }
     
    public SessionBeanAdmin() {
    }

    public SessionBeanAdmin(Admin admin) {
        this.admin = admin;
    }
    
    
    
    public boolean ajouterClient(Client client){
        
        persist(client);
        return true;
    }
    
     private Date champDate(){
        Date mydate = new Date();
        return mydate;
    }
    
    public void ajouterClientTest(){
    ajouterClient(new Client("Richard", "Robert", "004-009-009-3", false, champDate(), "robert@gmail.com", "papa", champDate(), "rrobert") );
    }

    public boolean ajouterCompte(Compte compte){
        persist(compte);
        return true;
            
    }
    
    public Client listerClientByid(long idClient){
        return em.find(Client.class, idClient);
        
    }
    public List<Client> listerClients(){
    
       Query query = em.createNamedQuery("Client.findAll");
       return query.getResultList();
    }
    
      public Compte listerCompteByid(long idCompte){
          return em.find(Compte.class, idCompte);
        
    }
      //?
      public List<Compte> listerCompteClient(Client client){
      // Query query = em.createNamedQuery("Compte.findAll");
      // Query querye = em.createNamedQuery("Client")
               
       return client.getComptes();
    }
     
  
      public List<Compte> listerComptes(){
          
      Query query = em.createNamedQuery("Compte.findAll");
       return query.getResultList();
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
