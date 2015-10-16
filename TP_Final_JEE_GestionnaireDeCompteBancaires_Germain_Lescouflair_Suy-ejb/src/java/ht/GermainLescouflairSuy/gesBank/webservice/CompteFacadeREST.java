/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.webservice;

import ht.GermainLescouflairSuy.gesBank.entite.ClientBanque;
import ht.GermainLescouflairSuy.gesBank.webservice.AbstractFacade;
import ht.GermainLescouflairSuy.gesBank.entite.Compte;
import ht.GermainLescouflairSuy.gesBank.entite.CompteCourant;
import ht.GermainLescouflairSuy.gesBank.entite.CompteEpargne;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanAdmin;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanClient;
import ht.GermainLescouflairSuy.gesBank.webservice.serviceclasse.Compte.NoCompte;
import ht.GermainLescouflairSuy.gesBank.webservice.serviceclasse.Compte.OurvrirCompteService;
import ht.GermainLescouflairSuy.gesBank.webservice.serviceclasse.Compte.VirementService;
import ht.GermainLescouflairSuy.gesBank.webservice.serviceclasse.Message;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author MyPC
 */
@Stateless
@Path("compte")
public class CompteFacadeREST extends AbstractFacade<Compte> {
    @EJB
    private SessionBeanAdmin sessionBeanAdmin;
    @EJB
    private SessionBeanClient sessionBeanClient;
    
    @PersistenceContext(unitName = "TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-ejbPU")
    private EntityManager em;
    
    
    
    public CompteFacadeREST() {
        super(Compte.class);
    }

//    @POST
//    @Override
//    @Consumes({"application/xml", "application/json"})
//    public void create(Compte entity) {
//        super.create(entity);
//    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, Compte entity) {
        super.edit(entity);
    }

//    @DELETE
//    @Path("{id}")
//    public void remove(@PathParam("id") Long id) {
//        super.remove(super.find(id));
//    }

  /*  @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Compte find(@PathParam("id") Long id) {
        return super.find(id);
    }
*/
    @GET
    @Override
    @Produces({"application/json"})
    public List<Compte> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Compte> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    
    
    @GET
    @Path("{idUser}")
    @Produces({"application/json"})
    public List<Compte> getListCompte(@PathParam("idUser") Long id) {
        
        
        ClientBanque client = sessionBeanAdmin.listerClientByid(id.longValue());
        
         List<Compte> lsCompt  = new ArrayList<>();
        
        for(Compte c1 : client.getComptes())
        {
           if(c1.isIsOpen()){
            lsCompt.add(c1);
           }
        }
        
      
        
         
        return   lsCompt;
      
    }
    
    
    @GET
    @Path("no")
    @Produces({"application/json"})
    public List<NoCompte> listeNoComptes() {
       
        List<Compte> listCmpt = super.findAll();
        List<NoCompte> noCmpt = new ArrayList<>();
        for(Compte c : listCmpt){
            if(c.isIsOpen()){
            noCmpt.add(new NoCompte(c.getNumeroCompte(),c.getTypeCompte()));
            }
        }
        
        return  noCmpt;
    }
    
    
    
    
   @POST
   @Consumes({ "application/json"})
   @Produces({"application/json"})
    public Message OurvirCompte(OurvrirCompteService entity) {
       
        Message msg = new Message();
        ClientBanque client =sessionBeanAdmin.listerClientByid(entity.getIdClient());
        
        if(entity.getTypeCompte().equals("CompteC"))
        {
            CompteCourant CC = new CompteCourant(entity.getSolde()*2.0,new Date(),entity.getSolde());
            client.getComptes().add(CC);
            em.persist(CC);
            em.persist(client);
            
            msg.setSuccess(true);
            msg.setMessage("Le compte courant est ouvert avec succes");
        }
        else if(entity.getTypeCompte().equals("CompteE"))
        {
            CompteEpargne CE = new CompteEpargne (0.2,new Date(),entity.getSolde() );
          
            client.getComptes().add(CE);
            em.persist(CE);
            em.persist(client);
            
            msg.setSuccess(true);
            msg.setMessage("Le compte epargne est ouvert avec succes");
        }
        else{
             msg.setSuccess(false);
             msg.setMessage("echec d'ouverture du compte");
        }
        
        
        return msg ;
    } 
    
    
    
   @POST
   @Path("virement")
   @Consumes({ "application/json"})
   @Produces({"application/json"})
    public Message virement(VirementService entity) {
        boolean sucess = false;
         Message msg = new Message();
        Compte client =sessionBeanAdmin.listerCompteByid(entity.getIdclient());
        
        Compte clientDestination = sessionBeanAdmin.listerCompteByid(entity.getIdclientDestination());
        
        sucess= sessionBeanAdmin.transferer(entity.getMontant(), client, clientDestination);
        
        if(sucess)
        {
            msg.setSuccess(true);
            msg.setMessage("Virement effectuer avec succes"); 
        }
        else
        {
             msg.setSuccess(false);
             msg.setMessage("Echec de virement"); 
        }
        
        return msg;
    }
    
    
    
    @DELETE
    @Path("{id}")
    @Produces({"application/json"})
    public Message remove(@PathParam("id") Long id) {
        
        Compte c = super.find(id);
        c.setIsOpen(false);
          
        super.edit(c);
        
        Message msg = new Message(true,"fermeture du compte avec success");
        
        return msg;
    }
    
}
