import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class cowsignal {

    public static void main(String[] args) throws IOException {
        final String probName = "cowsignal";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        int M = in.nextInt(), N = in.nextInt(), K = in.nextInt();

        for (int i = 0; i < M; i++) {
            char[] c = in.next().toCharArray();
            // print double rows
            for (int dr = 0; dr < K; dr++) {
                for (int j = 0; j < N; j++)
                    // print double cols
                    for (int dc = 0; dc < K; dc++)
                        out.print(c[j]);
                out.println();
            }
        }
        in.close();
        out.close();
        System.exit(0);
    }
}