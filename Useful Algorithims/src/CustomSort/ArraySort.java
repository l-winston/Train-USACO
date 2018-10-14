package CustomSort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by csliu on 9/13/18.
 */
public class ArraySort {
    public static void main(String[] args){
        Element[] elements = {new Element(4), new Element(2), new Element(0)};
        Arrays.sort(elements);
        for(Element e : elements)
            System.out.println(e.value);
    }

    static private class Element implements Comparable<Element>{
        int value;

        public Element(int _value){
            value = _value;
        }

        @Override
        public int compareTo(Element o) {
            //ascending order
            return value-o.value;
        }
    }
}


