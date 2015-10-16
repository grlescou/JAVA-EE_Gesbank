/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.session;

import ht.GermainLescouflairSuy.gesBank.entite.Compte;
import ht.GermainLescouflairSuy.gesBank.entite.OperationBancaire;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author MyPC
 */
@Stateless
@LocalBean
public class SessionBeanOperationBancaire implements Serializable {

     @EJB
    private SessionBeanClient gestionnaireDeCompteBancaire;
    @PersistenceContext(unitName = "TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-ejbPU")
    private EntityManager em;
   
    private Compte compte;

    public SessionBeanOperationBancaire(){
        
    }
    
    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
    
    public void loadCompteBancaireById(long idCompteBancaire){
       this.compte =  gestionnaireDeCompteBancaire.getCompteByid(idCompteBancaire);
    }
    
    
    public void persist(Object object) {
        em.persist(object);
    }
    

     
     public List<OperationBancaire> getOperationBancaire(Compte compte) {
        
       
        return compte.getOperations();
    }


    
    public List<OperationBancaire> getOperationBancaire(long idCompteBancaire) {
        
        Query query = em.createNamedQuery("OperationBancaire.findAllByid",OperationBancaire.class);
        query.setParameter("id", idCompteBancaire);
        return query.getResultList();
    }

  

 
}
