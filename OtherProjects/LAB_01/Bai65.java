package LAB_01;

import java.util.Arrays;
import java.util.Scanner;

public class Bai65 {
    public static void main(String[] args) {
        Scanner nhapLieu = new Scanner(System.in);
        
        System.out.print("\nVui long nhap so luong phan tu: ");
        int soPhanTu = nhapLieu.nextInt();
        
        int[] mangSoNguyen = new int[soPhanTu];
        int tong = 0;

        System.out.println("Vui long nhap " + soPhanTu + " so nguyen:");
        for (int i = 0; i < soPhanTu; i++) {
            mangSoNguyen[i] = nhapLieu.nextInt();
            tong += mangSoNguyen[i]; 
        }

        Arrays.sort(mangSoNguyen);

        double trungBinh = (double) tong / soPhanTu;

        System.out.printf("Tong: %d\nTrung binh: %.2f\n", tong, trungBinh);
        System.out.print("Mang da duoc sap xep: ");
        for (int giaTri : mangSoNguyen) {
            System.out.print(giaTri + " ");
        }
        
        nhapLieu.close();
    }
}
