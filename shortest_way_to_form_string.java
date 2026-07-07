// Time Complexity : O(s + t log s) where s is source length and t is target length
// Space Complexity : O(s) for storing character indices of source
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We store all indices of each character in source using a HashMap.
// For each target character, we use Binary Search to find the next valid position in source after the current pointer.
// If no valid position exists, we start a new subsequence from source and continue matching.

class Solution {
    public int shortestWay(String source, String target) {
        HashMap<Character, List<Integer>> map = new HashMap<>();

        // store character positions from source
        for(int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }

        int i = 0, j = 0, count = 0;

        while(j < target.length()) {
            char tChar = target.charAt(j);

            if(!map.containsKey(tChar)) return -1;

            List<Integer> list = map.get(tChar);
            int idx = binarySearch(list, i);

            // need new subsequence
            if(idx == list.size()) {
                i = list.get(0);
                count++;
            } else {
                i = list.get(idx);
                i++;
                j++;

                if(j == target.length()) return count + 1;
            }

            if(i == source.length()) {
                i = 0;
                count++;
            }
        }

        return -1;
    }

    private int binarySearch(List<Integer> list, int target) {
        int low = 0, high = list.size() - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(list.get(mid) == target) return mid;
            else if(list.get(mid) > target) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }
}
