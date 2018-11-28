import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class circlecross {

    static StringTokenizer stringTokenizer;
    static BufferedReader in;
    static PrintWriter out;
    static String probName;

    public static void solve() throws IOException{
        readLine();
        String str = readString();
        for(int i = 0; i < 26; i++){
            str = str.replaceAll(Character.toString((char)('A'+i))+Character.toString((char)('A'+i)), "");
        }
        char[] ch = str.toCharArray();
        int[] occur = new int[ch.length];
        Arrays.fill(occur, -1);
        int ans = 0;

        System.out.println(str);

        for(int i = 0; i < ch.length; i++){
            int ind = ch[i]-'A';
            if(occur[ind] == -1)
                occur[ind] = i;
            else{
                for(int j = occur[ind]+1; j < i; j++){
                    if(occur[ch[j]-'A'] != -1)
                        ans++;
                }
                occur[ind]=-1;
            }
            System.out.println(Arrays.toString(occur));
        }
        out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        setup();

        solve();

        cleanup();
    }

    private static void setup() throws IOException{
        probName = "circlecross";
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