import java.io.*;
import java.util.Scanner;

public class UsacoTemplate {

    public static void main(String[] args) throws IOException {
        final String probName = "TEMPLATE";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));


        in.close();
        out.close();
        System.exit(0);
    }
}