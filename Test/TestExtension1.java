public class TestExtension1 {
    public static void main(String[] args) {
        test_descendants();

    }

    public static void test_descendants() {
        RelationBinaire r = new RelationBinaire(5);
        r.ajouteCouple(0, 1);
        r.ajouteCouple(0, 2);
        r.ajouteCouple(1, 3);
        r.ajouteCouple(2, 3);
        r.ajouteCouple(3, 4);
        r.ajouteCouple(4, 0);
        r.ajouteCouple(4, 1);
        r.ajouteCouple(4, 2);
        r.ajouteCouple(1, 1);
        r.ajouteCouple(2, 2);
        System.out.println(r);
        System.out.println(r.descendants(0));
        System.out.println(r.descendants(1));
        System.out.println(r.descendants(2));
        System.out.println(r.descendants(3));
        System.out.println(r.descendants(4));
//        if (r.descendants(0).equals(new EE("1 2 3 4", 5)))
//            System.out.println("Test descendants : OK");
//        else
//            System.out.println("Test descendants : KO");
    }
}
