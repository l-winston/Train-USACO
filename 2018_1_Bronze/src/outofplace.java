import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class outofplace {

    static StringTokenizer stringTokenizer;
    static BufferedReader in;
    static PrintWriter out;
    static String probName;

    public static void solve() throws IOException {
        readLine();
        int n = readInt();

        int[] height = new int[n];
        int[] sorted = new int[n];
        for(int i = 0; i < n; i++) {
            readLine();
            height[i] = readInt();
            sorted[i] = height[i];
        }
        Arrays.sort(sorted);
        int swaps = -1;
        for(int a = 0; a < n; a++) {
            if(sorted[a] != height[a]) {
                swaps++;
            }
        }
        swaps = Math.max(0, swaps);
        out.println(swaps);
    }


    public static void main(String[] args) throws IOException {
        setup();

        solve();

        cleanup();
    }

    private static void setup() throws IOException {
        probName = "outofplace";
        in = new BufferedReader(new FileReader(probName + ".in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));
    }

    private static void cleanup() throws IOException {
        in.close();
        out.close();
        System.exit(0);
    }

    private static void readLine() throws IOException {
        stringTokenizer = new StringTokenizer(in.readLine());
    }

    private static int readInt() {
        return Integer.parseInt(stringTokenizer.nextToken());
    }

    private static String readString() {
        return stringTokenizer.nextToken();
    }
}