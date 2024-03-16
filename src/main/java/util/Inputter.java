package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Inputter {

    public static Scanner sc = new Scanner(System.in);

    public static int getInt(String name) {
        int x;
        while (true) {
            System.out.println("Enter " + name + ": ");
            String s = sc.next();
            sc.nextLine();
            if (Validation.isNumericInt(s)) {
                x = Integer.parseInt(s);
                if (x > 0) {
                    break;
                }
            }
            System.out.println("Invalid, Enter again!");
        }
        return x;
    }

    public static double getDouble(String name) {
        double x;
        while (true) {
            System.out.println("Enter " + name + ": ");
            String s = sc.next();
            sc.nextLine();
            if (Validation.isNumericDouble(s)) {
                x = Double.parseDouble(s);
                if (x > 0) {
                    break;
                }
            }
            System.out.println("Invalid, Enter again");
        }
        return x;
    }

    public static String getString(String name) {
        String x;
        while (true) {
            System.out.println("Enter " + name + ": ");
            x = sc.nextLine();
            if (!x.trim().isEmpty()) {
                break;
            }
            System.out.println("Invalid, Enter again");
        }
        return x;
    }

    public static Date getDate(String name, String format) {
        Date dob = null;
        String s;
        System.out.println("Enter " + name + ": ");
        while (true) {
            s = sc.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            dateFormat.setLenient(false);
            try {
                dob = dateFormat.parse(s);
                break;
            } catch (ParseException ex) {
                System.out.println("Invalid date, Enter again:");
            }
        }
        return dob;
    }

    public static int getInt(String name, int min, int max) {
        int x;
        while (true) {
            System.out.println(name);
            String s = sc.next();
            sc.nextLine();

            if (Validation.isNumericInt(s)) {
                x = Integer.parseInt(s);
                if (min <= x && x <= max) {
                    break;
                }
            }
        }
        return x;
    }

    public static void main(String[] args) {
//        System.out.println(Inputter.getInt("integer"));
        System.out.println(Inputter.getDate("ngay sinh", "dd/MM/yyyy"));
    }

}
