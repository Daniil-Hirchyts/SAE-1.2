public class TestExtension4 {
    public static void main(String[] args) {
        System.out.println("TestExtension4");
        test_1();
    }

    public static void test_1() {
        if (RelationBinaire.booleanverifCNordre(100, 10)) System.out.println("OK");
        else System.out.println("KO");
    }
}
