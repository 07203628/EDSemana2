import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        OSManagement os = new OSManagement();
        LinkedList<String> list = new LinkedList<>(1);
        DateTimeFormatter timestampFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String option;
        do {
            clearTerminal();
            System.out.println("echo - Create a text file");
            System.out.println("peek - View the last added text");
            System.out.println("remove - Remove text file");
            System.out.println("pop - Remove the last added text file");
            System.out.println("dequeue - Remove the first added text file");
            System.out.println("ls - List all saved text files");
            System.out.println("log - Show command history");
            System.out.println("exit - Exit the program");

            System.out.print("\n> ");
            String input = sc.nextLine();
            String trimmedInput = input.trim();
            String[] commandParts = trimmedInput.split("\\s+", 2);
            option = commandParts[0];
            String fileName = commandParts.length > 1 ? commandParts[1].trim() : "";

            String timestamp = LocalDateTime.now().format(timestampFormat);
            os.addCommand("[" + timestamp + "] " + input);

            switch (option) {
                case "echo":
                    System.out.print("Enter a title: ");
                    String title = sc.nextLine().trim();
                    System.out.print("Enter text to add: ");
                    String textToAdd = sc.nextLine();
                    if (!isValidTitle(title)) {
                        System.out.println("Invalid title. Use letters and numbers only.");
                    } else {
                        list.add(title + ".txt - " + textToAdd);
                        System.out.println("Text saved as " + title + ".txt.");
                    }
                    break;
                case "remove":
                    removeText(fileName, list);
                    break;
                case "pop":
                    removeLastText(list);
                    break;
                case "dequeue":
                    removeFirstText(list);
                    break;
                case "peek":
                    peekText(fileName, list);
                    waitForEnter(sc);
                    break;
                case "ls":
                    listFiles(list);
                    waitForEnter(sc);
                    break;
                case "log":
                    String log = os.showCommandHistory();
                    if (!log.isEmpty()) {
                        System.out.println(log);
                    } else {
                        System.out.println("No commands used.");
                    }
                    waitForEnter(sc);
                    break;
                case "exit":
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (!"exit".equals(option));
    }

    private static boolean isValidTitle(String title) {
        return title.matches("[A-Za-z0-9]+");
    }

    private static String normalizeFileName(String fileName) {
        if (fileName.toLowerCase().endsWith(".txt")) {
            return fileName.substring(0, fileName.length() - 4) + ".txt";
        }
        return fileName + ".txt";
    }

    private static int findTextIndex(String fileName, LinkedList<String> list) {
        String normalizedName = normalizeFileName(fileName);
        for (int i = 0; i < list.getSize(); i++) {
            if (list.get(i).startsWith(normalizedName + " - ")) {
                return i;
            }
        }
        return -1;
    }

    private static void listFiles(LinkedList<String> list) {
        if (list.isEmpty()) {
            System.out.println("No text files saved.");
            return;
        }

        for (int i = 0; i < list.getSize(); i++) {
            String savedText = list.get(i);
            System.out.println(savedText.substring(0, savedText.indexOf(" - ")));
        }
    }

    private static void peekText(String fileName, LinkedList<String> list) {
        if (list.isEmpty()) {
            System.out.println("No saved text.");
            return;
        }

        if (fileName.isEmpty()) {
            System.out.println("A filename is required. Use: peek <name.txt>");
            return;
        }

        int index = findTextIndex(fileName, list);
        if (index >= 0) {
            String savedText = list.get(index);
            System.out.println(savedText.substring(savedText.indexOf(" - ") + 3));
        } else {
            System.out.println("File not found: " + normalizeFileName(fileName));
        }
    }

    private static void removeText(String fileName, LinkedList<String> list) {
        if (list.isEmpty()) {
            System.out.println("No text to remove.");
            return;
        }

        if (fileName.isEmpty()) {
            System.out.println("A filename is required. Use: remove <name.txt>");
            return;
        }

        int index = findTextIndex(fileName, list);
        if (index >= 0) {
            System.out.println("Removed text: " + list.removeAt(index));
        } else {
            System.out.println("File not found: " + normalizeFileName(fileName));
        }
    }

    private static void removeLastText(LinkedList<String> list) {
        String removedText = list.pop();
        if (removedText == null) {
            System.out.println("No text to pop.");
        } else {
            System.out.println("Popped text: " + removedText);
        }
    }

    private static void removeFirstText(LinkedList<String> list) {
        String removedText = list.dequeue();
        if (removedText == null) {
            System.out.println("No text to dequeue.");
        } else {
            System.out.println("Dequeued text: " + removedText);
        }
    }

    private static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void waitForEnter(Scanner sc) {
        System.out.print("\nPress Enter to return to the menu...");
        sc.nextLine();
    }
}
