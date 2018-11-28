import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class cowqueue {

    static StringTokenizer stringTokenizer;
    static BufferedReader in;
    static PrintWriter out;
    static String probName;

    public static void solve() throws IOException{
        readLine();
        int n = readInt();
        Cow[] cows = new Cow[n];
        for(int i = 0; i < n; i++){
            readLine();
            cows[i] = new Cow(readInt(), readInt());
        }
        Arrays.sort(cows);
        int time = 0;
        System.out.println(Arrays.toString(cows));
        for(int i = 0; i < n; i++){
            Cow cow = cows[i];
            if(cow.t >= time) {
                time = cow.t + cow.len;
                continue;
            }
            time += cow.len;
        }
        out.println(time);
    }

    public static class Cow implements Comparable<Cow>{
        int t, len;
        public Cow(int _t, int _len){
            t=_t;
            len=_len;
        }

        @Override
        public int compareTo(Cow o) {
            return t-o.t;
        }

        public String toString(){
            return "("+t+", "+len+")";
        }
    }

    public static void main(String[] args) throws IOException {
        setup();

        solve();

        cleanup();
    }

    private static void setup() throws IOException{
        probName = "cowqueue";
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