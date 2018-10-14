/*
ID: winwins1
LANG: JAVA
TASK: palsquare
 */

// http://train.usaco.org/usacoprob2?a=trfDcqKkOj4&S=palsquare

import java.io.*;
import java.util.Scanner;

public class palsquare {

    public static void main(String[] args) throws IOException {
        final String probName = "palsquare";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        final int MIN_N = 1;
        final int MAX_N = 300;

        int base = in.nextInt();

        for(int i = MIN_N; i <= MAX_N; i++){
            String i2 = Integer.toString(i*i);
            // if its square is a palindrome then print it
            if(isPali(convertFromBaseToBase(i2, 10, base)))
                out.println((convertFromBaseToBase(i+"", 10, base) + " " + convertFromBaseToBase(i2, 10, base)).toUpperCase());
        }

        in.close();
        out.close();
        System.exit(0);
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