/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.session.receiveJson;
import ht.GermainLescouflairSuy.gesBank.entite.ClientBanque;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.Application;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.jboss.weld.context.ApplicationContext;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import sun.misc.IOUtils;
/**
 *
 * @author Rachou
 */
public class ReceiveJsondataGenerate   {
    
    public String receiveJson;
    //public ClientBanque client;
    List<ClientBanque> jsonList = new ArrayList<>();

    
    public List<ClientBanque> listUser() throws IOException, org.json.simple.parser.ParseException{
        
    
        try {
            JSONParser parser = new JSONParser();
            InputStream in= getClass().getResourceAsStream("/WEB-INF/Utilisateur.json");
            URL resource = this.getClass().getResource("Utilisateur.json");
            File file = new File(resource.toURI());
            FileInputStream input = new FileInputStream(file);
            //  getClass().getClassLoader().getResourceAsStream
            InputStreamReader inr = new InputStreamReader(input);
            BufferedReader str=new BufferedReader(inr);
            String myString = "";
            String line  ="";
            
            while( (line = str.readLine()) != null ){
                myString +=line;
            }
            System.out.println("=======String file load :"+myString);
            JSONArray jsonarray = (JSONArray) parser.parse(myString);
            System.out.println(jsonarray.toJSONString());
            for(Object o: jsonarray){
                
                JSONObject person = (JSONObject)o;
                
                Date d = new Date ();
                ClientBanque  client = new ClientBanque((String)person.get("nif/Cin"),(String)person.get("nom"),(String)person.get("prenom"),false, d, (String)person.get("email"), (String)person.get("password"), d, (String)person.get("utilisateur"));
                jsonList.add(client);
            }
            return jsonList;
        } catch (URISyntaxException ex) {
            Logger.getLogger(ReceiveJsondataGenerate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     *
     * @param str_date
     * @return Date
     * @throws ParseException
     */
    public Date dateFormated(String str_date) throws ParseException{

        DateFormat formatter ; 
        Date date ; 
        formatter = new SimpleDateFormat("dd-MMM-yy");
        date = formatter.parse(str_date);

        return date;
    }
        

}
