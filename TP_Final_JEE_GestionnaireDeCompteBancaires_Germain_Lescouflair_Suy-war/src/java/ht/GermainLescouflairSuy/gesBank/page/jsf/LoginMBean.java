/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.page.jsf;

import ht.GermainLescouflairSuy.gesBank.entite.ClientBanque;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanUserLogin;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author MyPC
 */
@ManagedBean
@SessionScoped
public class LoginMBean {
    @EJB
    private SessionBeanUserLogin sessionBeanUserLogin;

    /**
     * Creates a new instance of LoginMBean
     */
    
    private ClientBanque client ;
    private String user;
    private String password ;
    private boolean connected = false;
    private String Role="Client" ;
    private String PageRole;
    //ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
    FacesContext fc = FacesContext.getCurrentInstance();
    ConfigurableNavigationHandler nav;
   //NavigationHandler nh ;
   
    private MenuModel model;
    
    
    
    
    public LoginMBean() {
         //  nh = fc.getApplication().getNavigationHandler();
  nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
           client = new ClientBanque();
           client.setNom("Lescouflair");
           client.setPrenom("Gaetan Robert");
    }

    public ClientBanque getClient() {
        return client;
    }

    public void setClient(ClientBanque client) {
        this.client = client;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
    
    public void deconnexion(ActionEvent actionEvent){
        this.connected = false;
       //addMessage("Deconecter");
        nav.performNavigation("/faces/login.xhtml?faces-redirect=true");
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getPageRole() {
        return PageRole;
    }

    public void setPageRole(String PageRole) {
        this.PageRole = PageRole;
    }
    
       
    
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
    public void checkConnection(){
        //Client client =  null;
        connected = (user.equals("grl") && password.equals("1234"));
        Role="Admin";
        init();
         if(connected){
           
      
                  if(this.Role.equals("Client"))
             {
                 //    return "client/MesComptes.xhtml?faces-redirect=true";
                 nav.performNavigation("/faces/client/MesComptes.xhtml?faces-redirect=true");
             }
              if(this.Role.equals("Admin"))
              {
                nav.performNavigation("/faces/admin/ListeComptes.xhtml?faces-redirect=true");  
              }   
        }
         else{
               nav.performNavigation("/faces/login.xhtml?faces-redirect=true");
         }
        
        
    }
    
    
    
    public void isUserConnected(ComponentSystemEvent event){
        
       PageRole = (String)event.getComponent().getAttributes().get("PageRole");
        if(this.Role.equals(PageRole)== false)
        {
            nav.performNavigation("/faces/login.xhtml?faces-redirect=true");
        }
       
        if(!connected){
         
        nav.performNavigation("/faces/login.xhtml?faces-redirect=true");
         
        }
        else{
            
           nav.performNavigation("#");
        }
    }
    
    
    
 
    //@PostConstruct
    public void init() {
        
     model = new DefaultMenuModel();   
     if(Role.equals("Client")){
        
        
        
         
        //First submenu
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");
         
        DefaultMenuItem item = new DefaultMenuItem("Mes Comptes");
        item.setUrl("MesComptes.xhtml");
        item.setIcon("ui-icon-home");
        firstSubmenu.addElement(item);
        DefaultMenuItem item2=new DefaultMenuItem("Depot/Retrait");
        item2.setUrl("transfertClient.xhtml");
        item2.setIcon("ui-icon-home");
        firstSubmenu.addElement(item2);
        
         
        model.addElement(firstSubmenu);
         
        //Second submenu
        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");
 
        item = new DefaultMenuItem("Save");
        item.setIcon("ui-icon-disk");
        item.setCommand("#{menuView.save}");
        //item.setUpdate("messages");
        secondSubmenu.addElement(item);
         
        item = new DefaultMenuItem("Delete");
        item.setIcon("ui-icon-close");
        item.setCommand("#{menuView.delete}");
        item.setAjax(false);
        secondSubmenu.addElement(item);
         
        item = new DefaultMenuItem("Redirect");
        item.setIcon("ui-icon-search");
        item.setCommand("#{menuView.redirect}");
        secondSubmenu.addElement(item);
 
        model.addElement(secondSubmenu);
        
        }
        
         if(Role.equals("Admin")){
        
        
        
         
        //First submenu
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");
         
        DefaultMenuItem item = new DefaultMenuItem("Liste des Comptes");
        item.setUrl("http://www.primefaces.org");
        item.setIcon("ui-icon-home");
        firstSubmenu.addElement(item);
        
         DefaultMenuItem item2 = new DefaultMenuItem("Nouveau Client");
        item2.setUrl("EnregistrerClients.xhtml");
        item2.setIcon("ui-icon-home");
        firstSubmenu.addElement(item2);
        
         
        model.addElement(firstSubmenu);
         
        //Second submenu
        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");
 
        item = new DefaultMenuItem("Save");
        item.setIcon("ui-icon-disk");
        item.setCommand("#{menuView.save}");
        //item.setUpdate("messages");
        secondSubmenu.addElement(item);
         
        item = new DefaultMenuItem("Delete");
        item.setIcon("ui-icon-close");
        item.setCommand("#{menuView.delete}");
        item.setAjax(false);
        secondSubmenu.addElement(item);
         
        item = new DefaultMenuItem("Redirect");
        item.setIcon("ui-icon-search");
        item.setCommand("#{menuView.redirect}");
        secondSubmenu.addElement(item);
 
        model.addElement(secondSubmenu);
        
        }
        
       
        
    }
 
    public MenuModel getModel() {
        return model;
    }   
     
    
}
