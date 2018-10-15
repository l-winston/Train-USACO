package CustomSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by csliu on 9/13/18.
 */
public class ArrayListSort {
    public static void main(String[] args){
        ArrayList<Element> elements = new ArrayList<Element>();
        elements.add(new Element(4));
        elements.add(new Element(2));
        elements.add(new Element(0));
        Collections.sort(elements, new Comparator<Element>(){
            @Override
            public int compare(Element o1, Element o2) {
                return o1.value-o2.value;
            }
        });
        for(Element e : elements)
            System.out.println(e.value);
    }
    private static class Element{
        int value;
        public Element(int _value){
            value = _value;
        }
    }
}


