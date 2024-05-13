import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


class Main {
    static String[] rim = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static String calc(String input) throws Exception {

        String[] massivstring = input.split(" ");

        String a = massivstring[0];
        String b = massivstring[2];
        if (massivstring.length > 3) {
            throw new Exception("Введен не верный формат математической операции");
        }
        List<String> Colekci9RimChisel = Arrays.asList(rim);

        if (Colekci9RimChisel.contains(a) && Colekci9RimChisel.contains(b)) {
            int itog = operation(rimToArab(a), massivstring[1], rimToArab(b));
            String itogString = arabToRim(itog);
            System.out.println("Ответ РИМ: " + itogString);
            if (itogString.equals("")) {
                throw new Exception("Результат меньше единицы");
            }
            return itogString;

        } else if (Colekci9RimChisel.contains(a) && !Colekci9RimChisel.contains(b)) {
            throw new Exception("Введено римское и арабское число");
        } else if (!Colekci9RimChisel.contains(a) && Colekci9RimChisel.contains(b)) {
            throw new Exception("Введено арабское и римсое число");

        } else if (Integer.parseInt(a) < -10 || Integer.parseInt(a) > 10 || Integer.parseInt(b) < -10 || Integer.parseInt(b) > 10) {
            throw new Exception("Введеное число превышает заданный интервал");
        } else {
            int itog = operation(Integer.parseInt(a), massivstring[1], Integer.parseInt(b));
            System.out.println("Ответ ARAB: " + itog);
            return String.valueOf(itog);
        }
    }

    static int rimToArab(String s) throws Exception {
        for (int i = 1; i < rim.length; i++) {
            if (s.equals(rim[i])) {
                return i;
            }
        }
        return 0;
    }

    static String arabToRim(int s) throws Exception {
        String tt = rim[s];
        return tt;
    }

    static int operation(int a, String znak, int b) throws Exception {
        return switch (znak) {
            case "+" -> (a + b);
            case "-" -> (a - b);
            case "/" -> (a / b);
            case "*" -> (a * b);
            default -> 0;
        };
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите математическую операцию");
        String OOO = scan.nextLine();
        calc(OOO);
    }
}




