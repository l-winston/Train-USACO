import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class billboard {

    static StringTokenizer stringTokenizer;
    static BufferedReader in;
    static PrintWriter out;
    static String probName;

    public static void solve() throws IOException {
        // SOLVE HERE
        readLine();
        Rect b1 = new Rect(readInt(), readInt(), readInt(), readInt());
        readLine();
        Rect b2 = new Rect(readInt(), readInt(), readInt(), readInt());
        readLine();
        Rect t = new Rect(readInt(), readInt(), readInt(), readInt());
        out.println(overlap(b1.x, b1.y, b1.x2, b1.y2, t.x, t.y, t.x2, t.y2) + overlap(b2.x, b2.y, b2.x2, b2.y2, t.x, t.y, t.x2, t.y2));
    }

    static int overlap(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int visibleArea = areaOfRectangle(x1, y1, x2, y2);

        // compute the boundaries of the intersection
        int leftmostBlockedX = Math.max(x1, x3);
        int rightmostBlockedX = Math.min(x2, x4);
        int bottommostBlockedY = Math.max(y1, y3);
        int topmostBlockedY = Math.min(y2, y4);
        // if the second rectangle does exist, subtract out the area that it blocks
        if(leftmostBlockedX < rightmostBlockedX && bottommostBlockedY < topmostBlockedY) {
            visibleArea -= areaOfRectangle(leftmostBlockedX, bottommostBlockedY, rightmostBlockedX, topmostBlockedY);
        }

        return visibleArea;
    }

    public static int areaOfRectangle(int x1, int y1, int x2, int y2) {
        return (x2-x1)*(y2-y1);
    }

    public static class Rect {
        int x, y, x2, y2;

        public Rect(int x, int y, int x2, int y2) {
            this.x = x;
            this.y = y;
            this.y2 = y2;
            this.x2 = x2;
        }

    }

    public static void main(String[] args) throws IOException {
        setup();

        solve();

        cleanup();
    }

    private static void setup() throws IOException {
        probName = "billboard";
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