import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


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

    public static void main(String[] args) throws IOException {
        final String probName = "haybales";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        int N = in.nextInt();
        int Q = in.nextInt();

        int[] bales = new int[N];
        for (int i = 0; i < N; i++) {
            bales[i] = in.nextInt();
        }
        Arrays.sort(bales);
        for(int q = 0; q < Q; q++){
            int a = in.nextInt();
            int b = in.nextInt();

            int bale1 = 0, bale2 = 0;

            int i = 0;
            while(i < N && bales[i] < a){
                i++;
                bale1++;
            }
            i = 0;
            while(i < N && bales[i] < b){
                i++;
                bale2++;
            }
            if(i < N && bales[i] == b)
                bale2++;

            out.println(bale2 - bale1);
        }

        in.close();
        out.close();
        System.exit(0);
    }
}