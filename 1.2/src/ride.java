/*
ID: winwins1
LANG: JAVA
TASK: ride
 */

import java.io.*;
import java.util.Scanner;

// http://train.usaco.org/usacoprob2?a=y75ibIUQe5R&S=ride

public class ride {

    public static void main(String[] args) throws IOException {
        final String probName = "ride";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        char[] comet = in.next().toCharArray();
        char[] group = in.next().toCharArray();

        int comettotal = 1;
        for(char c : comet){
            int d = c - 'A' + 1;

            comettotal *= d;
        }

        int grouptotal = 1;
        for(char c : group){
            int d = c - 'A' + 1;

            grouptotal *= d;
        }

        if(comettotal%47 == grouptotal%47){
            out.println("GO");
        }else{
            out.println("STAY");
        }

        in.close();
        out.close();
        System.exit(0);
    }
}