// Time Complexity : O(mlogk) which can be O(m log n) in the worst case. (m is length of target, n is length of source and k is the average occurrence of each character.)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//We build a map of all character positions in source to help us search faster.
//For each character in target, you binary search (using a built-in method) to get the next valid position in source.
//If we run out of source, we reset and count one subsequence used, repeating until target is formed.
class Solution {
    public int shortestWay(String source, String target) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int sp = 0;//pointer at source
        int tp = 0; //pointer at target
        int count = 0;
        for (int i = 0; i < source.length(); i++) {
            char sChar = source.charAt(i);
            if (!map.containsKey(sChar)) {
                map.put(sChar, new ArrayList<>());
            }
            //alreadt present add the index
            map.get(sChar).add(i);
        }

        //process target
        while (tp < target.length()) {
            char tChar = target.charAt(tp);

            if (!map.containsKey(tChar))
                return -1;
            //get the list corresponding to that char
            List<Integer> li = map.get(tChar);
            int k = Collections.binarySearch(li, sp);
            if (k < 0) { //closest number
                k = -k - 1;
            }
            if (k == li.size()) {
                //target not found
                sp = li.get(0);
                count++;
            } else {
                //target is a the index k
                sp = li.get(k);
            }
            tp++;
            sp++;
        }
        return count +1;
    }
}
