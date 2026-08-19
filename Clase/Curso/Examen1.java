
public class Examen1 {
    public static void main(String[] args) {
        System.out.print("i=");
        for (int i = 0; i < 10; i++) {
            if (i==3)
            break;
            System.out.print(i);
        }

        int i = 0, j = 0;
        i = ++i;
        j = i++;
        System.out.println("\ni=" + i + " j=" + j);
    }
}