/*
ID: winwins1
LANG: JAVA
TASK: barn1
 */

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class barn1 {

    static StringTokenizer stringTokenizer;
    static BufferedReader in;
    static PrintWriter out;
    static String probName;

    public static void solve() throws IOException{
        readLine();
        int boards = readInt();
        int stalls = readInt();
        int cows = readInt();
        if(boards >= cows) {
            out.println(cows);
            return;
        }

        int[] pos = new int[cows];
        int[] dists = new int[cows-1];
        for(int i = 0; i < cows; i++){
            readLine();
            pos[i] = readInt();
        }

        Arrays.sort(pos);

        for(int i = 1; i < cows; i++){
            dists[i-1] = pos[i]-pos[i-1]-1;
        }

        Arrays.sort(dists);

        int not_boarded = 0;
        for(int i = 0; i < boards-1; i++){
            not_boarded += dists[cows-1-i-1];
        }

        out.println((pos[cows-1]-pos[0]+1)-not_boarded);
    }

    public static void main(String[] args) throws IOException {
        setup();

        solve();

        cleanup();
    }

    private static void setup() throws IOException{
        probName = "barn1";
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