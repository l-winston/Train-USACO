import java.io.*;
import java.util.Scanner;

public class hshoe {
    static int ans = 0;
    static int n;
    static boolean[][] dfs;
    static boolean[][] visited;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        final String probName = "hshoe";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        n = in.nextInt();

        dfs = new boolean[n][n];

        for(int i = 0; i < n; i++){
            int j = 0;
            for(char c : in.next().toCharArray())
                dfs[i][j++] = c == '(' ? true : false;
        }

        if(dfs[0][0])
            solve(0, 0, true, 1, 0);

        out.println(ans);

        in.close();
        out.close();
        System.exit(0);
    }

    static void solve(int i, int j, boolean first, int open, int close){
        if(i < 0 | i >= n | j < 0 | j <= n)
            return;
        if(visited[i][j])
            return;
        if(!first & 2*open < ans)
            return;

        visited[i][j] = true;

        if(open == close) {
            ans = Math.max(ans, open + close);
            return;
        }

        for(int x = 0; x < 4; x++){
            int i2 = i+di[x], j2 = j+dj[x];
            if(!dfs[i2][j2])
                solve(i + di[x], j + dj[x], false, open, close++);
            else if(first){
                solve(i + di[x], j + dj[x], true, open++, close);
            }
        }


    }
}