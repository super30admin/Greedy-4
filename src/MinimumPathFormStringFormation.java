import java.util.*;
public class MinimumPathFormStringFormation {
//Two pointer method
// time complexity- O(m*n)
//space complexity- O(1)
//    static int shortestWay(String source, String target) {
//        int m = source.length();
//        int n = target.length();
//        HashSet<Character> set = new HashSet<>();
//
//        for(int i = 0; i < m; i++) {
//            set.add(source.charAt(i));
//        }
//        for(int i =0; i <n; i++) {
//            if(!set.contains(target.charAt(i))) return -1;
//        }
//
//        int j = 0;
//        int count = 0;
//        while(j < n) {
//            for(int i = 0; i < m; i++) {
//                if(j == n) break;
//                if(source.charAt(i) == target.charAt(j)) j++;
//            }
//            count++;
//        }
//        return count;
//    }

    //using binary search
    //time complexity- O(n log (k)) where k is avg occurrence of character in string
    //space complexity- O(n)
    static int shortestWay(String source, String target) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int n = source.length();
        for(int i = 0; i < n; i++) {
            if(!map.containsKey(source.charAt(i))) map.put(source.charAt(i), new ArrayList<>());
            map.get(source.charAt(i)).add(i);
        }

        int count = 0;
        int s = 0, t = 0;
        int m = target.length();
        while (t < m){
            if(!map.containsKey(target.charAt(t))) return -1;
            int pos = binarySearch(s, map.get(target.charAt(t)));
            if(pos == map.get(target.charAt(t)).size()) {
                s = map.get(target.charAt(t)).get(0);
                count++;
            } else {
                s = map.get(target.charAt(t)).get(pos) + 1;
                t++;
            }
            if(s == n)  {
                s = 0;
                count++;
            }
        }
        return count;
    }
    static  int binarySearch(int target, List<Integer> li) {
        int low = 0;
        int high = li.size()-1;

        while(low <= high) {
            int mid = low + ( high - low) / 2;
            if(li.get(mid) == target) return mid;
            if(li.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid +1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        String source = "xyz";
        String target = "xzyxz";

        System.out.println("Minimum steps from \""+source+"\" to \""+ target+"\" is: "+ shortestWay(source, target));
    }
}
