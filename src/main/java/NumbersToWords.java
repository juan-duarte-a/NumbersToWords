import java.util.Scanner;

public class NumbersToWords {

    public static void main(String[] args) {
        long number = 0;
        String numberString;
        StringBuilder numberInWords = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        boolean valid = true;

        System.out.printf("%nIngresar un valor numérico positivo (hasta 10^18): ");
        numberString = sc.nextLine();

        if ((numberString.length() == 19 && !numberString.equals("1000000000000000000"))
                || numberString.length() > 19 || numberString.startsWith("-")) {
            valid = false;
        } else {
            try {
                number = Long.parseLong(numberString);
            } catch (NumberFormatException e) {
                valid = false;
            }
        }

        if (valid) {
            numberToWords(number, numberInWords);
            numberInWords.replace(0,1, numberInWords.substring(0, 1).toUpperCase());
            System.out.printf("%n" + numberInWords + "%n");
        } else {
            System.out.printf("%n¡Valor inválido!%n");
        }
    }

    public static void numberToWords(long number, StringBuilder numberInWords) {
        final String[] unidades = {
                "cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        final String[] decimos = {
                "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve"};
        final String[] vigesimos = {
                "veinte", "veintiuno", "veintidós", "veintitrés", "veinticuatro", "veinticinco", "veintiséis", "veintisiete",
                "veintiocho", "veintinueve"};
        final String[] decenas = {
                "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa", "cien"};
        final String[] centenas = {
                "", "cien", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos",
                "ochocientos", "novecientos"};

        if (numberInWords.length() > 0 && !numberInWords.toString().endsWith(" ")) {
            numberInWords.append(" ");
        }

        if (number < 10) {
            numberInWords.append(unidades[(int) number]);
        } else if (number < 20) {
            numberInWords.append(decimos[(int) (number % 10)]);
        } else if (number < 30) {
            numberInWords.append(vigesimos[(int) (number % 10)]);
        } else if (number <= 100) {
            numberInWords.append(decenas[(int) ((number / 10) - 3)]);
            if (number % 10 != 0) {
                numberInWords.append(" y");
                numberToWords(number % 10, numberInWords);
            }
        } else if (number < 200) {
            numberInWords.append("ciento");
            if (number % 100 != 0 ) {
                numberToWords(number % 100, numberInWords);
            }
        } else if (number < 1000) {
            numberInWords.append(centenas[(int) (number / 100)]);
            if (number % 100 != 0) {
                numberToWords(number % 100, numberInWords);
            }
        } else if (number < 2000) {
            numberInWords.append("mil");
            if (number % 1000 != 0) {
                numberToWords(number % 1000, numberInWords);
            }
        } else if (number < 1000_000) {
            numberToWords((int) (number / 1000), numberInWords);
            if (numberInWords.toString().endsWith("uno")) {
                numberInWords.delete(numberInWords.length() - 1, numberInWords.length());
            }
            numberInWords.append(" mil");
            if (number % 1000 != 0) {
                numberToWords(number % 1000, numberInWords);
            }
        } else if (number < 2000_000) {
            numberInWords.append("un millón");
            if (number % 1000_000 != 0) {
                numberToWords(number % 1000_000, numberInWords);
            }
        } else if (number < 1000_000_000_000L) {
            numberToWords((int) (number / 1000_000), numberInWords);
            if (numberInWords.toString().endsWith("uno")) {
                numberInWords.delete(numberInWords.length() - 1, numberInWords.length());
            }
            numberInWords.append(" millones");
            if (number % 1000_000 != 0) {
                numberToWords(number % 1000_000, numberInWords);
            }
        } else if (number < 2000_000_000_000L) {
            numberInWords.append("un billón");
            if (number % 1000_000_000_000L != 0) {
                numberToWords(number % 1000_000_000_000L, numberInWords);
            }
        } else if (number < 1000_000_000_000_000_000L) {
            numberToWords((int) (number / 1000_000_000_000L), numberInWords);
            if (numberInWords.toString().endsWith("uno")) {
                numberInWords.delete(numberInWords.length() - 1, numberInWords.length());
            }
            numberInWords.append(" billones");
            if (number % 1000_000_000_000L != 0) {
                numberToWords(number % 1000_000_000_000L, numberInWords);
            }
        } else if (number == 1000_000_000_000_000_000L) {
            numberInWords.append("un trillón");
        }
    }
}