import Utils.Menu;

import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static final String[] opzioni = {
            "Inserisci frazioni",
            "Calcola somma",
            "Calcola sottrazione",
            "Calcola Moltiplicazione",
            "Calcola Divisione",
            "Calcola tutto",
            "Fine"

    };
    //creo le frazioni
    public static final String frazione1 = inserisciFrazione();
    public static final String frazione2 = inserisciFrazione();
    public static String sommaFrazioni;
    public static String sottrazioneFrazione;
    public static double sommaFrazioneDec;
    public static double sottrazioneFrazioneDec;

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

    public static double calcoloFrazioneDec(String risultato) {
        String[] tokens = risultato.split("/");
        double numeratore = Double.parseDouble(tokens[0]);
        double denominator = Double.parseDouble(tokens[1]);
        return numeratore / denominator;
    }

    public static String sottrazioneFrazione(String frazione1, String frazione2) {
        String[] tokens1 = frazione1.split("/");
        String[] tokens2 = frazione2.split("/");
        int d1 = Integer.parseInt(tokens1[1]);
        int d2 = Integer.parseInt(tokens2[1]);
        int n1 = Integer.parseInt(tokens1[0]);
        int n2 = Integer.parseInt(tokens2[0]);
        int mcd = (d1 * d2) / mcm(d1, d2);
        int sottrazione = (mcd / d1 * n1) - (mcd / d2 * n2);
        return sottrazione + "/" + mcd;
    }

    public static void main(String[] args) {
        System.out.println("Esercizio Frazione");
        boolean fine = false;
        int choice;
        do {
            Menu.printMenu("Menu Frazione", opzioni);
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Errore nella lettura della scelta.");
                sc.nextLine();
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.println("Inserisci una frazione");
                    String frazione3 = inserisciFrazione();
                    break;
                case 2:
                    System.out.println("Calcolo Somma");
                    sommaFrazioni = sommaFrazione(frazione1, frazione2);
                    System.out.println("Somma delle 2 Frazioni: " + sommaFrazioni);
                    sommaFrazioneDec = calcoloFrazioneDec(sommaFrazioni);
                    break;
                case 3:
                    System.out.println("Calcola Sottrazione");
                    sottrazioneFrazione = sottrazioneFrazione(frazione1, frazione2);
                    System.out.println("Sottrazione delle frazioni: " + sottrazioneFrazione);
                    sottrazioneFrazioneDec = calcoloFrazioneDec(sottrazioneFrazione);
                    break;
                case 4:
                    System.out.println("Calcola Moltiplicazione");
                    break;
                case 5:
                    System.out.println("Calcola Divisione");
                    break;
                case 6:
                    System.out.println("Calcola Tutto");
                    break;
                case 7:
                    System.out.println("Fine programmma");
                    fine = true;
                    break;
                default:
                    System.out.println("Errore nella lettura della scelta. hai inserito una scelta non valida.");
                    break;

            }
        } while (!fine);

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
