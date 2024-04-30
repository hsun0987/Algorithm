import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int max = 0;
        int n = 0;

        ArrayList<Integer> nums = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            nums.add(sc.nextInt());
        }
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) > max) {
                max = nums.get(i);
                n = i + 1;
            }
        }
        System.out.println(max);
        System.out.println(n);
    }
}