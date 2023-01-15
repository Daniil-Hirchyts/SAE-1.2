import java.lang.reflect.Field;
import java.util.Arrays;

public class TestPalaysi {
    public static void main(String[] args) throws Exception {
        test_3();
    }

    public static void test_3() throws Exception {
        boolean[][] MA = {{true, true, true, false}, {false, false, true, false}, {true, false, false, false}, {false, false, false, false}};
        RelationBinaire A = new RelationBinaire(MA);
        RelationBinaire DA = new RelationBinaire(MA);// A et DA sont égales mais distinctes et devraient encore l'être à la fin du test (sauf si vous modifiez A lors de l'union)

        boolean[][] MB = {{true, true, false, true}, {false, false, true, true}, {true, true, true, false}, {true, false, true, true}};
        RelationBinaire B = new RelationBinaire(MB);
        RelationBinaire DB = new RelationBinaire(MB);// B et DB sont égales mais distinctes et devraient encolre l'être à la fin du test (sauf si vous modifiez B lors de l'union)

        boolean[][] MC = {{true, true, true, true}, {false, false, true, true}, {true, true, true, false}, {true, false, true, true}};
        RelationBinaire C = new RelationBinaire(MC);// C représente ce que devrait retourner la méthode union

        RelationBinaire UAB = A.union(B);

//        System.out.println("(C, UAB)" + égalesMaisDistinctes(C, UAB) + "\n");
//        System.out.println("(A, DA)" + égalesMaisDistinctes(A, DA) + "\n");
//        System.out.println("(B, DB)" + égalesMaisDistinctes(B, DB) + "\n");

        if (égalesMaisDistinctes(C, UAB) && égalesMaisDistinctes(A, DA) && égalesMaisDistinctes(B, DB))
            System.out.println("Test réussi");
        else
            System.out.println("Test échoué");
    }

    public static boolean égalesMaisDistinctes(RelationBinaire A, RelationBinaire B) throws Exception {
        Class<RelationBinaire> metadata = RelationBinaire.class;

        // vérif n
        Field n = metadata.getDeclaredField("n");
        n.setAccessible(true);
        boolean nEstOK = (n.getInt(A) == n.getInt(B));

        if (!nEstOK) {
            return false;
        } else {
//            System.out.println("n est OK");
            // vérif tabSucc
            Field tabSucc = metadata.getDeclaredField("tabSucc");
            tabSucc.setAccessible(true);
            EE[] tabSuccA = (EE[]) tabSucc.get(A);
            EE[] tabSuccB = (EE[]) tabSucc.get(B);
            int i = 0;
            boolean tabsSuccsOK = true;
            while (tabsSuccsOK && i < n.getInt(A)) {
                tabsSuccsOK = (tabSuccA[i].estEgal(tabSuccB[i]) && tabSuccA[i] != tabSuccB[i]);
                i++;
            }
            if (tabsSuccsOK) System.out.println("tabSucc est OK");
            else System.out.println("tabSucc est KO");

            // vérif matAdj
            Field matAdj = metadata.getDeclaredField("matAdj");
            matAdj.setAccessible(true);
            boolean[][] matAdjA = (boolean[][]) matAdj.get(A);
            boolean[][] matAdjB = (boolean[][]) matAdj.get(B);
            boolean matAdjOK = Arrays.deepEquals(matAdjA, matAdjB) && matAdjA != matAdjB;

            if (matAdjOK) System.out.println("matAdj est OK");
            else System.out.println("matAdj est KO");

            if (tabsSuccsOK && matAdjOK)
                return true;
            else
                return false;
        }
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
