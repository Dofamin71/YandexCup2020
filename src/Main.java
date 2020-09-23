import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < 10; ++i) nums[i] = scan.nextInt();
        int amount = scan.nextInt(), num, count = 0;
        for (int i = 0; i < amount; ++i) {
            for (int g = 0; g < 6; ++g) {
                num = scan.nextInt();
                for (int j = 0; j < 10; ++j) if (num == nums[j]) ++count;
            }
            if (count >= 3) System.out.println("Lucky");
            else System.out.println("Unlucky");
            count = 0;
        }
    }
}
