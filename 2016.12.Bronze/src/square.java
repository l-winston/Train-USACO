import java.io.*;
import java.util.Scanner;

public class square {

    public static void main(String[] args) throws IOException {
        final String probName = "square";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        Point p1 = new Point(in.nextInt(), in.nextInt());
        Point p2 = new Point(in.nextInt(), in.nextInt());
        Point p3 = new Point(in.nextInt(), in.nextInt());
        Point p4 = new Point(in.nextInt(), in.nextInt());

        // find smallest x coord
        int x1 = Math.min(p1.x, p3.x);
        // find largest x coord
        int x2 = Math.max(p2.x, p4.x);
        // find smallest y coord
        int y1 = Math.min(p1.y, p3.y);
        // find largest y coord
        int y2 = Math.max(p2.y, p4.y);

        // calculate smallest square side
        int maxside = Math.max(x2-x1, y2-y1);

        // square it
        out.println(maxside*maxside);

        in.close();
        out.close();
        System.exit(0);
    }
}

class Point{
    int x, y;
    public Point(int _x, int _y){
        x=_x;
        y=_y;
    }
}