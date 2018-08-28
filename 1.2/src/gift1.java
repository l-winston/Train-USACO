/*
ID: winwins1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

// http://train.usaco.org/usacoprob2?a=y75ibIUQe5R&S=gift1

public class gift1 {

    public static void main(String[] args) throws IOException {
        final String probName = "gift1";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        int n = in.nextInt();

        HashMap<String, Integer> names = new HashMap<String, Integer>();
        String[] nameorder = new String[n];

        int[] money = new int[n];
        for(int i = 0; i < n; i++){
            String name = in.next();
            names.put(name, i);
            nameorder[i] = name;
        }

        while(in.hasNext()){
            String giver = in.next();
            int amt = in.nextInt();
            int people = in.nextInt();
            if(people == 0)
                continue;
            int split = amt / people;
            money[names.get(giver)] -= amt - amt%people;
            for(int i = 0; i < people; i++){
                String person = in.next();
                money[names.get(person)] += amt/people;
            }
        }

        for(int i = 0; i < n; i++){
            out.println(nameorder[i] + " " + money[i]);
        }

        out.close();
        System.exit(0);
    }
}