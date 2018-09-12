import java.io.*;
import java.util.Scanner;

public class blocks {

    public static void main(String[] args) throws IOException {
        final String probName = "blocks";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        int N = in.nextInt();
        int[] ans = new int[26];

        for(int n = 0; n < N; n++){
            int[] a = freq(in.next());
            int[] b = freq(in.next());
            for(int i = 0; i < 26; i++){
                ans[i]+=Math.max(a[i], b[i]);
            }
        }

        for(int i : ans)
            out.println(i);
        in.close();
        out.close();
        System.exit(0);
    }

    static int[] freq(String a){
        int[] ret = new int[26];

        for(char c : a.toCharArray())
            ret[c-'a']++;

        return ret;
    }
}