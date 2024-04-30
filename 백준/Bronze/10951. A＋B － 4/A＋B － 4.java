import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
           int n1 = in.nextInt();
           int n2 = in.nextInt();

            System.out.println(n1+n2);
        }
    }
}