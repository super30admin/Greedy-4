// Time Complexity : O(sl + tl * log(sl)), where sl is the length of the source string and tl is the length of the target string
// Space Complexity : O(sl), where sl is the length of the source string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int shortestWay(String source, String target) {
        int sl = source.length();
        int tl = target.length();
        int count = 1;
        int sp = 0;
        int tp = 0;
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < source.length(); i++){
            char c = source.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        while(tp < tl){
            char tChar = target.charAt(tp);
            if(!map.containsKey(tChar))
                return -1;
            List<Integer> li = map.get(tChar);
            int k = Collections.binarySearch(li, sp);
            if(k < 0){
                k = -k-1;
            }
            if(k == li.size()){
                count++;
                k = 0;
            }
            sp = li.get(k);
            tp++;
            sp++;
        }
        return count;
    }
}