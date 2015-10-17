
TP J2EE et Web service Rest


La branche a utilise est le origin/grl

**utilisateur test:** 
pour connecter en tant que Admin 
user :admin 
password : 1234

pour connecter en tant que client 
user: rrobert
password : papa

Replace localhost to server IP

****************************************************************************************
Client Banque
****************************************************************************************
_____________________________________
connection du client banque 
_____________________________________
URL : 
http://localhost:8080/TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-war/webresources/clientbanque/login

methode : Post 

send type JSON 

CONTENT 
----------------

{
  "username": "rrobert",
  "password": "papa"
}


REPONSE
------------------
{"success":true,
"clientBanque":{"connected":false,
		"created":"2015-10-13T09:24:23.833-04:00",
		"email":"robert@gmail.com",
		"id":1,
		"password":"papa",
		"updateAt":"2015-10-13T09:24:23.833-04:00",
		"username":"rrobert",
		"nifCin":"004-009-009-3",
		"nom":"Robert",
		"prenom":"Richard"}
}

________________________________
inscription du client banque 
_____________________________________
URL : 
http://localhost:8080/TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-war/webresources/clientbanque

methode : Post 

send type JSON 

CONTENT 
----------------

{
	"utilisateur":"leonard202",
        "password" :"12345",
	"email":"pauleonard2@gmail.com",
        "nifCin":"121-212-322-02",
        "nom": "Leonard202",
        "prenom": "Paul202",
        "connected": true
}

REPONSE
------------------
Success true 
###########
{"message":"Inscription reussie avec succes","success":true}

success false
###############
{"message":"Impossible de enregistre","success":false}


_____________________________________
GET Profile du client de ID 
_____________________________________

URL : 
http://localhost:8080/TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-war/webresources/clientbanque/{id}

methode : GET  


send type Parameter

Paramter 
----------------
{id} : id du clientBanque 




REPONSE
------------------
{"type":"clientBanque","connected":false,"created":"2015-10-13T14:18:39.476-04:00","email":"robert@gmail.com","id":1,"password":"papa","updateAt":"2015-10-13T14:18:39.476-04:00","username":"rrobert","nifCin":"004-009-009-3","nom":"Robert","prenom":"Richard"}


____________________________________
Modification du profile du  client banque 
_____________________________________
URL : 
http://localhost:8080/TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-war/webresources/clientbanque/{id}

methode : PUT

send type JSON and type Parameter

Paramter 
----------------
{id} : id du clientBanque 

CONTENT JSON
----------------

{
	"utilisateur":"leonard202",
        "password" :"12345",
	"email":"pauleonard2@gmail.com",
        "nifCin":"121-212-322-02",
        "nom": "Leonard202",
        "prenom": "Paul202",
        "connected": true
}


REPONSE
------------------
success: true
##########

{"message":"Profile modifier avec success","success":true}

Success:false
#############
{"message":"Echec de modification du profile","success":false}


*****************************************************************************************************
Compte 
*****************************************************************************************************
________________________________
Liste Compte du client banque
________________________________
URL : 
http://localhost:8080/TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-war/webresources/compte/{idUser}

methode : GET  


send type Parameter

Paramter 
----------------
{idUser} : id du clientBanque 




REPONSE
------------------
[{"dateCreation":"2015-10-13T10:09:05.054-04:00","numeroCompte":2,"operations":[{"dateOperation":"2015-10-13T10:09:05.054-04:00","description":"creation","id":3,"montant":10000.0}],"solde":10000.0,"typeCompte":"CompteC"},{"dateCreation":"2015-10-13T10:09:05.057-04:00","numeroCompte":4,"operations":[{"dateOperation":"2015-10-13T10:09:05.057-04:00","description":"creation","id":5,"montant":100000.0}],"solde":100000.0,"typeCompte":"CompteC"},{"dateCreation":"2015-10-13T10:09:05.057-04:00","numeroCompte":6,"operations":[{"dateOperation":"2015-10-13T10:09:05.057-04:00","description":"creation","id":7,"montant":100000.0}],"solde":100000.0,"typeCompte":"CompteE"}]


_______________________________________________________
liste des NumeroCompte pour les listes deroulantes 
_____________________________________________________

URL : 
http://localhost:8080/TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-war/webresources/compte/no

methode : GET  


send type None




REPONSE
------------------
[{"noCompte":16,"typeCompte":"CompteC"},{"noCompte":9,"typeCompte":"CompteC"},{"noCompte":18,"typeCompte":"CompteC"},{"noCompte":11,"typeCompte":"CompteC"},{"noCompte":4,"typeCompte":"CompteC"},{"noCompte":2,"typeCompte":"CompteC"},{"noCompte":20,"typeCompte":"CompteE"},{"noCompte":6,"typeCompte":"CompteE"},{"noCompte":13,"typeCompte":"CompteE"}]



______________________________________________________________
ouvrir Compte
______________________________________________________________

URL : 
http://localhost:8080/TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-war/webresources/compte

methode : Post 

send type JSON 

CONTENT 
----------------

{

"idClient" : 1,
"solde": 30999,
"typeCompte": "CompteC"
}

REPONSE
------------------
success: true
##########

{"message":"Le compte epargne est ouvert avec succes","success":true}

OR

{"message":"Le compte courant est ouvert avec succes","success":true}

Success:false
#############
{"message":"echec d'ouverture du compte","success":false}



_____________________________________________________________
Virement 
______________________________________________________________

URL : 
http://localhost:8080/TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-war/webresources/compte/virement

methode : Post 

send type JSON 

CONTENT 
----------------
{
"idclient":2,
"idclientDestination":6,
"montant": 500
}


REPONSE
------------------
success: true
##########

{"message":"Virement effectuer avec succes","success":true}

Success:false
#############
{"message":"Echec de virement","success":false}


______________________________________________
Fermer un Compte 
______________________________________________

URL :
http://localhost:8080/TP_Final_JEE_GestionnaireDeCompteBancaires_Germain_Lescouflair_Suy-war/webresources/compte/{id}


methode : Delete 


send type Parameter

Paramter 
----------------
{id} : numero du compte




REPONSE
------------------
{
message: "fermeture du compte avec success"
success: true
}