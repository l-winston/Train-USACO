import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class lasers {

    static StringTokenizer stringTokenizer;
    static BufferedReader in;
    static PrintWriter out;
    static String probName;

    static int N;

    public static void solve() throws IOException {
        readLine();
        N = readInt();
        int lx = readInt();
        int ly = readInt();
        int bx = readInt();
        int by = readInt();

        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            readLine();
            points.add(new Point(readInt(), readInt()));
        }

        points.add(new Point(lx, ly));
        points.add(new Point(bx, by));

        Collections.sort(points, (Point o1, Point o2) -> o1.x-o2.x);

        int counterX = 0;
        int[] newX = new int[N];
        newX[0] = 0;
        for (int i = 1; i < N; i++) {
            newX[i] = points.get(i).x == points.get(i - 1).x ? counterX : ++counterX;
        }
        for (int i = 0; i < N; i++) {
            points.get(i).x=newX[i];
        }

        Collections.sort(points,(Point o1, Point o2)->o1.y-o2.y);

        int counterY = 0;
        int[] newY = new int[N];
        newY[0] = 0;
        for (int i = 1; i < N; i++) {
            newY[i] = points.get(i).y == points.get(i - 1).y ? counterY : ++counterY;
        }
        for (int i = 0; i < N; i++) {
            points.get(i).y=newY[i];
        }

        int length = dfs(new Point(lx, ly), new boolean[N]);
    }

    private static int dfs(Point p, boolean[] visited){
        return 0;
    }

    private static class Point {
        int x, y;

        public Point(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }

        public boolean equals(Point p){
            return x==p.x && y==p.y;
        }
    }

    public static void main(String[] args) throws IOException {
        setup();

        solve();

        cleanup();
    }

    private static void setup() throws IOException {
        probName = "lasers";
        in = new BufferedReader(new FileReader(probName + ".in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));
    }

    private static void cleanup() throws IOException {
        in.close();
        out.close();
        System.exit(0);
    }

    static private void readLine() throws IOException {
        stringTokenizer = new StringTokenizer(in.readLine());
    }

    static private int readInt() {
        return Integer.parseInt(stringTokenizer.nextToken());
    }

    static private String readString() {
        return stringTokenizer.nextToken();
    }
}