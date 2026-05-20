

/**
 * Builds index mapping for characters in source, then greedily forms target using binary search jumps over these indices.
 * Each pass over target advances through source subsequences, counting how many subsequences are needed.
 * Time Complexity: O((n + m) log n), Space Complexity: O(n), where n = source length, m = target length.
 */
public class ShortestWAyToFormString {
    public int shortestWay(String source, String target) {
       
        HashMap<Character, List<Integer>> map = new HashMap<>();

        for(int i=0; i<source.length(); i++){
            char c = source.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }

        int i = 0, j = 0;
        int count = 0;

        while(j < target.length()){
            char tChar = target.charAt(j);

            if(!map.containsKey(tChar)) return -1;
            
            List<Integer> list = map.get(tChar);
            int idx = binarySearch(list, i);
            if(idx == list.size()){
                i = list.get(0);
                count++;
            }else{
                i = list.get(idx);
                i++; j++;
                if(j == target.length()) return count+1;
            }
        
            if(i == source.length()){
                i = 0;
                count++;
            }
        }

        return -1;
    }

    private int binarySearch(List<Integer> list, int target){
        int low = 0, high = list.size() - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(list.get(mid) == target) return mid;
            else if(list.get(mid) > target) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }   
}
