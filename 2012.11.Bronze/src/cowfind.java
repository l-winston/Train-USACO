import java.io.*;
import java.util.Scanner;

public class cowfind {

    public static void main(String[] args) throws IOException {
        final String probName = "cowfind";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        char[] c = in.next().toCharArray();

        int l = 0;
        int ans = 0;
        for (int i = 0; i < c.length-1; i++) {
            if(c[i] == '(' && c[i+1] == '(')
                l++;
            if(c[i] == ')' && c[i+1] == ')')
                ans += l;
        }

        out.println(ans);

        in.close();
        out.close();
        System.exit(0);
    }
}