import java.util.Scanner;
public class AgeChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age;
        System.out.println("Enter your age: ");
        age = sc.nextInt();
        if (age >= 20) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are not an adult.");
        }

        System.out.print("i=");
        for (int i = 0; i < 10; i++) {
            if (i==3)
            break;
            System.out.print(i);
        }
    }
}
