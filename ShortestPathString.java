

//Two pointer solution

import java.util.HashSet;

public class ShortestPathString{
    public int shortestWay(String source, String target) {
         int i =0;
         int j =0;
         HashSet<Character> set = new HashSet<>();
         for(int k=0; k<source.length();k++) {
            if(!set.contains(source.charAt(k))) {
                set.add(source.charAt(k));
            }
         }
         int count = 0;
         while(j < target.length()) {
            if(!set.contains(target.charAt(j))) {
                return -1;
            }
            if(i > source.length()) {
                count++;
                i=0;
            }
            if(source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            }  else {
                i++;
            }
         }
         return count;
    }
}