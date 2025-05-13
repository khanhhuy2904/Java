import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số n: ");
        int n = sc.nextInt();
        //2
//        if(isPrime(n)){
//            System.out.println("Yes");
//        }
//        else {
//            System.out.println("No");
//        }
//        //3
//        for(int i=0; i<=n;i++){
//            if(isPrime(i)){
//                System.out.println(i);
//            }
//        }
//        //4
//        int a = 0, b = 1;
//        for(int i = 0; i<n; i++){
//            System.out.print(a);
//            if(i<n-1){
//                System.out.print(", ");
//            }
//            int next = a + b;
//            a = b;
//            b = next;
//        }
//        System.out.println(" ");

        //5
        System.out.println("VD1:");
        for(int i = 0; i<n; i++){
            for(int j=0; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("VD2:");
        for(int i = n-1; i>=0; i--){
            for(int j=0; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("VD3:");
        for(int i = 0; i<=n; i++){
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // In dấu *
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}