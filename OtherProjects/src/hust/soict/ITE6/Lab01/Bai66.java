package src.hust.soict.ITE6.Lab01;

import java.util.Scanner;

public class Bai66 {
    public static void main(String[] args) {
        Scanner nhapLieu = new Scanner(System.in);

        System.out.println("\nVui long nhap so hang (n): ");
        int soHang = nhapLieu.nextInt();
        System.out.println("Vui long nhap so cot (m): ");
        int soCot = nhapLieu.nextInt();

        int[][] maTran1 = new int[soHang][soCot];
        int[][] maTran2 = new int[soHang][soCot];
        int[][] tongMaTran = new int[soHang][soCot];

        System.out.println("Vui long nhap cac phan tu cho ma tran 1: ");
        for (int i = 0; i < soHang; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.printf("Phan tu [%d][%d]: ", i, j);
                maTran1[i][j] = nhapLieu.nextInt();
            }
        }

        System.out.println("Vui long nhap cac phan tu cho ma tran 2: ");
        for (int i = 0; i < soHang; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.printf("Phan tu [%d][%d]: ", i, j);
                maTran2[i][j] = nhapLieu.nextInt();
            }
        }

        System.out.println("Tong cua hai ma tran: ");
        for (int i = 0; i < soHang; i++) {
            for (int j = 0; j < soCot; j++) {
                tongMaTran[i][j] = maTran1[i][j] + maTran2[i][j];
                System.out.printf("%d ", tongMaTran[i][j]);
            }
            System.out.println(); 
        }

        nhapLieu.close(); 
    }
}
