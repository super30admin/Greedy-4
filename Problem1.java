// Time Complexity : O(nlogk)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int shortestWay(String source, String target) {
        int n = target.length();
        HashMap<Character,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < source.length(); i++){
            char ch = source.charAt(i);
            if(!map.containsKey(ch))
                map.put(ch,new ArrayList<>());
            map.get(ch).add(i);
        }
        int count = 1;
        int i = 0;
        int j = 0;
        while(j < n){
            char ch = target.charAt(j);
            if(!map.containsKey(ch))
                return -1;
            List<Integer> li = map.get(ch);
            int k = Collections.binarySearch(li,i);
            if(k < 0){
                k = -k-1;
            }
            if(k >= li.size()){
                count++;
                i = 0;
            }
            else{
                i = li.get(k);
                i++;
                j++;
            }
        }
        return count;
    }
}