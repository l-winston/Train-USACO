package CoordinateCompression;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by csliu on 9/13/18.
 */
public class OneDimension {
    public static void main (String[] args){
        int[] coords = {5, 9, 100, 1550, 2, 344, 1};
        Arrays.sort(coords);
        HashMap<Integer, Integer> coordtocompressed = new HashMap<>();
        for(int i = 0; i < coords.length; i++){
            coordtocompressed.put(coords[i], i);
        }
        System.out.println(coordtocompressed);
    }
}
