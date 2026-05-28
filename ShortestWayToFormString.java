// Time Complexity : O(mlogk), m= source string length, k = average occurence of each character, worst case
//O(mlogn), n = target string length
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We maintain a hash map for source string characters for faster index search.Now we use 2 pointers to iterate
through source and target strings and leverage the map and binary search to directly jump to the index of
target string's character in the source string if applicable.Whenever we reach end of source string, it means
we completed atleast 1 subsequence and increment count. Similarly, if we reach end of target string, we return
the count.
 */
class Solution {
    public int shortestWay(String source, String target) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int count = 0;

        for(int i = 0 ; i < source.length() ; i++) {
            char ch = source.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(i);
        }

        int i = 0 , j = 0;

        while(j < target.length()) {
            char tChar = target.charAt(j);
            if(!map.containsKey(tChar))
                return -1;
            List<Integer> list = map.get(tChar);
            int idx = binarySearch(list, i);
            if(idx == list.size()) {
                i = list.get(0);
                count++;
            }
            else {
                i = list.get(idx);
                i++;
                j++;
                if(j == target.length())
                    return count + 1;
            }
            if(i == source.length()) {
                i = 0;
                count++;
            }
        }
        return -1;
    }

    private int binarySearch(List<Integer> list, int target) {
        int low = 0 , high = list.size() - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(list.get(mid) == target)
                return mid;
            else if(list.get(mid) > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}