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

        final int n = in.nextInt();
        final int k = in.nextInt();
        final long[] maxsize = new long[200];
        maxsize[0] = 0;
        for (int i = 1; i < maxsize.length; i++) {
            maxsize[i] = maxsize[i-1] + (int)Math.pow(2, i-1);
        }

        System.out.println(Arrays.toString(maxsize));

        int[] dp = new int[k+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i < k+1; i++){
            if(n < maxsize[i])
                continue;
        }


        in.close();
        out.close();
        System.exit(0);
    }
}