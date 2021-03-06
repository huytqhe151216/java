
/*
 * Copyright(C) 2005, Morses Club of London Scottish Bank.
 * T.NET:
 *  Transport and Information Network
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 HuyTQ           First Implement
 */
package DemoRecursion;
import java.util.Scanner;
/**
 *
 * @author ADMIN
 */
public class HoanVi {
    private int i, n, a[];
    //Khởi tạo
    public void Init() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Nhập vào số phần tử cần hoán vị:");
            n = input.nextInt();
        } while (n <= 0);

        a = new int[n+1];
        for (int j = 1; j <= n; j++) {
            a[j] = j;
        }
    }

    //Hiển thị kết quả
    public void Result() {
        for (int j = 1; j <= n; j++)
            System.out.print(a[j] + "  ");
        System.out.println();

    }
    //Sinh hoán vị
    public void sinhHoanVi() {
        do {
            Result();
            i = n - 1;
            while (i > 0 && a[i] > a[i+1]) --i;
            if (i > 0) {
                int k = n;
                while (a[k] < a[i]) --k; //lùi dần từ cuối dãy để tìm phân tử đầu tiên lớn hơn x[i]
                //đổi chỗ sau khi tìm thấy
                int temp = a[k];
                    a[k] = a[i];
                    a[i] = temp;
                    //Lật ngược đoạn cuối cùng
                k = n;
                for (int j = i + 1; j < k ; j++, k--) {
                        temp = a[j];
                        a[j] = a[k];
                        a[k] = temp;
                }
            }
        } while (i != 0);
    }
    public static void main(String[] args) {
        HoanVi hoanvi = new HoanVi();
        hoanvi.Init();
        hoanvi.sinhHoanVi();
        System.gc();
    }
}
