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
        this.n = nb;
        this.matAdj = new boolean[nb][nb];
        this.m = 0;
        this.tabSucc = new EE[nb];
        for (int i = 0; i < nb; i++) {
            this.tabSucc[i] = new EE(nb);
        }
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
        this(nb);
        for (int i = 0; i < nb; i++) {
            for (int j = 0; j < nb; j++) {
                if (Math.random() <= p) {
                    this.ajout(i, j);
                }
            }
        }
    }

    private void ajout(int i, int j) {
        if (!this.matAdj[i][j]) {
            this.matAdj[i][j] = true;
            this.tabSucc[i].ajoutPratique(j);
            this.m++;
        }
    }

    //______________________________________________


    /**
     * TODO : RelationBinaire(int nb, boolean egal)
     * pré-requis : nb > 0
     * action : construit la relation binaire dans l'ensemble {0,1,2, ..., nb-1}
     * '=' si egal a la valeur vrai et '<=' sinon
     */
    public RelationBinaire(int nb, boolean egal) {
        this(nb);
        if (egal) {
            for (int i = 0; i < nb; i++) {
                for (int j = i; j < nb; j++) {
                    this.ajout(i, j);
                }
            }
        } else {
            for (int i = 0; i < nb; i++) {
                for (int j = 0; j <= i; j++) {
                    this.ajout(i, j);
                }
            }
        }
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
        this(mat.length);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j]) {
                    this.ajout(i, j);
                }
            }
        }
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
        this(tab.length);
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (tab[i].contient(j)) {
                    this.ajout(i, j);
                }
            }
        }

    }

    //______________________________________________


    /**
     * TODO : RelationBinaire(RelationBinaire r)
     * pré-requis : aucun
     * action : construit une copie de r
     */
    public RelationBinaire(RelationBinaire r) {
        this(r.n);
        for (int i = 0; i < r.n; i++) {
            for (int j = 0; j < r.n; j++) {
                if (r.matAdj[i][j]) {
                    this.ajout(i, j);
                }
            }
        }

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
        boolean[][] res = new boolean[m1.length][m1.length];
        switch (numConnecteur) {
            case 1 -> {
                for (int i = 0; i < m1.length; i++) {
                    for (int j = 0; j < m1.length; j++) {
                        res[i][j] = m1[i][j] || m2[i][j];
                    }
                }
            }
            case 2 -> {
                for (int i = 0; i < m1.length; i++) {
                    for (int j = 0; j < m1.length; j++) {
                        res[i][j] = m1[i][j] && m2[i][j];
                    }
                }
            }
            case 3 -> {
                for (int i = 0; i < m1.length; i++) {
                    for (int j = 0; j < m1.length; j++) {
                        res[i][j] = !m1[i][j];
                    }
                }
            }
            case 4 -> {
                for (int i = 0; i < m1.length; i++) {
                    for (int j = 0; j < m1.length; j++) {
                        res[i][j] = !m1[i][j] || m2[i][j];
                    }
                }
            }
            case 5 -> {
                for (int i = 0; i < m1.length; i++) {
                    for (int j = 0; j < m1.length; j++) {
                        res[i][j] = m1[i][j] == m2[i][j];
                    }
                }
            }
        }
        return res;
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
        boolean[][] res = new boolean[m1.length][m1.length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1.length; j++) {
                for (int k = 0; k < m1.length; k++) {
                    res[i][j] = res[i][j] || (m1[i][k] && m2[k][j]);
                }
            }
        }
        return res;
    }

    //______________________________________________

    /**
     * TODO : transposee(boolean[][] m)
     * pré-requis : m est une matrice carrée
     * résultat : la matrice transposée de m
     */
    public static boolean[][] transposee(boolean[][] m) {
        boolean[][] res = new boolean[m.length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                res[i][j] = m[j][i];
            }
        }
        return res;
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
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matAdj[i][j]) {
                    res += "1 ";
                } else {
                    res += "0 ";
                }
            }
            res += "\n";
        }
        res += "\n";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matAdj[i][j]) {
                    res += "(" + i + "," + j + ")";
                }
            }
        }
        return res;
    }

    //______________________________________________

    /**
     * TODO : estVide()
     * pré-requis : aucun
     * résultat : vrai ssi this est vide
     */
    public boolean estVide() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matAdj[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    //______________________________________________

    /**
     * TODO : estPleine()
     * pré-requis : aucun
     * résultat : vrai ssi this est pleinee (contient tous les couples d'éléments de E)
     */
    public boolean estPleine() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!matAdj[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    //______________________________________________

    /**
     * TODO : appartient(int x, int y)
     * pré-requis : aucun
     * résultat : vrai ssi (x,y) appartient à this
     */
    public boolean appartient(int x, int y) {
        return matAdj[x][y];
    }

    //______________________________________________

    /**
     * TODO : ajouteCouple(int x, int y)
     * pré-requis : 0 <= x < this.n et 0 <= y < this.n
     * résultat : ajoute (x,y) à this s'il n'y est pas déjà
     */
    public void ajouteCouple(int x, int y) {
        matAdj[x][y] = true;
    }

    //______________________________________________

    /**
     * TODO : enleveCouple(int x, int y)
     * pré-requis : 0 <= x < this.n et 0 <= y < this.n
     * résultat : enlève (x,y) de this s'il y est
     */
    public void enleveCouple(int x, int y) {
        matAdj[x][y] = false;
    }
    //______________________________________________

    /**
     * TODO : avecBoucles()
     * pré-requis : aucun
     * résultat : une nouvelle relation binaire obtenue à partir de this en ajoutant
     * les couples de la forme  (x,x) qui n'y sont pas déjà
     */
    public RelationBinaire avecBoucles() {
        RelationBinaire res = new RelationBinaire(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matAdj[i][j]) {
                    res.matAdj[i][j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            res.matAdj[i][i] = true;
        }
        return res;
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
        RelationBinaire res = new RelationBinaire(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matAdj[i][j]) {
                    res.matAdj[i][j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            res.matAdj[i][i] = false;
        }
        return res;
    }

    //______________________________________________

    /**
     * TODO : union(RelationBinaire r)
     * pré-requis : this.n = r.n
     * résultat : l'union de this et r
     */
    public RelationBinaire union(RelationBinaire r) {
        RelationBinaire res = new RelationBinaire(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matAdj[i][j] || r.matAdj[i][j]) {
                    res.matAdj[i][j] = true;
                }
            }
        }
        return res;
    }

    //______________________________________________

    /**
     * TODO : intersection(RelationBinaire r)
     * pré-requis : this.n = r.n
     * résultat : l'intersection de this et r
     */
    public RelationBinaire intersection(RelationBinaire r) {
        RelationBinaire res = new RelationBinaire(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matAdj[i][j] && r.matAdj[i][j]) {
                    res.matAdj[i][j] = true;
                }
            }
        }
        return res;
    }

    //______________________________________________

    /**
     * TODO : complementaire()
     * pré-requis : aucun
     * résultat : la relation complémentaire de this
     */
    public RelationBinaire complementaire() {
        RelationBinaire res = new RelationBinaire(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!matAdj[i][j]) {
                    res.matAdj[i][j] = true;
                }
            }
        }
        return res;
    }

    //______________________________________________

    /**
     * TODO : difference(RelationBinaire r)
     * pré-requis : this.n = r.n
     * résultat : la différence de this et r
     */
    public RelationBinaire difference(RelationBinaire r) {
        RelationBinaire res = new RelationBinaire(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matAdj[i][j] && !r.matAdj[i][j]) {
                    res.matAdj[i][j] = true;
                }
            }
        }
        return res;
    }

    //______________________________________________

    /**
     * TODO : estIncluse(RelationBinaire r)
     * pré-requis : this.n = r.n
     * résultat : vrai ssi this est incluse dans r
     */
    public boolean estIncluse(RelationBinaire r) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matAdj[i][j] && !r.matAdj[i][j]) {
                    return false;
                }
            }
        }
        return true;
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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matAdj[i][j] != r.matAdj[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    //______________________________________________

    /**
     * TODO : succ(int x)
     * pré-requis : 0 <= x < this.n
     * résultat : l'ensemble des successeurs de x dans this, "indépendant"
     * (c'est-à-dire dans une autre zône mémoire) de l'attribut this.tabSucc
     */
    public EE succ(int x) {
        EE res = new EE(n);
        for (int i = 0; i < n; i++) {
            if (matAdj[x][i]) {
                res.ajoutElt(i);
            }
        }
        return res;
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
        EE res = new EE(n);
        for (int i = 0; i < n; i++) {
            if (matAdj[i][x]) {
                res.ajoutElt(i);
            }
        }
        return res;
    }

    //______________________________________________

    /**
     * TODO : estReflexive()
     * pré-requis : aucun
     * résultat : vrai ssi this est réflexive
     */
    public boolean estReflexive() {
        for (int i = 0; i < n; i++) {
            if (!matAdj[i][i]) {
                return false;
            }
        }
        return true;
    }

    //______________________________________________

    /**
     * TODO : estAntireflexive()
     * pré-requis : aucun
     * résultat : vrai ssi this est antiréflexive
     */
    public boolean estAntireflexive() {
        for (int i = 0; i < n; i++) {
            if (matAdj[i][i]) {
                return false;
            }
        }
        return true;
    }

    //______________________________________________

    /**
     * TODO : estSymetrique()
     * pré-requis : aucun
     * résultat : vrai ssi this est symétrique
     */
    public boolean estSymetrique() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matAdj[i][j] != matAdj[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    //______________________________________________

    /**
     * TODO : estAntisymetrique()
     * pré-requis : aucun
     * résultat : vrai ssi this est antisymétrique
     */
    public boolean estAntisymetrique() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matAdj[i][j] && matAdj[j][i] && i != j) {
                    return false;
                }
            }
        }
        return true;
    }

    //______________________________________________

    /**
     * TODO : estTransitive()
     * pré-requis : aucun
     * résultat : vrai ssi this est transitive
     */
    public boolean estTransitive() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matAdj[i][j]) {
                    for (int k = 0; k < n; k++) {
                        if (matAdj[j][k] && !matAdj[i][k]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    //______________________________________________

    /**
     * TODO : estRelOrdre()
     * pré-requis : aucun
     * résultat : vrai ssi this est une relation d'ordre
     */
    public boolean estRelOrdre() {
        return estReflexive() && estTransitive();
    }

    //______________________________________________

    /**
     * TODO : hasse()
     * pré-requis : aucun
     * résultat : la relation binaire assiciée au diagramme de Hasse de this
     */
    public RelationBinaire hasse() {
        RelationBinaire res = new RelationBinaire(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matAdj[i][j]) {
                    for (int k = 0; k < n; k++) {
                        if (matAdj[j][k]) {
                            res.matAdj[i][k] = true;
                        }
                    }
                }
            }
        }
        return res;
    }

    //______________________________________________

    /**
     * TODO : ferTrans()
     * pré-requis : aucun
     * résultat : la fermeture transitive de this
     */
    public RelationBinaire ferTrans() {
        RelationBinaire res = new RelationBinaire(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matAdj[i][j]) {
                    res.matAdj[i][j] = true;
                    for (int k = 0; k < n; k++) {
                        if (matAdj[j][k]) {
                            res.matAdj[i][k] = true;
                        }
                    }
                }
            }
        }
        return res;
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
        System.out.println("Matrice d'adjacence :");
//        --
        System.out.println("Ensemble de couples :");
//        --
        System.out.println("Reflexive ? " + estReflexive());
        System.out.println("Antireflexive ? " + estAntireflexive());
        System.out.println("Symétrique ? " + estSymetrique());
        System.out.println("Antisymétrique ? " + estAntisymetrique());
        System.out.println("Transitive ? " + estTransitive());
        System.out.println("Relation d'ordre ? " + estRelOrdre());
        System.out.println("Diagramme de Hasse :");
//        hasse().
        System.out.println("Fermeture transitive de Hasse :");
//        hasse().ferTrans().
        System.out.println("Fermeture transitive de Hasse avec boucles :");
//        hasse().ferTrans().ferTrans().
    }
} // fin RelationBinaire