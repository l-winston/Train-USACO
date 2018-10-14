/*
ID: winwins1
LANG: JAVA
TASK: beads
 */

// http://train.usaco.org/usacoprob2?a=y75ibIUQe5R&S=beads

import java.io.*;
import java.util.Scanner;

public class beads {

    public static void main(String[] args) throws IOException {
        final String probName = "beads";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        int n = in.nextInt();
        // store as char array
        char[] necklace = in.next().toCharArray();

        int maxscore = 0;
        for (int i = 0; i < n; i++) {
            // find characters at breakoff point
            char l = necklace[i%n];
            char r = necklace[(i+1)%n];

            // if bead is wildcard, set it equal to the one after it
            if(l == 'w')
                l = necklace[(i+n-1)%n];
            if(r == 'w')
                r = necklace[(i+1+1)%n];

            // the beads at the end are automatically added
            int score = 2;

            // keep looking left until you find a bead that isn't the same
            for(int j = 1; j < n; j++){
                if(necklace[(i-j+n)%n] != l && necklace[(i-j+n)%n] != 'w')
                    break;
                score++;
            }

            // keep looking right until you find a bead that isn't the same
            for(int j = 1; j < n; j++){
                if(necklace[(i+1+j+n)%n] != r && necklace[(i+1+j+n)%n] != 'w')
                    break;
                score++;

            }

            // record number of beads possible so far
            maxscore = Math.max(score, maxscore);
        }

        // if all beads taken from right overlap beads taken from left (vice versa)
        out.println(Math.min(maxscore, n));

        in.close();
        out.close();
        System.exit(0);
    }
}