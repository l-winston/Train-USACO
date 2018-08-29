/*
ID: winwins1
LANG: JAVA
TASK: transform
 */

// http://train.usaco.org/usacoprob2?a=y75ibIUQe5R&S=transform

import java.io.*;
import java.util.Scanner;

public class transform {

    public static void main(String[] args) throws IOException {
        final String probName = "transform";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        int n = in.nextInt();

        Grid before = new Grid(in, n);
        Grid after = new Grid(in, n);

        if(before.rotate90().equals(after))
            out.println(1);
        else if(before.rotate90().rotate90().equals(after))
            out.println(2);
        else if(before.rotate90().rotate90().rotate90().equals(after))
            out.println(3);
        else if(before.reflect().equals(after))
            out.println(4);
        else if(before.reflect().rotate90().equals(after) | before.reflect().rotate90().rotate90().equals(after) | before.reflect().rotate90().rotate90().rotate90().equals(after))
            out.println(5);
        else if(before.equals(after))
            out.println(6);
        else
            out.println(7);

        in.close();
        out.close();
        System.exit(0);
    }
}

class Grid {
    boolean[][] grid;
    int n;

    public Grid(Scanner in, int n) {
        this.n = n;
        this.grid = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] line = in.next().toCharArray();
            for (int j = 0; j < n; j++) {
                grid[i][j] = (line[j] == '@') ? true : false;
            }
        }
    }

    public Grid(boolean[][] grid, int n){
        this.grid = grid;
        this.n = n;
    }

    Grid rotate90(){
        boolean[][] ret = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ret[j][n-1-i] = grid[i][j];
            }
        }
        return new Grid(ret, n);
    }

    Grid reflect(){
        boolean[][] ret = new boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ret[i][n-1-j] = grid[i][j];
            }
        }
        return new Grid(ret, n);
    }

    boolean equals(Grid other) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != other.grid[i][j])
                    return false;
            }
        }
        return true;
    }

}