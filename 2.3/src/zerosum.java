/*
ID: winwins1
LANG: JAVA
TASK: zerosum
 */

/*
1+2-3+4-5-6+7
1+2-3-4+5+6-7
1-2 3+4+5+6+7
1-2 3-4 5+6 7
1-2+3+4-5+6-7
1-2-3-4-5+6+7
*/

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class zerosum {

    public static void main(String[] args) throws IOException {
        final String probName = "zerosum";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        int n = in.nextInt();

        String[] ans = solve(n, 0);

        Arrays.sort(ans);

        for(String s : ans)
            out.println(s);

        in.close();
        out.close();
        System.exit(0);
    }

    static String[] solve(int n, float sum) {
        if (n == 1) {
            if(sum==1)
                return new String[] {"1"};
            else
                return new String[]{};
        }else if(n==2){
            if(sum==3)
                return new String[]{"1+2"};
            else if(sum==12)
                return new String[]{"1 2"};
            else if(sum==-1)
                return new String[]{"1-2"};
            else
                return new String[]{};
        }

        String[] sub = solve(n - 1, sum + n);
        String[] add = solve(n - 1, sum - n);
        String[] dig1 = solve(n - 2, sum - ((n-1)*10 + (n)));
        String[] dig2 = solve(n - 2, sum + ((n-1)*10 + (n)));


        String[] ret = new String[sub.length + add.length + dig1.length+dig2.length];
        for (int i = 0; i < sub.length; i++) {
            ret[i] = sub[i] + "-" + n;
        }
        for (int i = 0; i < add.length; i++) {
            ret[i + sub.length] = add[i] + "+" + n;
        }
        for (int i = 0; i < dig1.length; i++) {
            ret[i + sub.length + add.length] = dig1[i] + "+" + (n-1) + " " + n;
        }
        for (int i = 0; i < dig2.length; i++) {
            ret[i + sub.length + add.length+dig1.length] = dig2[i] + "-" + (n-1) + " " + n;
        }
        return ret;
    }
}