/*
ID: winwins1
LANG: JAVA
TASK: friday
 */

// http://train.usaco.org/usacoprob2?a=y75ibIUQe5R&S=friday

import java.io.*;
import java.util.Scanner;

public class friday {
    static int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //days per month (not leap)

    public static void main(String[] args) throws IOException {
        final String probName = "friday";
        Scanner in = new Scanner(new File(probName + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));

        int[] week = new int[7]; //number of days that are 13ths for each day of the week
        int n = in.nextInt();

        int day = 0; //first 13th of 1900 is a saturday, which needs to be first number in output

        for(int year = 1900; year < 1900+n; year++){
            for(int month = 0; month < 12; month++){
                week[day]++;
                day = (day+monthlength(month, year))%7; //add # of days in month to get next month's 13th
            }
        }

        for(int i = 0; i < week.length; i++){
            if(i==week.length-1)
                out.print(week[i] + "\n");
            else
                out.print(week[i] + " ");
        }

        in.close();
        out.close();
        System.exit(0);
    }

    //determine momth length given a month and year
    static int monthlength(int month, int year){
        if(month == 1)
            if (isLeap(year))
                return months[month] + 1;

        return months[month];
    }

    //determine if year is leap given year
    static boolean isLeap(int year){
        return year % 4 == 0 && (year % 100 != 0 || year % 400 ==  0);
    }
}