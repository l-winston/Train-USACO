import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class shuffle {

    static StringTokenizer stringTokenizer;
    static BufferedReader in;
    static PrintWriter out;
    static String probName;

    public static void solve() throws IOException{
        // SOLVE HERE
        readLine();
        int N = readInt();
        int[] shuffle = new int[N];
        readLine();
        for(int i = 0; i < N; i++){
            shuffle[i] = readInt()-1;
        }
        int[] id = new int[N];
        readLine();
        for(int i = 0; i < N; i++){
            id[i] = readInt();
        }

        for(int x = 0; x < 3; x++) {
            int[] prev = new int[N];
            for (int i = 0; i < N; i++) {
                prev[i] = id[shuffle[i]];
            }
            id = prev;

        }
        for(int i : id)
            out.println(i);
    }

    public static void main(String[] args) throws IOException {
        setup();

        solve();

        cleanup();
    }

    private static void setup() throws IOException{
        probName = "shuffle";
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