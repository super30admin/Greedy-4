// Time Complexity: O(n) – at most two full scans of the arrays (one per candidate target).
// Space Complexity: O(1) – only constant counters and indices.

// Try target = tops[0]: scan all dominoes; if neither side equals target return -1; otherwise count topR (make tops target) and botR (make bottoms target).
// If that fails, try target = bottoms[0] with the same counting logic.
// Return the minimum rotations between topR and botR for the first viable target (or the second if the first is impossible).

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
  
        int re = helper(tops, bottoms, tops[0]);
        if(re != -1) return re;

        return helper(tops, bottoms, bottoms[0]);
    }

    private int helper(int[] tops, int[] bottoms, int target){

        int topR = 0, botR = 0;

        for(int i=0; i<tops.length; i++){
            if(tops[i] != target && bottoms[i] != target) return -1;
            if(tops[i] == target && bottoms[i] == target) continue;
            if(tops[i] != target) topR++;
            if(bottoms[i] != target) botR++;
        }

        return Math.min(topR, botR);
    }
}
