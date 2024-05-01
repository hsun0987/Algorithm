import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int k = 0; k < t; k++) {
            int n = in.nextInt();
            String s = in.next();

            for(int i = 0; i < s.length(); i++){
                for(int j = 0; j < n; j++){
                    System.out.print(s.charAt(i));
                }
            }
            System.out.println();
        }
    }
}