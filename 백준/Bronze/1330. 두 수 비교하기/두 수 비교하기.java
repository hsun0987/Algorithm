import java.util.*;

public class Main {
    public static String solution(int a, int b) {
        String answer;
        if(a > b){
            answer = ">";
        }else if (a < b){
            answer = "<";
        }else
            answer = "==";
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        String answer = solution(a, b);
        System.out.println(answer);
    }
}
