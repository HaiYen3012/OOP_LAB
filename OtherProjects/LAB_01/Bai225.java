package LAB_01;

import java.util.Scanner;

public class Bai225{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("\nNhap gia tri thu nhat: ");
        double value1 = input.nextDouble();
        System.out.print("Nhap gia tri thu hai: ");
        double value2 = input.nextDouble();
        System.out.printf("Tong cua hai gia tri: %.2f\n", value1 + value2);
        System.out.printf("Hieu cua hai gia tri: %.2f\n", value1 - value2);
        System.out.printf("Tich cua hai gia tri: %.2f\n", value1 * value2);
        System.out.printf("Thuong cua hai gia tri: %.2f", value1 / value2);
        input.close();
    }
}