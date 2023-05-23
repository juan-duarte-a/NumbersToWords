import java.util.Scanner;

public class NumbersToWords {
    private static final String[] unidades = {
            "cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
    private static final String[] decimos = {
            "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve"};
    private static final String[] vigesimos = {
            "veinte", "veintiuno", "veintidós", "veintitrés", "veinticuatro", "veinticinco", "veintiséis", "veintisiete",
            "veintiocho", "veintinueve"};
    private static final String[] decenas = {
            "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa", "cien"};
    private static final String[] centenas = {
            "", "cien", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos",
            "ochocientos", "novecientos"};

    public static void main(String[] args) {
        long number;
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresar un valor numérico: ");
        number = sc.nextLong();

        System.out.println(numberToWords(number));
    }

    public static String numberToWords(long number) {
        String numberInWords = "";

        if (number < 10) {
            numberInWords = unidades[(int) number];
        } else if (number < 20) {
            numberInWords = decimos[(int) (number % 10)];
        } else if (number < 30) {
            numberInWords = vigesimos[(int) (number % 10)];
        } else if (number <= 100) {
            numberInWords += decenas[(int) ((number / 10) - 3)] + (number % 10 != 0 ? " y " + numberToWords(number % 10) : "");
        } else if (number < 200) {
            numberInWords += "ciento " + (number % 100 != 0 ? numberToWords(number % 100) : "");
        } else if (number < 1000) {
            numberInWords += centenas[(int) (number / 100)] + (number % 100 != 0 ? " " + numberToWords(number % 100) : "");
        } else if (number < 2000) {
            numberInWords += "mil" + (number % 1000 != 0 ? " " + numberToWords(number % 1000) : "");
        } else if (number < 1000000) {
            numberInWords += numberToWords((int) (number / 1000)) + " mil " + (number % 1000 != 0 ? numberToWords(number % 1000) : "");
        }

        return numberInWords;
    }
}
