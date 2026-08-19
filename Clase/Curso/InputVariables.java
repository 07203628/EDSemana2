import java.util.Scanner;
public class InputVariables {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean boolVal;
        byte byteVal;
        char charVal;
        short shortVal;
        int intVal;
        long longVal;
        float floatVal;
        double doubleVal;

        System.out.println("Enter a boolean value (true/false): ");
        boolVal = sc.nextBoolean();
        System.out.println("Enter a byte value: ");
        byteVal = sc.nextByte();
        System.out.println("Enter a char value: ");
        charVal = sc.next().charAt(0);
        System.out.println("Enter a short value: ");
        shortVal = sc.nextShort();
        System.out.println("Enter an int value: ");
        intVal = sc.nextInt();
        System.out.println("Enter a long value: ");
        longVal = sc.nextLong();
        System.out.println("Enter a float value: ");
        floatVal = sc.nextFloat();
        System.out.println("Enter a double value: ");
        doubleVal = sc.nextDouble();

        System.out.println("You entered the following values:");
        System.out.println("Boolean: " + boolVal);
        System.out.println("Byte: " + byteVal);
        System.out.println("Char: " + charVal);
        System.out.println("Short: " + shortVal);
        System.out.println("Int: " + intVal);
        System.out.println("Long: " + longVal);
        System.out.println("Float: " + floatVal);
        System.out.println("Double: " + doubleVal);
    }

}
