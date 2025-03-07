import java.util.*;
public class wayToFotmString {
        public int shortestWay(String source, String target) {
            if(source == null || source.length() ==0){
                return -1;
            }
            HashMap<Character, List<Integer>> map = new HashMap<>();
            int left =0;
            int right =0;
            int count =1;

            for(int i=0; i<source.length(); i++){
                char c = source.charAt(i);
                if(!map.containsKey(c)){
                    map.put(c, new ArrayList<>());
                }
                map.get(c).add(i);
            }

            while(right < target.length()){
                char c = target.charAt(right);
                if(!map.containsKey(c)){
                    return -1;
                }
                List<Integer> li = map.get(c);
                int k = Collections.binarySearch(li, left);
                if(k <0){
                    k = -k -1;
                }
                if(k == li.size()){
                    left =0;
                    count++;
                }
                else {
                    left = li.get(k);
                    left++;
                    right++;
                }
            }
            return count;
        }
    }
