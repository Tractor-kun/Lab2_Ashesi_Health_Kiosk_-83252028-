import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Welcome to Ashesi Health Kiosk");

        // Task 1
        System.out.print("Enter service code (P/L/T/C): ");
        char s = sc.next().charAt(0);
        s = Character.toUpperCase(s);
        String serv = "";
        if (s == 'P') {
            serv = "PHARMACY";
            System.out.println("Go to: Pharmacy Desk");
        } else if (s == 'L') {
            serv = "LAB";
            System.out.println("Go to: Lab Desk");
        } else if (s == 'T') {
            serv = "TRIAGE";
            System.out.println("Go to: Triage Desk");
        } else if (s == 'C') {
            serv = "COUNSELING";
            System.out.println("Go to: Counseling Desk");
        } else {
            System.out.println("Invalid service code");
            return;
        }

        // Task 2
        double val = 0;
        double shown = 0;
        if (serv.equals("TRIAGE")) {
            System.out.println("Choose metric: 1=BMI, 2=Dosage, 3=Trig");
            int ch = sc.nextInt();
            if (ch == 1) {
                System.out.print("Enter weight: ");
                double w = sc.nextDouble();
                System.out.print("Enter height: ");
                double h = sc.nextDouble();
                double bmi = w / (h * h);
                shown = Math.round(bmi * 10) / 10.0;
                val = Math.round(bmi);
                String cat = "";
                if (shown < 18.5) {
                    cat = "Underweight";
                } else if (shown < 25) {
                    cat = "Normal";
                } else if (shown < 30) {
                    cat = "Overweight";
                } else {
                    cat = "Obese";
                }
                System.out.println("BMI: " + shown + "  " + cat);
            } else if (ch == 2) {
                System.out.print("Enter dosage: ");
                double d = sc.nextDouble();
                int tabs = (int) Math.ceil(d / 250.0);
                shown = tabs;
                val = tabs;
                System.out.println("Tablets: " + tabs);
            } else if (ch == 3) {
                System.out.print("Enter angle: ");
                double ang = sc.nextDouble();
                double rad = Math.toRadians(ang);
                double sinv = Math.round(Math.sin(rad) * 1000) / 1000.0;
                double cosv = Math.round(Math.cos(rad) * 1000) / 1000.0;
                System.out.println("sin= " + sinv);
                System.out.println("cos= " + cosv);
                shown = sinv;
                val = Math.round(Math.sin(rad) * 100);
            }
        }

        // Task 3
        char c = (char) ('A' + r.nextInt(26));
        String id = "" + c;
        for (int i = 0; i < 4; i++) {
            int d = 3 + r.nextInt(7);
            id += d;
        }
        System.out.println("ID: " + id);

        if (id.length() != 5) {
            System.out.println("Invalid length");
            return;
        }
        if (!Character.isLetter(id.charAt(0))) {
            System.out.println("Invalid: first must be letter");
            return;
        }
        boolean ok = true;
        for (int i = 1; i < 5; i++) {
            if (!Character.isDigit(id.charAt(i))) {
                ok = false;
            }
        }
        if (!ok) {
            System.out.println("Invalid: last 4 not digits");
            return;
        }
        System.out.println("ID OK");

        // Task 4
        System.out.print("Enter first name: ");
        String name = sc.next();
        char b = Character.toUpperCase(name.charAt(0));
        char sh = (char) ('A' + (b - 'A' + 2) % 26);
        String last2 = id.substring(3);
        String code = sh + last2 + "-" + (int) val;
        System.out.println("Display Code: " + code);

        // Task 5
        if (serv.equals("PHARMACY")) {
            System.out.println("Summary: " + serv + " | ID=" + id + " | Code=" + code);
        } else if (serv.equals("LAB")) {
            System.out.println("Summary: " + serv + " | ID=" + id + " | Code=" + code);
        } else if (serv.equals("TRIAGE")) {
            System.out.println("Summary: " + serv + " | ID=" + id + " | BMI=" + shown + " | Code=" + code);
        } else if (serv.equals("COUNSELING")) {
            System.out.println("Summary: " + serv + " | ID=" + id + " | Code=" + code);
        }

        sc.close();
    }
}
