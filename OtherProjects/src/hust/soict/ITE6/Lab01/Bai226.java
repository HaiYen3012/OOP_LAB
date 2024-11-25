package src.hust.soict.ITE6.Lab01;

import java.util.Scanner;

public class Bai226 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option = getUserOption(input);
        switch (option) {
            case 1:
                solveLinearSystem(input);
                break;
            case 2:
                solveQuadraticEquation(input);
                break;
            case 3:
                solveLinearEquation(input);
                break;
            default:
                System.out.println("Tuy chon khong hop le.");
        }
    }

    private static int getUserOption(Scanner input) {
        System.out.println("Lua chon:");
        System.out.println("1. He phuong trinh tuyen tinh hai an so");
        System.out.println("2. Phuong trinh bac hai");
        System.out.println("3. Phuong trinh bac nhat");
        System.out.print("Vui long nhap lua chon cua ban: ");
        return input.nextInt();
    }

    private static void solveLinearEquation(Scanner input) {
        System.out.print("Nhap he so x: ");
        double xCoefficient = input.nextDouble();
        System.out.print("Nhap he so y: ");
        double yCoefficient = input.nextDouble();
        if (xCoefficient == 0 && yCoefficient != 0) {
            System.out.println("Phuong trinh khong co nghiem.");
        } else if (xCoefficient == 0 && yCoefficient == 0) {
            System.out.println("Phuong trinh co vo so nghiem.");
        } else {
            System.out.printf("Phuong trinh co nghiem la x = %.3f%n", -yCoefficient / xCoefficient);
        }
    }

    private static void solveLinearSystem(Scanner input) {
        System.out.print("Nhap he so a1: ");
        double coefficientA1 = input.nextDouble();
        System.out.print("Nhap he so b1: ");
        double coefficientB1 = input.nextDouble();
        System.out.print("Nhap he so c1: ");
        double coefficientC1 = input.nextDouble();
        System.out.print("Nhap he so a2: ");
        double coefficientA2 = input.nextDouble();
        System.out.print("Nhap he so b2: ");
        double coefficientB2 = input.nextDouble();
        System.out.print("Nhap he so c2: ");
        double coefficientC2 = input.nextDouble();

        double delta = coefficientA1 * coefficientB2 - coefficientA2 * coefficientB1;
        double deltaX = coefficientC1 * coefficientB2 - coefficientC2 * coefficientB1;
        double deltaY = coefficientA1 * coefficientC2 - coefficientA2 * coefficientC1;

        if (delta != 0) {
            System.out.printf("Nghiem cua he phuong trinh: (x, y) = (%.3f, %.3f)%n", deltaX / delta, deltaY / delta);
        } else if (deltaX == 0 && deltaY == 0) {
            System.out.println("He phuong trinh co vo so nghiem.");
        } else {
            System.out.println("He phuong trinh vo nghiem.");
        }
    }

    private static void solveQuadraticEquation(Scanner input) {
        System.out.print("Nhap he so a (khac 0): ");
        double a = input.nextDouble();
        System.out.print("Nhap he so b: ");
        double b = input.nextDouble();
        System.out.print("Nhap he so c: ");
        double c = input.nextDouble();
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            System.out.println("Phuong trinh khong co nghiem.");
        } else if (discriminant == 0) {
            System.out.printf("Phuong trinh co nghiem kep: x1 = x2 = %.3f%n", -b / (2 * a));
        } else {
            System.out.printf("Phuong trinh co hai nghiem phan biet: x1 = %.3f va x2 = %.3f%n",
                    (-b - Math.sqrt(discriminant)) / (2 * a),
                    (-b + Math.sqrt(discriminant)) / (2 * a));
        }
    }
}
