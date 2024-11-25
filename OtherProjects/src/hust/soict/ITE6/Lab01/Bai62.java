package src.hust.soict.ITE6.Lab01;

import java.util.Scanner;

public class Bai62 {
    public static void main(String[] args) {
        Scanner nhapLieu = new Scanner(System.in);

        System.out.print("\nVui long nhap ten cua ban: ");
        String ten = nhapLieu.nextLine();

        System.out.print("Vui long nhap tuoi cua ban: ");
        int tuoi = nhapLieu.nextInt();

        System.out.print("Vui long cho biet chieu cao cua ban: ");
        double chieuCao = nhapLieu.nextDouble();

        System.out.println("Xin chao, " + ten + "! Ban " + tuoi + " tuoi va co chieu cao la " + chieuCao + " met.");

        nhapLieu.close();
    }
}
