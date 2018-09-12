import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class moocast {
    static int ans = 0;
    static int[] x, y, p;
    static int n;
    public static void main(String[] args) throws IOException {
        final String probName = "moocast";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        n = in.nextInt();
        x = new int[n];
        y = new int[n];
        p = new int[n];

        for(int i = 0; i < n; i++){
            x[i] = in.nextInt();
            y[i] = in.nextInt();
            p[i] = in.nextInt();
        }

        // test every node
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, expand(i, new boolean[n]));
        }

        out.println(ans);

        in.close();
        out.close();
        System.exit(0);
    }

    static int expand(int ind, boolean[] visited){
        // return if visited
        if(visited[ind])
            return 0;
        visited[ind] = true;
        // count self
        int total = 1;
        // propagate signal
        for(int i = 0; i < n; i++)
            if(!visited[i])
                if(inRange(x[ind], y[ind], x[i], y[i], p[ind]))
                    total+=expand(i, visited);

        return total;
    }

    // dont use sqrt func, is slower than squaring
    static boolean inRange(int x1, int y1, int x2, int y2, int p){
        return (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) <= p*p;
    }
}