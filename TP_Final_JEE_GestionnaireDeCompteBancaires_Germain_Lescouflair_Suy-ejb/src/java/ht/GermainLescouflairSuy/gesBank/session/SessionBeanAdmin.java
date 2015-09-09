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
import ht.GermainLescouflairSuy.gesBank.entite.Utilisateur;
import ht.GermainLescouflairSuy.gesBank.session.receiveJson.ReceiveJsondataGenerate;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import java.io.IOException;
import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

     ReceiveJsondataGenerate receiveJsondataGenerate;
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
        
        
        ClientBanque c2 = new ClientBanque("004-009-029-3", "Max", "paul", false, champDate(), "max@gmail.com", "1234", champDate(), "max");
        CompteCourant cpt12 = new CompteCourant (5000,champDate(),15000);
        CompteCourant cpt22 = new CompteCourant (15000,champDate(),106000);
        CompteEpargne cptE12 = new CompteEpargne (1000L,champDate(),60000);
        
        ajouterCompte(cpt12);
        ajouterCompte(cpt22);
        ajouterCompte(cptE12);
        
        c2.getComptes().add(cpt12);
        c2.getComptes().add(cpt22);
        c2.getComptes().add(cptE12);
        ajouterClient(c2 );
        
        ClientBanque c3 = new ClientBanque("004-009-039-3", "Marc", "Raoul", false, champDate(), "marc@gmail.com", "1234", champDate(), "marc");
        CompteCourant cpt13 = new CompteCourant (5000,champDate(),50000);
        CompteCourant cpt23 = new CompteCourant (15000,champDate(),200000);
        CompteEpargne cptE13 = new CompteEpargne (1000L,champDate(),40000);
        
        ajouterCompte(cpt13);
        ajouterCompte(cpt23);
        ajouterCompte(cptE13);
        
        c3.getComptes().add(cpt13);
        c3.getComptes().add(cpt23);
        c3.getComptes().add(cptE13);
        ajouterClient(c3 );
        
        
        //tx.commit();
       
        Administrateur admin1 = new Administrateur(true,  champDate(), "robert@gmail.com", "1234", champDate(), "admin","Ashley", "Germain");
        
        ajouterAdmin(admin1);
        receiveJsondataGenerate = new ReceiveJsondataGenerate();
         try {
            //ajouterClient(new Client("Richard", "Robert", "004-009-009-3", false, champDate(), "robert@gmail.com", "papa", champDate(), "rrobert") );
            List<ClientBanque> listClient = null;
            try {
                listClient = receiveJsondataGenerate.listUser();
                System.out.println("receiveJsonData list Size :"+listClient.size());
            } catch (org.json.simple.parser.ParseException ex) {
                Logger.getLogger(SessionBeanAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(ClientBanque c : listClient) {
                System.out.println(c);
                ajouterClient(c);
                
            }
        } catch (IOException ex) {
            Logger.getLogger(SessionBeanAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
    }

    public boolean ajouterCompte(Compte compte){
        persist(compte);
        return true;
            
    }
    
    public ClientBanque listerClientByid(long idClient){
        return em.find(ClientBanque.class, idClient);
        
    }
    public List<Utilisateur> listerClients(){
    
       Query query = em.createNamedQuery("Client.findAll");
       return query.getResultList();
    }
    
    public List<ClientBanque> listerClientsBanque(){
    
       Query query = em.createNamedQuery("ClientBanque.findAll");
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
