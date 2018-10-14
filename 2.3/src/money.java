/*
ID: winwins1
LANG: JAVA
TASK: money
 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class money {
    static long[] dp = new long[10001];

    public static void main(String[] args) throws IOException {
        final String probName = "money";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        int n = in.nextInt();
        int v = in.nextInt();
        dp[0] = 1;
        for(int i = 0; i < n; i++){
            int c = in.nextInt();
            for(int j = c; j < v+1; j++){
                dp[j] += dp[j-c];
            }
        }

        out.println(dp[v]);
        in.close();
        out.close();
        System.exit(0);

    }
}


/*  FIRST TRY: RECURSION
    static int solve(int n, int v){
        if(n==0){
            if(v%coins[0] == 0)
                return 1;
            else
                return 0;
        }

        int ret = 0;
        int coin = coins[n];
        for(int i = 0; i < v; i += coin){
            ret += solve(n-1, v-i);
        }
        if(v%coin==0)
            ret++;
        System.out.println(n + "\t" + v + "\t" +ret);
        return ret;
    }
*/

/*  SECOND TRY: 2D DP
        int N = in.nextInt();
        int V = in.nextInt();

        coins = new int[N];
        for (int i = 0; i < coins.length; i++)
            coins[i] = in.nextInt();

        int[][] dp = new int[V+1][N];

        for(int v = 0; v < V+1; v++){
            int n = 0;
            dp[v][n] = v%coins[n] == 0 ? 1 : 0;
        }

        for(int n = 1; n < N; n++){
            for(int v = 1; v < V+1; v++) {

                int coin = coins[n];
                if(coin > v)
                    continue;
                for(int i = 0; i < v; i += coin){
                    dp[v][n] += dp[v-i][n-1];
                }
                if(v%coin == 0)
                    dp[v][n]++;

            }
        }

        for(int[] i : dp)
            System.out.println(Arrays.toString(i));


        out.println(dp[V][N-1]);
*/