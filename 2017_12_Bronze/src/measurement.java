import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;

public class measurement {

    static StringTokenizer stringTokenizer;
    static BufferedReader in;
    static PrintWriter out;
    static String probName;

    public static void solve() throws IOException {
        // SOLVE HERE
        readLine();
        final int N = readInt();
        Entry[] entries = new Entry[N];
        HashSet<String> names = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            readLine();

            int day = readInt();
            String name = readString();
            int change = readInt();

            if (!names.contains(name)) {
                map.put(name, names.size());
                names.add(name);
            }

            entries[i] = new Entry(day, map.get(name), change);
        }
        Arrays.sort(entries, new Comparator<Entry>() {
            @Override
            public int compare(Entry o1, Entry o2) {
                return o1.day-o2.day;
            }
        });

        int ans = 0;
        int[] milk = new int[names.size()];
        Arrays.fill(milk, 7);
        boolean[] top = new boolean[names.size()];
        Arrays.fill(top, true);

        for (int i = 0; i < N; i++) {
            boolean changed = false;
            milk[entries[i].name] += entries[i].change;
            boolean[] newtop = new boolean[names.size()];
            int max = -1;
            for (int j = 0; j < names.size(); j++) {
                max = Math.max(milk[j], max);
            }
            for (int j = 0; j < names.size(); j++) {
                if (milk[j] == max)
                    newtop[j] = true;
            }
            for (int j = 0; j < names.size(); j++) {
                if (top[j] != newtop[j])
                    changed = true;
            }
            top = newtop;
            ans += changed ? 1 : 0;
            //System.out.println(entries[i].day + " " + Arrays.toString(top));
        }

        out.println(ans);
    }

    static class Entry {
        int day;
        int change;
        int name;

        public Entry(int d, int n, int c) {
            day = d;
            change = c;
            name = n;
        }

        @Override
        public String toString() {
            return day + " " + name + " " + change;
        }
    }

    public static void main(String[] args) throws IOException {
        setup();

        solve();

        cleanup();
    }

    private static void setup() throws IOException {
        probName = "measurement";
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