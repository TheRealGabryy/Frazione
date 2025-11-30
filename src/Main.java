import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);

    public static String inserisciFrazione() {
        System.out.println("Inserisci una frazione (esemio: 1/4, 1/6, 6/7 89/3)");
        String frazione;
        do {
            System.out.print("-> ");
            frazione = sc.nextLine();
            if (checkFrazione(frazione)) {
                System.out.println("Frazione non valida, reinserisci: ");
            }
        } while (checkFrazione(frazione));
        System.out.println("Frazione inserita correttamente.");
        return frazione;
    }

    public static String sommaFrazione(String frazione1, String frazione2) {
        String[] tokens1 = frazione1.split("/");
        String[] tokens2 = frazione2.split("/");
        int d1 = Integer.parseInt(tokens1[1]);
        int d2 = Integer.parseInt(tokens2[1]);
        int n1 = Integer.parseInt(tokens1[0]);
        int n2 = Integer.parseInt(tokens2[0]);
        int mcd = (d1 * d2) / mcm(d1, d2);
        int somma = (mcd / d1 * n1) + (mcd / d2 * n2);
        return somma + "/" + mcd;
    }

    public static double sommaFrazioneDec(String frazione1, String frazione2) {
        String risultato = sommaFrazione(frazione1, frazione2);
        String[] tokens = frazione1.split("/");
        double numeratore = Double.parseDouble(tokens[0]);
        double denominator = Double.parseDouble(tokens[1]);
        return numeratore / denominator;
    }

    public static void main(String[] args) {
        System.out.println("Esercizio Frazione");
        String frazione = inserisciFrazione();
        String frazione2 = inserisciFrazione();
        String risultato = sommaFrazione(frazione, frazione2);
        System.out.println("Frazione sommata: " + risultato);
        double decimale = sommaFrazioneDec(frazione, frazione2);
        System.out.println(String.format("Risultato in decimale: %.2f", decimale));

    }

    public static boolean checkFrazione(String frazione) {
        String[] tokens = frazione.split("/");
        if (tokens.length != 2) {
            return true;
        }
        if (tokens[1].equals("0")) {
            return true;
        }
        return false;
    }

    public static int mcm(int n1, int n2) {
        while (n2 != 0) {
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1;
    }
}
