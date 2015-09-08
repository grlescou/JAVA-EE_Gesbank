/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.GermainLescouflairSuy.gesBank.session.receiveJson;
import ht.GermainLescouflairSuy.gesBank.entite.ClientBanque;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 *
 * @author Rachou
 */
public class ReceiveJsondataGenerate {
    
    public String receiveJson;
    //public ClientBanque client;
    List<ClientBanque> jsonList = new ArrayList<>();

    
    public List<ClientBanque> listUser() throws IOException, org.json.simple.parser.ParseException{
        
    
            JSONParser parser = new JSONParser();
    
             
        JSONArray jsonarray = (JSONArray) parser.parse(new FileReader("json/user.json"));
        System.out.println(jsonarray.toJSONString());
        for(Object o: jsonarray){
            
            JSONObject person = (JSONObject)o;
            
                 try {
                 ClientBanque  client = new ClientBanque((String)person.get("nif/Cin"),(String)person.get("nom"),(String)person.get("prenom"),(boolean)person.get("connected"), dateFormated((String)person.get("date created")), (String)person.get("email"), (String)person.get("password"), dateFormated((String)person.get("dateUpdate")), (String)person.get("utilisateur"));
                     jsonList.add(client);
                     
//            client.setNifCin((String)person.get("nif/Cin"));
//            client.setNom((String)person.get("nom"));
//            client.setPrenom((String)person.get("prenom"));
//            Client((String)person.get("connected"));
//          //  String date_created = (String)person.get("date created");
//           // String email = (String)person.get("email");
//           // String password = (String)person.get("password");
                     // String dateUpdate =(String)person.get("dateUpdate");
//            String utilisateur = (String)person.get("utilisateur");
                     
                     // System.out.println("("+id_security+" "+lastName+" "+firstName+" "+is_connected+" "+date_created+" "+email+" "+password+" "+utilisateur+")");
                 } catch (ParseException ex) {
                     Logger.getLogger(ReceiveJsondataGenerate.class.getName()).log(Level.SEVERE, null, ex);
                 }
        }
        return jsonList;
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
