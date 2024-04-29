import java.util.*;

public class Main {
    public static double solution(double a, double b) {
        double answer;
        answer = a / b;
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        double answer = solution(a, b);
        System.out.println(answer);
    }
}