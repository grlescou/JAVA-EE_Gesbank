/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.session;

import ht.GermainLescouflairSuy.gesBank.entite.Client;
import ht.GermainLescouflairSuy.gesBank.entite.Compte;
import ht.GermainLescouflairSuy.gesBank.entite.OperationBancaire;
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
public class SessionBeanClient {
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
        return false;
    }
    
    public boolean debiterCompte(double montant, Compte compte) {
        return false;
    }
    
         public List<OperationBancaire> listeOperationCompte(Client client){
             Query query =em.createNamedQuery("OperationBancaire.findAll");
        return null;
    }
         
     public Compte listerCompteByid(long idCompte, Client client){
        
        return null;
    }

    public Boolean Transferer(double montant, Compte compteSource, Compte compteDestnation) {
        return null;
    }

   
     
    
    
    
    
}
