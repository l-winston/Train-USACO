import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class citystate {

    public static void main(String[] args) throws IOException {
        final String probName = "citystate";
        BufferedReader in = new BufferedReader(new FileReader(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int ans = 0;

        HashMap<String, Integer> occur = new HashMap<>();

        for(int i = 0; i < n; i++){
            stringTokenizer = new StringTokenizer(in.readLine());
            String c = stringTokenizer.nextToken().substring(0, 2);
            String s = stringTokenizer.nextToken();
            if(c.equals(s))
                continue;
            String cs = c+s;
            if(occur.containsKey(cs))
                occur.put(cs, occur.get(cs)+1);
            else
                occur.put(cs, 1);
        }

        for(String s : occur.keySet()){
            String other = s.substring(2, 4)+s.substring(0, 2);
            if(occur.containsKey(other))
                ans += occur.get(s) * occur.get(other);
        }

        out.println(ans/2);

        in.close();
        out.close();
        System.exit(0);
    }
}