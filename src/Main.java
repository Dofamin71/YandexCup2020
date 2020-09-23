import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String min = "zzzz", sub = "zzzz", sub1, sub2 = "", str = scan.nextLine();
        boolean flag = true;
        int strlength = str.length()-1;
        for (int i = 0; i < strlength; ++i) {
            sub1 = str.substring(i, i+2);
            if (i < str.length()-2) sub2 = str.substring(i, i+3);
            if (sub1.charAt(0)==sub1.charAt(1)) {
                sub = sub1;
                flag = false;
            }
            if (flag && sub2.charAt(0)==sub2.charAt(2)) {
                sub = sub2;
            }
            if (min.compareTo(sub) > 0 || sub.length()<min.length()) {
                min = sub;
            }
        }
        if (min == "zzzz") System.out.println("-1");
        else System.out.println(min);
    }
}
