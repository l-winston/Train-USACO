import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


/*

[2, 3, 5, 7]
2 3
2 4
2 5
2 7
4 6
8 10

* */

public class haybales {
    static int[] bales;
    static int N;

    public static void main(String[] args) throws IOException {
        final String probName = "haybales";
        BufferedReader in = new BufferedReader(new FileReader(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        int Q = Integer.parseInt(stringTokenizer.nextToken());

        bales = new int[N];
        stringTokenizer = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            bales[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(bales);

        for (int i = 0; i < Q; i++) {
            stringTokenizer = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int before_a = find(a-1);
            int before_b = find(b);
            int ans = before_b-before_a;

            out.println(ans);
        }

        in.close();
        out.close();
        System.exit(0);
    }

    static int find(int e) {
        return search(0, N - 1, e);
    }

    static int search(int l, int r, int e) {
        if(l>r)
            return r;
        int mid = (l + r) / 2;
        if (bales[mid] == e)
            return mid;
        else if (e < bales[mid])
            return search(l, mid - 1, e);
        else if (e > bales[mid])
            return search(mid + 1, r, e);
        return -1;
    }
}