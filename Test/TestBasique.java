public class TestBasique {
    public static void main(String[] args) {
        int nb;
        double p;
        do {
            Ut.afficher("Donner le cardinal de E (> 0) : ");
            nb = Ut.saisirEntier();
        }
        while (nb <= 0);
        do {
            Ut.afficher("Donner la probabilité p (0 < p < 1) : ");
            p = Ut.saisirReel();
        }
        while (p < 0 || p > 1);
        RelationBinaire[] tab = new RelationBinaire[5];
        tab[0] = new RelationBinaire(nb, p);
        tab[0].afficheDivers();
    }
}