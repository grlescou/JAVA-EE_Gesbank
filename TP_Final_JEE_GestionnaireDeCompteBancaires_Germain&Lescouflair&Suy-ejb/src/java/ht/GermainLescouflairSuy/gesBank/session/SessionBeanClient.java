/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.session;

import ht.GermainLescouflairSuy.gesBank.entite.Client;
import ht.GermainLescouflairSuy.gesBank.entite.Compte;
import ht.GermainLescouflairSuy.gesBank.entite.OperationBancaire;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Rachou
 */
@Stateless
@LocalBean
public class SessionBeanClient implements Serializable {
    @PersistenceContext(unitName = "TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-ejbPU")
    private EntityManager em;

    private Client client;

    public SessionBeanClient() {
    }
    
    
     public SessionBeanClient(EntityManager em, Client client) {
        this.em = em;
        this.client = client;
    }

    public void persist(Object object) {
        em.persist(object);
    }

    public boolean crediterCompte(double montant, Compte compte) {
       compte.crediter(montant);
       em.merge(compte);
        return true;
    }
    
    public boolean debiterCompte(double montant, Compte compte) {
        compte.debiter(montant);
        em.merge(compte);
        return true;
    }
    
         public List<OperationBancaire> listeOperationCompte(Compte compte){
             Query query =em.createNamedQuery("OperationBancaire.findAll");
             return query.getResultList();
    }
      
             
     public Compte listerCompteByid(long idCompte){
        
        return  em.find(Compte.class, idCompte);
    }
     
     public List<Compte> listerComptes(Compte compte){
         Query query = em.createNamedQuery("Compte.findAll");
         return query.getResultList();
     }

    public Boolean Transferer(double montant, Compte compteSource, Compte compteDestnation) {
       compteSource.debiter(montant);
       compteDestnation.crediter(montant);
       
        return true;
    }

   
     
    
    
    
    
}
