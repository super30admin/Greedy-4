// Time Complexity : O(m*n) where m and n are lengths of strings source and target respectively
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class shortestWayToFormString {
    public int shortestWay(String source, String target) {
        int ptr1 = 0, ptr2 = 0;
        int ans = 0;
        while (ptr2 < target.length()) {
            ptr1 = 0;
            ans++;
            int curr = ptr2;
            while (ptr1 < source.length() && ptr2 < target.length()) {
                if (source.charAt(ptr1) == target.charAt(ptr2)) {
                    ptr1++;
                    ptr2++;
                }
                else {
                    ptr1++;
                }
            }
            if (curr == ptr2) return -1;
        }
        return ans;
    }
}