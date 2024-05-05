import java.util.*;

public class Main {
    public static int solution(int a, int b) {
        int answer;
        answer = a * b;
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int answer = solution(a, b);
        System.out.println(answer);
    }
}