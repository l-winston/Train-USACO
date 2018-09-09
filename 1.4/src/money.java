/*
ID: winwins1
LANG: JAVA
TASK: money
 */

/*
3 10
1 2 5
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

        int V, N, i, j, temp;
        V = in.nextInt();
        N = in.nextInt();
        dp[0] = 1;
        for (i = 1; i <= V; i++) {
            temp = in.nextInt();
            for (j = temp; j <= N; j++)
                dp[j] += dp[j - temp];
        }

        out.println(dp[N]);
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