//Time Complexity: O(m log k) which can be O(m log n) in the worst case. (m is length of target, n is length of source and k is the average occurrence of each character.
// Space Complexity: O(n) — stores all source indices grouped by character.

// Build a map from character → sorted list of indices in source.
// Scan target with a pointer i into source; for each target char, binary search its list for the first index ≥ i.
// If found, move i to that index+1; if not, start a new subsequence (count++), set i to first index+1 for that char; at the end, return count+1.

class Solution {
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
            int idx = Collections.binarySearch(list, i);
            if(idx < 0){
                idx = -idx - 1;
            }
            if(idx == list.size()){
                i = list.get(0);
                count++;
            }else{
                i = list.get(idx);
            }
             
            i++; j++;
            if(j == target.length()) {
                return count+1;
            }
        
            if(i == source.length()){
                i = 0;
                count++;
            }
        }
        return -1;
    }
}
