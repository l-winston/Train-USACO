import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class lifeguards {

    static StringTokenizer stringTokenizer;
    static BufferedReader in;
    static PrintWriter out;
    static String probName;

    public static void solve() throws IOException {
        readLine();
        int n = readInt();
        Event[] events = new Event[2*n];
        for(int i = 0; i < n; i++){
            readLine();
            events[i] = new Event(readInt(), i);
            events[i+n] = new Event(readInt(), i);
        }
        Arrays.sort(events);
        int totalTime = 0;
        int[] timelost = new int[n];
        boolean[] on = new boolean[n];
        int activeguards = 0;

        int lasttime = events[0].time;
        for(int i = 0; i < 2*n; i++){
            Event e = events[i];

            if(activeguards == 1){
                timelost[e.id] += e.time - lasttime;
            }

            if(activeguards >= 0){
                totalTime += e.time - lasttime;
            }


            on[e.id] ^= true;

            if(on[e.id]){
                activeguards++;
            }else{
                activeguards--;
            }

            lasttime = e.time;
        }

        System.out.println(totalTime);
        System.out.println(Arrays.toString(timelost));

        System.out.println(Arrays.toString(events));
    }

    public static class Event implements Comparable<Event> {
        int time, id;

        public Event(int _time, int _id) {
            time = _time;
            id = _id;
        }

        @Override
        public int compareTo(Event o) {
            return time - o.time;
        }

        public String toString(){
            return time + " " + id;
        }
    }

    public static void main(String[] args) throws IOException {
        setup();

        solve();

        cleanup();
    }

    private static void setup() throws IOException {
        probName = "lifeguards";
        in = new BufferedReader(new FileReader(probName + ".in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));
    }

    private static void cleanup() throws IOException {
        in.close();
        out.close();
        System.exit(0);
    }

    private static void readLine() throws IOException {
        stringTokenizer = new StringTokenizer(in.readLine());
    }

    private static int readInt() {
        return Integer.parseInt(stringTokenizer.nextToken());
    }

    private static String readString() {
        return stringTokenizer.nextToken();
    }
}