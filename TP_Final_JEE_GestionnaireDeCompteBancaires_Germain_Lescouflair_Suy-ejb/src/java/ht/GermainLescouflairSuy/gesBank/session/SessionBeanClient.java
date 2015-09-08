/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.session;

import ht.GermainLescouflairSuy.gesBank.entite.ClientBanque;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author lyzzy
 */
@Stateless
@LocalBean
public class SessionBeanClient {
    @PersistenceContext(unitName = "TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-ejbPU")
    private EntityManager em;

    public List<ClientBanque>getAllClients() {
       Query query = em.createNamedQuery("ClientBanque.findAll");  
        return query.getResultList(); 
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public ClientBanque updateClient(ClientBanque client) {
        return em.merge(client);
    }

    
    public void persist(Object object) {
        em.persist(object);
    }
    
    
}
