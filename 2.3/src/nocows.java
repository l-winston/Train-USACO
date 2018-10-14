/*
ID: winwins1
LANG: JAVA
TASK: nocows
 */

// http://train.usaco.org/usacoprob2?a=69VloHXkeoF&S=nocows

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class nocows {

    public static void main(String[] args) throws IOException {
        final String probName = "nocows";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        final int N = in.nextInt();
        final int K = in.nextInt();

        // use dp (2d because 2 variables will be changed)
        int[][] dp = new int[K + 1][N + 1];

        // for all n=1, if k > 0 then there is 1 way
        for (int k = 1; k < K + 1; k++) {
            dp[k][1] = 1;
        }

        // skip to 2, if n=0 then 0 ways, if k=0 then 0 ways
        for (int k = 2; k < K + 1; k++) {
            for (int n = 2; n < N + 1; n++) {
                int sum = 0;
                // sum of product of all subtrees (k-1, a) & (k-1, b) such that a+b = n-1
                for (int cnt = 1; cnt < n-1; cnt++) {
                    sum += dp[k - 1][cnt] * dp[k - 1][n - 1 - cnt];
                }

                // modular arithmetic, we can mod by 9901 first to avoid integer overflow and still have the right number
                dp[k][n] = sum % 9901;
            }
        }

        // dp array represents all ways to put N nodes a K OR LESS high tree
        // to get the true number of K high trees, subtract all of those that aren't K high (dp[K-1][N])
        out.println((dp[K][N] - dp[K-1][N] + 9901) % 9901);

        in.close();
        out.close();
        System.exit(0);
    }
}