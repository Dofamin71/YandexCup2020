import java.io.*;

public class Main {
    private static final String FILE_INPUT = "input.txt";
    private static final String FILE_OUTPUT = "output.txt";
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;
    private static final int MAX_CHAR_ARRAY_SIZE = 6;

    public static void main(String[] args) throws IOException {
        init();
        run();
        close();
    }

    public static void run() throws IOException {
        String answer = "YES";
        int amount = Integer.parseInt(String.valueOf(readLine()).trim());
        if (amount < 3) {
            System.out.println("YES");
            System.exit(0);
        }
        double x1, y1, x2, y2, x3, y3, x4, y4;
        double[][] centers = new double[amount][2];
        double A = 0., B = 0., C = 0.;
        for (int i = 0; i < amount; ++i) {
            switch (readLine()[0]) {
                case '0':
                    readLine();
                    centers[i][0] = Double.parseDouble(String.valueOf(readLine()).trim());
                    centers[i][1] = Double.parseDouble(String.valueOf(readLine()).trim());
                    break;
                case '1':
                    x1 = Double.parseDouble(String.valueOf(readLine()).trim());
                    y1 = Double.parseDouble(String.valueOf(readLine()).trim());
                    x2 = Double.parseDouble(String.valueOf(readLine()).trim());
                    y2 = Double.parseDouble(String.valueOf(readLine()).trim());
                    x3 = Double.parseDouble(String.valueOf(readLine()).trim());
                    y3 = Double.parseDouble(String.valueOf(readLine()).trim());
                    x4 = Double.parseDouble(String.valueOf(readLine()).trim());
                    y4 = Double.parseDouble(String.valueOf(readLine()).trim());
                    centers[i][0] = (x1+x2+x3+x4)/4.;
                    centers[i][1] = (y1+y2+y3+y4)/4.;
                    break;
            }
            if (i == 1) {
                A = centers[0][1] - centers[1][1];
                B = centers[1][0] - centers[0][0];
                C = centers[0][0] * centers[1][1] - centers[1][0] * centers[0][1];
            }
            if (A == 0 && B == 0) {
                A = centers[i][1] - centers[1][1];
                B = centers[1][0] - centers[i][0];
                C = centers[i][0] * centers[1][1] - centers[1][0] * centers[i][1];
            }
            if (i > 1) {
                if (A*centers[i][0] + B*centers[i][1] + C != 0.) {
                    answer = "NO";
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    private static void init() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(FILE_INPUT));
        bufferedWriter = new BufferedWriter(new FileWriter(FILE_OUTPUT));
    }

    private static void close() throws IOException {
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static char[] readLine() throws IOException {
        char[] res = new char[MAX_CHAR_ARRAY_SIZE];
        int count = 0;
        while (true) {
            int b = bufferedReader.read();
            if (b == '\n' || b == ' ') return res;
            if (b == '\r') continue;
            res[count++] = (char) b;
        }
    }
}
