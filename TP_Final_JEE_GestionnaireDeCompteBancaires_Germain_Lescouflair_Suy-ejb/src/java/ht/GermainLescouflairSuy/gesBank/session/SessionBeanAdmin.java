/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.session;

import ht.GermainLescouflairSuy.gesBank.entite.Administrateur;
import ht.GermainLescouflairSuy.gesBank.entite.ClientBanque;
import ht.GermainLescouflairSuy.gesBank.entite.Compte;
import ht.GermainLescouflairSuy.gesBank.entite.CompteCourant;
import ht.GermainLescouflairSuy.gesBank.entite.CompteEpargne;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author MyPC
 */
@Stateless
@LocalBean
public class SessionBeanAdmin implements Serializable{
    
    
    private Administrateur admin;
    @PersistenceContext(unitName = "TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-ejbPU")
    private EntityManager em;


     public void persist(Object object) {
        em.persist(object);
    }
     
    public SessionBeanAdmin() {
    }

    public SessionBeanAdmin(Administrateur admin) {
        this.admin = admin;
    }
    
    
    
    public boolean ajouterClient(ClientBanque client){
        
        persist(client);
        return true;
    }
    
    
     public boolean ajouterAdmin(Administrateur adm){
        
        persist(adm);
        return true;
    }
    
     private Date champDate(){
        Date mydate = new Date();
        return mydate;
    }
    
    public void ajouterClientTest(){
     //   EntityTransaction tx = em.getTransaction(); 

       // tx .begin( );
        ClientBanque c1 = new ClientBanque("004-009-009-3", "Robert", "Richard", false, champDate(), "robert@gmail.com", "papa", champDate(), "rrobert");
        CompteCourant cpt1 = new CompteCourant (5000,champDate(),10000);
        CompteCourant cpt2 = new CompteCourant (15000,champDate(),100000);
        CompteEpargne cptE1 = new CompteEpargne (1000L,champDate(),100000);
        
        ajouterCompte(cpt1);
        ajouterCompte(cpt2);
        ajouterCompte(cptE1);
        
        c1.getComptes().add(cpt1);
        c1.getComptes().add(cpt2);
        c1.getComptes().add(cptE1);
        ajouterClient(c1 );
        //tx.commit();
       
        Administrateur admin1 = new Administrateur(true,  champDate(), "robert@gmail.com", "1234", champDate(), "admin","Robert", "Richard");
        
        ajouterAdmin(admin1);
    }

    public boolean ajouterCompte(Compte compte){
        persist(compte);
        return true;
            
    }
    
    public ClientBanque listerClientByid(long idClient){
        return em.find(ClientBanque.class, idClient);
        
    }
    public List<ClientBanque> listerClients(){
    
       Query query = em.createNamedQuery("Client.findAll");
       return query.getResultList();
    }
    
      public Compte listerCompteByid(long idCompte){
          return em.find(Compte.class, idCompte);
        
    }
      //?
      public List<Compte> listerCompteClient(ClientBanque client){
      // Query query = em.createNamedQuery("Compte.findAll");
      // Query querye = em.createNamedQuery("Client")
               
       return client.getComptes();
    }
     
  
      public List<Compte> listerComptes(){
          
      Query query = em.createNamedQuery("Compte.findAll");
       return query.getResultList();
    }
      
      public boolean modifierClient(ClientBanque client){
          
           em.merge(client);
           return true;
          
      }
      
       public boolean modifierCompte(Compte compte){
          
           em.merge(compte);
           return true;
          
      }
       
          public boolean supprimerClient(ClientBanque client){
          em.remove(client);
          return true;
          
      }
      
       public boolean supprimerCompte(Compte compte){
          em.remove(compte);
          return true;
          
      }

   
   


}
