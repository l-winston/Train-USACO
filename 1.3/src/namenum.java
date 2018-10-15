/*
ID: winwins1
LANG: JAVA
TASK: namenum
 */

// http://train.usaco.org/usacoprob2?a=ISbr7Y86zzy&S=namenum

import java.io.*;
import java.util.Scanner;

public class namenum {

    public static void main(String[] args) throws IOException {
        final String probName = "namenum";
        Scanner in = new Scanner(new File(probName + ".in"));
        Scanner din = new Scanner(new File("dict.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        // store id as char array
        char[] id = in.next().toCharArray();

        // keep track if no names match
        boolean none = true;

        // go through dictionary
        loop:
        while(din.hasNext()){
            // read name and store as char array
            String name = din.next();
            char[] ar = name.toCharArray();

            // if lengths don't match, skip it
            if(ar.length != id.length)
                continue;

            // check each digit of number to see if it matches the current name
            for(int i = 0; i < ar.length; i++){
                if(id[i]-'0' != getNum(ar[i]))
                    continue loop;
            }
            // if all digits match then print it and mark none as false
            out.println(name);
            none = false;
        }

        if(none)
            out.println("NONE");

        din.close();
        in.close();
        out.close();
        System.exit(0);
    }

    // converts a char to its Touch-Tone(R) telephone keypad equivalent
    static int getNum(char c){
        if(c == 'Q' || c == 'Z')
            return -1;
        int i = c-'A';
        if(i > 'Q'-'A')
            i--;
        return i/3 + 2;
    }
}