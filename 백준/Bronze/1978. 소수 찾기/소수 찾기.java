import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int answer = 0;


        for (int k = 0; k < t; k++) {
            int n = in.nextInt();
            boolean isPrime = true;

            if(n == 1){
                continue;
            }

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if(n % i == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                answer++;
            }
        }
        System.out.println(answer);
    }
}