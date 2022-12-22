# SAE-1.2

SAE 1.2 Comparaison d'approches algorithmiques



------------------------------------------------------------------------------------------------------------------------------
Bonsoir,

Une nouvelle erreur a été détectée et signalée par un étudiant : dans le 3ème constructeur de la classe RelationBinaire, le pré-requis   1 <= choix <= 3 est à supprimer !

Ce pré-requis date d'une version antérieure du programme où il y avait à la place du paramètre booléen egal un paramètre entier choix pouvant avoir les valeurs 1, 2 et 3.

Cette erreur est corrigée sur Moodle.

Bonne soirée,

l'équipe de la SAE 1.02. 

------------------------------------------------------------------------------------------------------------------------------
Bonsoir,

Quelques corrections ont été apportées aux fichiers suivants déposés sur Moodle pour la SAE1.02 :



- le fichier de consignes (le sujet)  

une seule correction,: en bas de la page 4, le coefficient central de la matrice A*B, initialement égal à 0, a retrouvé sa bonne valeur 1



- le fichier RelationBinaire.java

quelques corrections de détail, dont la dernière est l'ajout de la ligne :

throw new RuntimeException("La fonction n'est pas encore implémentée !");

comme code des méthodes retournant une valeur (non "void") pour vous permettre de compiler un fichier incomplet.

 Donc, si le fichier que vous avez téléchargé contient ces lignes, c'est que vous avez bien la dernière version !



- le fichier EE.class

il a été remplacé par EE.java



Si d'autres corrections sont effectuées, on vous préviendra par mail.

Si vous-mêmes détectez une erreur, merci de la signaler à votre enseignant de TD ou à moi pour qu'elle soit corrigée sur Moodle.

Bon travail sur la SAE1.02, bonnes vacances et bonnes fêtes de fin d'année,



l'équipe de la SAE 1.02.
------------------------------------------------------------------------------------------------------------------------------

### Mail MJ :

Bonjour à tous,

Les consignes pour la SAE 1.02 ont été mises sous le moodle de l'ENT** **
(Informatique/SAE 1.02).

Il y a aussi les squelettes de code RelationBinaire.java,** **
MainRelationBinaire.java, le fichier EE.class et le fichier Ut.java.

Le fichier EE.java sera fourni plus tard: il contiendra les méthodes du** **
TD8 et la méthode suivante :

public int retraitUnElt() {
     // Pre-requis : ensemble this est non vide
     // Action/resultat : enleve un element de this (le dernier, par** **
commodite)
//                   et le retourne
this.cardinal--;
return this.ensTab[this.cardinal];
}

Vous devez vous mettre par groupes de 2 étudiants. Il faudra rendre ce** **
travail le dimanche 15 janvier à 23h59.

Pour le rendu, les consignes seront similaires à celles de la SAE1.01 et** **
vous seront communiquées ultérieurement.

Des tests automatiques publics vous seront aussi communiqués ultérieurement.

Cordialement,

l'équipe de la SAE 1.02.

(bon travail et bonnes vacances quand-même)
