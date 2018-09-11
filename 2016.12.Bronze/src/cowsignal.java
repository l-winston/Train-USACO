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
            for (int k = 0; k < K; k++) {
                for (int j = 0; j < N; j++)
                    for (int kk = 0; kk < K; kk++)
                        out.print(c[j]);
                out.println();
            }
        }
        in.close();
        out.close();
        System.exit(0);
    }
}