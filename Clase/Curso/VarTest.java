public class VarTest {
    int iNum;
    char cVal;
    boolean bVal;

    public VarTest() {
        iNum = 25;
        cVal = 'B';
        bVal = true;
    }

    public static void main(String[] args) {
        VarTest test = new VarTest();
        System.out.println("iNum = " + test.iNum);
        System.out.println("cVal = " + test.cVal);
        System.out.println("bVal = " + test.bVal);
    }
}