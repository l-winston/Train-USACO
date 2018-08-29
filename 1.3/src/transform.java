/*
ID: winwins1
LANG: JAVA
TASK: transform
 */

// http://train.usaco.org/usacoprob2?a=y75ibIUQe5R&S=transform

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class transform {

    public static void main(String[] args) throws IOException {
        final String probName = "transform";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        Grid grid = new Grid(in);

        in.close();
        out.close();
        System.exit(0);
    }
}

class Grid{
    boolean[][] grid;
    int n;

    public Grid(Scanner in){
        this.n = in.nextInt();
        this.grid = new boolean[n][n];

        for(int i = 0; i < n; i++){
            char[] line = in.next().toCharArray();
            for(int j = 0; j < n; j++){
                grid[i][j] = (line[j] == '@') ? true : false;
            }
        }
    }

}