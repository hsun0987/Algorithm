import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 연산자 저장
        HashSet<Character> set = new HashSet<>(){
            {
                add('*');
                add('/');
                add('+');
                add('-');
            }
        };
        // 피연산자 저장
        HashMap<Character, Double> map = new HashMap<>();

        Stack<Double> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        int j = 0;
        for (int i = 0; i < input.length; i++) {
            if(input[i] >= 65 && !map.containsKey(input[i])){
                map.put(input[i], arr[j++]);
            }
        }

        double answer = 0;
        for (int i = 0; i < input.length; i++) {
            if(set.contains(input[i])){
                double b = stack.pop();
                double a = stack.pop();

                switch (input[i]){
                    case '+':
                        answer = a+b;
                        stack.push(answer);
                        break;
                    case '-':
                        answer = a-b;
                        stack.push(answer);
                        break;
                    case '*':
                        answer = a*b;
                        stack.push(answer);
                        break;
                    case '/':
                        answer = a/b;
                        stack.push(answer);
                        break;
                }
            }else {
                stack.push(map.get(input[i]));
            }
        }

        System.out.printf("%.2f", answer);
    }
}