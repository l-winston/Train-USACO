import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class citystate {

    public static void main(String[] args) throws IOException {
        final String probName = "citystate";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        int n = in.nextInt();
        int ans = 0;


        in.close();
        out.close();
        System.exit(0);
    }
}