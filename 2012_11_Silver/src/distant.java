import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
public class distant {

    static StringTokenizer stringTokenizer;
    static BufferedReader in;
    static PrintWriter out;
    static String probName;

    static int n, a, b;
    static boolean[][] pastures;

    public static void solve() throws IOException{
        readLine();
        n = readInt();
        a = readInt();
        b = readInt();

        pastures = new boolean[n][n];

        for(int i = 0; i < n; i++){
            readLine();
            char[] c = readString().toCharArray();

            for(int j = 0; j < n; j++){
                pastures[i][j] = c[j] == '(';
            }
        }


    }

    static int minDist(int si, int sj){

        int[][] dists = new int[n][n];

        boolean[][] checked = new boolean[n][n];

        for(int[] i : dists)
            Arrays.fill(i, Integer.MAX_VALUE);
        dists[si][sj] = 0;

        return
    }

    public static void main(String[] args) throws IOException {
        setup();

        solve();

        cleanup();
    }

    private static void setup() throws IOException{
        probName = "distant";
        in = new BufferedReader(new FileReader(probName + ".in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));
    }

    private static void cleanup() throws IOException{
        in.close();
        out.close();
        System.exit(0);
    }

    private static void readLine() throws IOException{
        stringTokenizer = new StringTokenizer(in.readLine());
    }

    private static int readInt(){
        return Integer.parseInt(stringTokenizer.nextToken());
    }

    private static String readString(){
        return stringTokenizer.nextToken();
    }
}