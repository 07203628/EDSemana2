

public class StringOperations {
    String str1 = "Hello";
    String str2 = "Diego";
    String str3 = "You are" + str2;

    public static void main(String[] args) {
        StringOperations app = new StringOperations();
        System.out.println("Welcome, " + app.str3);
        System.out.println("Length: " + app.str1.length());
        System.out.println("Sub:" + app.str3.substring(0, 5));
        System.out.println("Upper: " + app.str2.toUpperCase());
        System.out.println(app.str1.compareTo(app.str2));
        System.out.println(app.str1.equals(app.str2));
    }
}