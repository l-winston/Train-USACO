/*
ID: winwins1
LANG: JAVA
TASK: milk
 */

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class milk {

    static StringTokenizer stringTokenizer;
    static BufferedReader in;
    static PrintWriter out;
    static String probName;

    public static void solve() throws IOException{
        readLine();
        int milk = readInt();
        int farmers = readInt();
        Farmer[] f = new Farmer[farmers];
        for(int i = 0; i < farmers; i++){
            readLine();
            f[i] = new Farmer(readInt(), readInt());
        }
        Arrays.sort(f);
        int totalcost = 0;

        for(int i = 0; i < farmers; i++){
            Farmer farmer = f[i];
            if(farmer.milk > milk) {
                totalcost += milk*farmer.cost;
                break;
            }
            totalcost += farmer.milk*farmer.cost;
            milk -= farmer.milk;
        }
        out.println(totalcost);
    }





    static class Farmer implements Comparable<Farmer>{
        int milk, cost;
        public Farmer(int _cost, int _milk){
            milk=_milk;
            cost=_cost;
        }

        @Override
        public int compareTo(Farmer o) {
            return cost-o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        setup();

        solve();

        cleanup();
    }

    private static void setup() throws IOException{
        probName = "milk";
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