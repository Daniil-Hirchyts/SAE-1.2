public class RelationBinaire {

    // attributs
    //DERNIERE MODIF GH 16/12

    private int n;           // n > 0, E = {0,1,2, ..., n-1}
    private boolean[][] matAdj;  // matrice d'adjacence de R
    private int m;           // cardinal de R
    private EE[] tabSucc;    // tableau des ensembles de successeurs


    // constructeurs

    /**
     * TODO : RelationBinaire(int nb)
     * pré-requis : nb > 0
     * action : construit la relation binaire vide dans l'ensemble {0,1,2, ..., nb-1}
     */
    public RelationBinaire(int nb) {

    }

    //______________________________________________


    /**
     * TODO : RelationBinaire(int nb, double p)
     * pré-requis : nb > 0 et 0 <= p <= 1
     * action : construit une relation binaire aléatoire dans l'ensemble {0,1,2, ..., nb-1}
     * à laquelle chaque couple a la probabilité p d'appartenir.
     * En particulier, construit la relation vide si p = 0 et la relation pleine si p = 1.
     * Indication : Math.random() retourne un réel de type double aléatoire de l'intervalle [0,1[
     */
    public RelationBinaire(int nb, double p) {

    }

    //______________________________________________


    /**
     * TODO : RelationBinaire(int nb, boolean egal)
     * pré-requis : nb > 0
     * action : construit la relation binaire dans l'ensemble {0,1,2, ..., nb-1}
     * '=' si egal a la valeur vrai et '<=' sinon
     */
    public RelationBinaire(int nb, boolean egal) {

    }

    //______________________________________________


    /**
     * TODO : RelationBinaire(boolean[][] mat)
     * pré-requis : mat est une matrice carrée de dimension > 0
     * action : construit une relation binaire dont la matrice d'adjacence
     * est une copie de mat
     * //MODIF
     */
    public RelationBinaire(boolean[][] mat) {

    }

    //______________________________________________


    /**
     * TODO : RelationBinaire(EE[] tab)
     * pré-requis : tab.length > 0 et pour tout i, les éléments de tab[i]
     * sont compris entre 0 et tab.length-1
     * action : construit une relation binaire dont le tableau des ensembles de successeurs
     * est une copie de tab
     */
    public RelationBinaire(EE[] tab) {

    }

    //______________________________________________


    /**
     * TODO : RelationBinaire(RelationBinaire r)
     * pré-requis : aucun
     * action : construit une copie de r
     */
    public RelationBinaire(RelationBinaire r) {

    }


    //______________________________________________


    // méthodes

    /**
     * TODO : opBool(boolean[][] m1, boolean[][] m2, int numConnecteur)
     * pré-requis : m1 et m2 sont des matrices carrées de même dimension et 1 <= numConnecteur <= 5
     * résultat : la matrice obtenue en appliquant terme à terme le  connecteur de numéro numConnecteur
     * sur m1 si numConnecteur  = 3 (dans ce cas le paramètre m2 n'est pas utilisé),
     * et sur m1 et m2 dans cet ordre sinon, sachant que les connecteurs "ou","et","non",
     * "implique"et "equivalent" sont numérotés de 1 à 5 dans cet ordre
     */
    public static boolean[][] opBool(boolean[][] m1, boolean[][] m2, int numConnecteur) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");

    }

    //______________________________________________


    // A) Logique et calcul matriciel
    //-------------------------------

    /**
     * TODO : produit(boolean[][] m1, boolean[][] m2)
     * pré-requis : m1 et m2 sont des matrices carrées de même dimension
     * résultat : le produit matriciel de m1 et m2
     */
    public static boolean[][] produit(boolean[][] m1, boolean[][] m2) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : transposee(boolean[][] m)
     * pré-requis : m est une matrice carrée
     * résultat : la matrice transposée de m
     */
    public static boolean[][] transposee(boolean[][] m) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    public static void main(String[] args) {

        int nb;
        double p;
        do {
            Ut.afficher("\nDonner le cardinal de E (>0) : ");
            nb = Ut.saisirEntier();
        }
        while (nb <= 0);
    }

    //______________________________________________


    // B) Théorie des ensembles
    //--------------------------

    /**
     * TODO : toString()
     * pré-requis : aucun
     * résultat : une chaîne de caractères permettant d'afficher this par sa matrice d'adjacence
     * contenant des '0' et des '1' (plus lisibles que des 'V' et des 'F') et sa définition
     * en extension (ensemble de couples {(..,..),(..,..), ...})
     */
    public String toString() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : estVide()
     * pré-requis : aucun
     * résultat : vrai ssi this est vide
     */
    public boolean estVide() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : estPleine()
     * pré-requis : aucun
     * résultat : vrai ssi this est pleinee (contient tous les couples d'éléments de E)
     */
    public boolean estPleine() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : appartient(int x, int y)
     * pré-requis : aucun
     * résultat : vrai ssi (x,y) appartient à this
     */
    public boolean appartient(int x, int y) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : ajouteCouple(int x, int y)
     * pré-requis : 0 <= x < this.n et 0 <= y < this.n
     * résultat : ajoute (x,y) à this s'il n'y est pas déjà
     */
    public void ajouteCouple(int x, int y) {

    }

    //______________________________________________

    /**
     * TODO : enleveCouple(int x, int y)
     * pré-requis : 0 <= x < this.n et 0 <= y < this.n
     * résultat : enlève (x,y) de this s'il y est
     */
    public void enleveCouple(int x, int y) {

    }
    //______________________________________________

    /**
     * TODO : avecBoucles()
     * pré-requis : aucun
     * résultat : une nouvelle relation binaire obtenue à partir de this en ajoutant
     * les couples de la forme  (x,x) qui n'y sont pas déjà
     */
    public RelationBinaire avecBoucles() {

        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : sansBoucles()
     * pré-requis : aucun
     * résultat : une nouvelle relation binaire obtenue à partir de this en enlèvant
     * les couples de la forme  (x,x) qui y sont
     * //DERNIERE MODIF
     */
    public RelationBinaire sansBoucles() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : union(RelationBinaire r)
     * pré-requis : this.n = r.n
     * résultat : l'union de this et r
     */
    public RelationBinaire union(RelationBinaire r) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : intersection(RelationBinaire r)
     * pré-requis : this.n = r.n
     * résultat : l'intersection de this et r
     */
    public RelationBinaire intersection(RelationBinaire r) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : complementaire()
     * pré-requis : aucun
     * résultat : la relation complémentaire de this
     */
    public RelationBinaire complementaire() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : difference(RelationBinaire r)
     * pré-requis : this.n = r.n
     * résultat : la différence de this et r
     */
    public RelationBinaire difference(RelationBinaire r) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");

    }

    //______________________________________________

    /**
     * TODO : estIncluse(RelationBinaire r)
     * pré-requis : this.n = r.n
     * résultat : vrai ssi this est incluse dans r
     */
    public boolean estIncluse(RelationBinaire r) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________


    // C) Théorie des graphes orientés
    //---------------------------------

    /**
     * TODO : estEgale(RelationBinaire r)
     * pré-requis : this.n = r.n
     * résultat : vrai ssi this est égale à r
     */
    public boolean estEgale(RelationBinaire r) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : succ(int x)
     * pré-requis : 0 <= x < this.n
     * résultat : l'ensemble des successeurs de x dans this, "indépendant"
     * (c'est-à-dire dans une autre zône mémoire) de l'attribut this.tabSucc
     */
    public EE succ(int x) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________


    // D) Relation binaire
    //---------------------

    /**
     * TODO : pred(int x)
     * pré-requis : 0 <= x < this.n
     * résultat : l'ensemble des prédécesseurs de x dans this
     */
    public EE pred(int x) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : estReflexive()
     * pré-requis : aucun
     * résultat : vrai ssi this est réflexive
     */
    public boolean estReflexive() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : estAntireflexive()
     * pré-requis : aucun
     * résultat : vrai ssi this est antiréflexive
     */
    public boolean estAntireflexive() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : estSymetrique()
     * pré-requis : aucun
     * résultat : vrai ssi this est symétrique
     */
    public boolean estSymetrique() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : estAntisymetrique()
     * pré-requis : aucun
     * résultat : vrai ssi this est antisymétrique
     */
    public boolean estAntisymetrique() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : estTransitive()
     * pré-requis : aucun
     * résultat : vrai ssi this est transitive
     */
    public boolean estTransitive() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : estRelOrdre()
     * pré-requis : aucun
     * résultat : vrai ssi this est une relation d'ordre
     */
    public boolean estRelOrdre() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : hasse()
     * pré-requis : aucun
     * résultat : la relation binaire assiciée au diagramme de Hasse de this
     */
    public RelationBinaire hasse() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : ferTrans()
     * pré-requis : aucun
     * résultat : la fermeture transitive de this
     */
    public RelationBinaire ferTrans() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * TODO : afficheDivers()
     * pré-requis : aucun
     * action : affiche this sous 2 formes (matrice et ensemble de couples), puis affiche ses propriétés
     * (réflexive, ..., relation d'ordre) et les relations binaires suivantes obtenues à partir de this :
     * Hasse, fermeture transitive de Hasse et fermeture transitive de Hasse avec boucles (sous 2 formes aussi)
     */
    public void afficheDivers() {

    }
} // fin RelationBinaire