/*
ID: winwins1
LANG: JAVA
TASK: prefix
 */

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class prefix {

    public static void main(String[] args) throws IOException {
        final String probName = "prefix";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        HashSet<String> primitives = new HashSet<String>();
        String nxt;
        while(!(nxt=in.next()).equals(".")){
            primitives.add(nxt);
        }
        StringBuilder sb = new StringBuilder();
        while(in.hasNextLine())
            sb.append(in.nextLine());

        String str = sb.toString();

        int[] dp = new int[str.length()+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int max = 0;

        for(int i = 1; i < dp.length; i++){
            for(String prim : primitives) {
                if(prim.length() > i)
                    continue;
                if(dp[i-prim.length()] != -1){
                    if(str.substring(i-prim.length(), i).equals(prim)) {
                        dp[i] = Math.max(dp[i], i);
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        out.println(max);

        in.close();
        out.close();
        System.exit(0);
    }
}