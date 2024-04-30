import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int answer = 0;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String num = sc.next();

        for (int i = 0; i < n; i++) {
            int a = num.charAt(i) - '0';
            answer += a;
        }

        System.out.println(answer);
    }
}