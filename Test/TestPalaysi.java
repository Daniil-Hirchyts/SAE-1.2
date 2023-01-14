public class TestPalaysi {
    public static void main(String[] args) {
        test_2();
    }

    public static void test_2() {
        RelationBinaire rb = new RelationBinaire(4);
        rb.ajouteCouple(0, 0);
        rb.ajouteCouple(0, 1);
        System.out.println(rb);
    }

    public static void test_1() {
        EE[] tabVoisins = new EE[3];
        tabVoisins[0] = new EE("0 1 2", 3);
        tabVoisins[1] = new EE("0 1 2", 3);
        tabVoisins[2] = new EE("0 1 2", 3);
        RelationBinaire rb = new RelationBinaire(tabVoisins);
        rb.enleveCouple(2, 1);

        if (rb.appartient(0, 1) && rb.appartient(1, 2) && !rb.appartient(2, 1) && !rb.estPleine())
            System.out.println("Test 1 : OK");
        else
            System.out.println("Test 1 : KO");
        System.out.println(rb.appartient(0, 1));
        System.out.println(rb.appartient(1, 2));
        System.out.println(!rb.appartient(2, 1));
        System.out.println(!rb.estPleine());

    }
}
