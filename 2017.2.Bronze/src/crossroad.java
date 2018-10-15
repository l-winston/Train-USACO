import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class crossroad {

    static StringTokenizer stringTokenizer;
    static BufferedReader in;
    static PrintWriter out;
    static String probName;

    public static void solve() throws IOException{
        readLine();
        int n = readInt();
        int ans = 0;
        byte[] cows = new byte[10];
        Arrays.fill(cows, (byte) -1);
        for(int i = 0; i < n; i++){
            readLine();
            int cow = readInt();
            byte state = (byte) readInt();
            if(cows[cow] == -1)
                cows[cow] = state;
            else if(cows[cow] != state){
                cows[cow]=state;
                ans++;
            }
        }
        out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        setup();

        solve();

        cleanup();
    }

    private static void setup() throws IOException{
        probName = "crossroad";
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