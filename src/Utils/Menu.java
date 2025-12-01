package Utils;

public class Menu {
    public static void printMenu(String title, String[] options) {
        String line = "=====================";
        System.out.println(line);
        System.out.println(title);
        System.out.println(line);
        for (int i = 0; i < options.length; i++) {
            System.out.println("[" + (i+1) + "]" +   options[i]);
        }
        System.out.println(line);
        System.out.print("Enter your option: ");
    }
}
