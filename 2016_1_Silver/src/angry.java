import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class angry {

    static StringTokenizer stringTokenizer;
    static BufferedReader in;
    static PrintWriter out;
    static String probName;

    static int[] cows;
    static int k, n;

    public static void solve() throws IOException{
        readLine();

        n = readInt();
        k = readInt();
        cows = new int[n];

        for(int i = 0; i < n; i++){
            readLine();
            cows[i] = readInt();
        }

        Arrays.sort(cows);

        int low = 0;
        int high = (cows[n-1] - cows[0] + 1)/2;

        while(high - low > 0){
            int mid = (high+low)/2;

            if(test(mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }


        out.println(low);
    }

    static boolean test(int r){
        int count = 0;

        int curr = 0;

        loop:
        while(curr < n){
            for(int i = curr + 1; true ; i++){
                if(i >= n){
                    count++;
                    curr = n;
                    break loop;
                }
                if(cows[i] - cows[curr] > 2*r){
                    count++;
                    curr = i;
                    break;
                }
            }
        }

        return count <= k;
    }

    public static void main(String[] args) throws IOException {
        setup();

        solve();

        cleanup();
    }

    private static void setup() throws IOException{
        probName = "angry";
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