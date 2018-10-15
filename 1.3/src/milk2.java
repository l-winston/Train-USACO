/*
ID: winwins1
LANG: JAVA
TASK: milk2
 */

// http://train.usaco.org/usacoprob2?a=y75ibIUQe5R&S=milk2

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class milk2 {

    public static void main(String[] args) throws IOException {
        final String probName = "milk2";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        int n = in.nextInt();

        Time[] times = new Time[n];
        for (int i = 0; i < n; i++) {
            times[i] = new Time(in.nextInt(), in.nextInt());
        }

        // sort
        Arrays.sort(times, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                return o1.start-o2.start;
            }
        });

        // merge times that overlap
        for (int i = 0; i < n-1; i++) {
            Time curr = times[i];
            Time next = times[i+1];

            if(curr.stop < next.start)
                continue;
            if(curr.stop < next.stop) {
                curr.stop = next.stop;
                next.start = next.stop = curr.stop;
            }else{
                next.start = next.stop = curr.stop;
            }
        }

        int longmilk = 0;
        int longbreak = 0;
        int currmilk = 0;

        // sum up longest milk times and break times
        for(int i = 0; i < n-1; i++){
            Time curr = times[i];
            Time next = times[i+1];

            currmilk += curr.stop - curr.start;
            longmilk = Math.max(currmilk, longmilk);

            if(curr.stop != next.start) {
                longbreak = Math.max(next.start - curr.stop, longbreak);
                currmilk = 0;
            }
        }

        // special case when n==1
        if(n==1) {
            longmilk = times[0].stop - times[0].start;
            longbreak = 0;
        }

        out.println(longmilk + " " + longbreak);

        in.close();
        out.close();
        System.exit(0);
    }
}

class Time{
    int start, stop;
    public Time(int start, int stop){
        this.start = start;
        this.stop = stop;
    }
}