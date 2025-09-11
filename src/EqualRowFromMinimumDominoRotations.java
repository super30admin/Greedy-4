//time complexity- O(n)
//space complexity- O(1)
import java.util.*;
public class EqualRowFromMinimumDominoRotations {
    static int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int count = changeTops(tops, bottoms, tops[0]);
        if(count != -1) return count;
        return changeTops(tops, bottoms, bottoms[0]);
    }
    private static int changeTops(int[] tops, int[] bottoms, int key) {
        int count = 0;
        for(int i = 0; i < tops.length; i++) {
            if(tops[i] != key &&  bottoms[i] != key) return -1;
            if(tops[i] == key) continue;
            if(bottoms[i] == key) count++;
        }

        return count;
    }
    public static void main(String[] args) {
        int[] tops = {2,1,2,4,2,2};
        int[] bottoms = {5,2,6,2,3,2};

        System.out.println("tops: " + Arrays.toString(tops));
        System.out.println("Bottoms: "+ Arrays.toString(bottoms));
        System.out.println("Minimum rotation: " + minDominoRotations(tops, bottoms));
    }
}
