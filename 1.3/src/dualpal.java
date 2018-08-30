/*
ID: winwins1
LANG: JAVA
TASK: dualpal
 */

import java.io.*;
import java.util.Scanner;

public class dualpal {

    static final int BASE_MIN = 2;
    static final int BASE_MAX = 10;

    public static void main(String[] args) throws IOException {
        final String probName = "dualpal";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        int n = in.nextInt();
        int s = in.nextInt();

        // find next n numbers for which paliInTwoBases() is true
        int counter = s+1;
        for(int i = 0; i < n; i++){
            while(!paliInTwoBases(counter)) {
                counter++;
            }

            out.println(counter);
            counter++;
        }

        in.close();
        out.close();
        System.exit(0);
    }

    // checks if the number is a pali in at least two bases [2-10]
    public static boolean paliInTwoBases(int n){
        int bases = 0;
        for(int i = BASE_MIN; i <= BASE_MAX; i++){
            if(isPali(convertFromBaseToBase(n+"", 10, i)))
                bases++;
            if(bases == 2)
                return true;
        }
        return false;
    }

    // converts number (as String) from one base to another
    public static String convertFromBaseToBase(String num, int fromBase, int toBase) {
        return Integer.toString(Integer.parseInt(num, fromBase), toBase);
    }

    // checks if the string is a palindrome
    public static boolean isPali(String str){
        char[] c = str.toCharArray();

        for(int i = 0; i < c.length/2; i++){
            if(c[i] != c[c.length-1-i])
                return false;
        }

        return true;
    }
}