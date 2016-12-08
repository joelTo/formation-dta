# formation-dta

* *Author* : TORIBIO Joël
* *Technologies* : Java 
* *Summary* : Projet Maven

## projet multi modules basé sur une bas de gestion de menu de pizzeria

Le projet est cindé en deux parties:
  * La première partie JoelT-pizzeria-parent:
    * un projet parent (pom.xml) qui mutualise de la configuration entre
les différents projets enfants(modules).
  * La deuxième partie séparé en trois sous projet maven:
    * un projet joelT-pizzeria-console contenant la partie ihm de l'application
    * un projet joelT-pizzeria-dao contenant la partie donnée
     * * Base de donnée : SGBD MySQL version{$5.x.x}
     * * Base de donnée : Fichier
     * * Base de donnée : Memoire vive 
    * un projet joelT-pizzeria-model contenant le modèle Pizza sur lequel l'application est basé.
 
 ## Bugs
    * Fragile au niveau de la creation des DOA--> Fichier --> Fonction Save 
    * Implementation de l'option -P (choix du dao)
 ## Developpers
 
* TORIBIO joël
