package LAB_01;

import java.util.Scanner;

public class Bai63 {
    public static void main(String[] args) {
        Scanner nhapLieu = new Scanner(System.in);

        System.out.print("\nVui long nhap chieu cao cua tam giac (h): ");
        int sohang = nhapLieu.nextInt();

        for (int hang = 1; hang <= sohang; hang++) {
            for (int khoangTrang = sohang; khoangTrang > hang; khoangTrang--) {
                System.out.print(" ");
            }
            for (int dauSao = 1; dauSao <= (2 * hang - 1); dauSao++) {
                System.out.print("*");
            }
            System.out.println();
        }

        nhapLieu.close();
    }
}
