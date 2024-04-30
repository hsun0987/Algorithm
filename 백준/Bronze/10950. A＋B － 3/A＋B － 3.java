import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] arr = new int[t];

        for (int i = 0; i < t; i++) {
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            arr[i] = n1 + n2;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}