/*
ID: winwins1
LANG: JAVA
TASK: friday
 */

import java.io.*;
import java.util.Scanner;

public class friday {

    public static void main(String[] args) throws IOException {
        final String probName = "friday";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int n = in.nextInt();
        int num = 1;

        in.close();
        out.close();
        System.exit(0);
    }
}