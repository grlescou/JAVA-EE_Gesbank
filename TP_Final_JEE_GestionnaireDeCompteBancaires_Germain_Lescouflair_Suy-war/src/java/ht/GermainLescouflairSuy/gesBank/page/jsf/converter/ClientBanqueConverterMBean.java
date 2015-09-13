/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.page.jsf.converter;

import ht.GermainLescouflairSuy.gesBank.entite.ClientBanque;
import ht.GermainLescouflairSuy.gesBank.session.SessionBeanAdmin;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author MyPC
 */
@FacesConverter("clientBanqueConverterMBean")
//@Named(value = "clientBanqueConverterMBean")
public class ClientBanqueConverterMBean implements Converter, Serializable   {
    @EJB
    private SessionBeanAdmin sessionBeanAdmin;

    /**
     * Creates a new instance of ClientBanqueConverterMBean
     */
    public ClientBanqueConverterMBean() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
     //   return sessionBeanAdmin.listerClientByid(Long.valueOf(value));
       
         if(value != null && value.trim().length() > 0) {
            try {
                
                return sessionBeanAdmin.listerClientsBanque().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }

        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      // return ((ClientBanque)value).getId().toString();
       
          if(value != null) {
            return String.valueOf(((ClientBanque) value).getId());
           // return String.format("%s %s",((ClientBanque) value).getPrenom(),((ClientBanque) value).getNom());
        }
        else {
            return null;
        }

    }
    
}
