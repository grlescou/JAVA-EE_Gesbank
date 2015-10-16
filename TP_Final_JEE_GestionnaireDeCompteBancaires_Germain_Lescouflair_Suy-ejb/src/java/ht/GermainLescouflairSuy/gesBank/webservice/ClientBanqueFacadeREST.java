/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.webservice;

import ht.GermainLescouflairSuy.gesBank.webservice.AbstractFacade;
import ht.GermainLescouflairSuy.gesBank.entite.ClientBanque;
import ht.GermainLescouflairSuy.gesBank.entite.Utilisateur;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanAdmin;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanUserLogin;
import ht.GermainLescouflairSuy.gesBank.webservice.serviceclasse.Authentification;
import ht.GermainLescouflairSuy.gesBank.webservice.serviceclasse.Compte.ClientService;
import ht.GermainLescouflairSuy.gesBank.webservice.serviceclasse.Crudential;
import ht.GermainLescouflairSuy.gesBank.webservice.serviceclasse.Message;
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
@Path("clientbanque")
public class ClientBanqueFacadeREST extends AbstractFacade<ClientBanque> {
    @EJB
    private SessionBeanAdmin sessionBeanAdmin;
    @EJB
    private SessionBeanUserLogin sessionBeanUserLogin;
    
    @PersistenceContext(unitName = "TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-ejbPU")
    private EntityManager em;

    
    
    public ClientBanqueFacadeREST() {
        super(ClientBanque.class);
    }

//    @POST
//    @Override
//    @Consumes({"application/json"})
//    public void create(ClientBanque entity) {
//        super.create(entity);
//    }

//    @PUT
//    @Path("{id}")
//    @Consumes({"application/xml", "application/json"})
//    public void edit(@PathParam("id") Long id, ClientBanque entity) {
//        super.edit(entity);
//    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public ClientBanque find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<ClientBanque> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<ClientBanque> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
    /**
     *
     * @param u
     * @param entity
     * @return
     */
    @POST
    @Path("login")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Authentification login(Crudential u) {
        boolean success = false;
        Authentification auth = new Authentification();
    
        success = sessionBeanUserLogin.loginController(u.getUsername(), u.getPassword());
        
        if(success){
            
           Utilisateur user = sessionBeanUserLogin.getUtilisateurByUsername(u.getUsername());
            ClientBanque client =sessionBeanAdmin.listerClientByid(user.getId().longValue());
            auth.setSuccess(success);
            auth.setClientBanque(client);
           
        }
        else{
            auth.setSuccess(success);
            auth.setMessage("Utilisateur ou mot de passe incorrecte");
        }
        
        
        return auth;
    }
    
    
    
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Message Inscrire(ClientService client) {
        
        Message msg = new Message();
        
        ClientBanque entity = new ClientBanque(); 
        entity.setNom(client.getNom());
        entity.setPrenom(client.getPrenom());
        entity.setPassword(client.getPassword());
        entity.setUsername(client.getUtilisateur());
        entity.setNifCin(client.getNifCin());
        entity.setEmail(client.getEmail());
        entity.setConnected(client.isConnected());
        try{
        super.create(entity);
        msg.setSuccess(true);
        msg.setMessage("Inscription reussie avec succes");
        }
        catch(Exception e){
           msg.setSuccess(false);
            msg.setMessage("Impossible de enregistre");  
        }
        
        return msg;
    }
    
    
    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Message edit(@PathParam("id") Long id, ClientService entity) {
        Message msg = new Message();
        ClientBanque client = super.find(id);
        
        if(client != null){
          
             client.setEmail(entity.getEmail());
             client.setUsername(entity.getUtilisateur());
             client.setNom(entity.getNom());
             client.setPrenom(entity.getPrenom());
             client.setPassword(entity.getPassword());
             client.setNifCin(entity.getNifCin());
             client.setUpdateAt(new Date());
             super.edit(client);
             msg.setSuccess(true);
             msg.setMessage("Profile modifier avec success");
             
        }
        else
        {
             msg.setSuccess(false);
             msg.setMessage("Echec de modification du profile"); 
        }
        
       return msg;
    }
    
    
}


 