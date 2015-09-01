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

/**
 *
 * @author MyPC
 */
@Stateful
@LocalBean
public class sessionBeanAdmin {
    
    private Admin admin;
    
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
    
        return null;
    }
    
      public Compte listerCompteByid(long idCompte){
        
        return null;
    }
      
      public List<Compte> listerCompteClient(Client client){
    
        return null;
    }
  
      public List<Client> listerComptes(){
    
        return null;
    }
      public boolean modifierClient(Client client){
          
          return false;
          
      }
      
       public boolean modifierCompte(Compte compte){
          
          return false;
          
      }
       
          public boolean supprimerClient(Client client){
          
          return false;
          
      }
      
       public boolean supprimerCompte(Compte compte){
          
          return false;
          
      }


}
