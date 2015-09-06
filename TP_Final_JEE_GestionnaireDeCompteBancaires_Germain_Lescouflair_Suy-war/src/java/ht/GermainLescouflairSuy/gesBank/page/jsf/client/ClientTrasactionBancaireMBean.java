/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.page.jsf.client;


import ht.GermainLescouflairSuy.gesBank.entite.ClientBanque;
import ht.GermainLescouflairSuy.gesBank.entite.Compte;
import ht.GermainLescouflairSuy.gesBank.entite.OperationBancaire;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanClient;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author MyPC
 */

@Named(value = "clientTrasactionBancaireMBean")
@RequestScoped
public class ClientTrasactionBancaireMBean {
    @EJB
    private SessionBeanClient sessionBeanClient;
    private ClientBanque client ;
    private Compte compteBancaire;
    private Compte SelectedcompteBancaire;
    private String btnString ;
    private boolean canModified ;
    private List<Compte> compteBancaireFilter;
     
    /**
     * Creates a new instance of ClientTrasactionBancaireMBean
     */
    public ClientTrasactionBancaireMBean() {
    }
    
    public void loadClientFromSession(ClientBanque client ){
        this.client = client;
    }
    
    public List<Compte> ListeComptes(){
        return client.getComptes();
    }
    
    public List<OperationBancaire> ListOperationBancaires(Compte compte){
        return compte.getOperations();
    }

    public ClientBanque getClient() {
        return client;
    }

    public void setClient(ClientBanque client) {
        this.client = client;
    }

    public Compte getSelectedcompteBancaire() {
        return SelectedcompteBancaire;
    }

    public void setSelectedcompteBancaire(Compte SelectedcompteBancaire) {
        this.SelectedcompteBancaire = SelectedcompteBancaire;
    }

    public boolean isCanModified() {
        return canModified;
    }

    public void setCanModified(boolean canModified) {
        this.canModified = canModified;
    }

    public List<Compte> getCompteBancaireFilter() {
        return compteBancaireFilter;
    }

    public void setCompteBancaireFilter(List<Compte> compteBancaireFilter) {
        this.compteBancaireFilter = compteBancaireFilter;
    }
    
    
}
