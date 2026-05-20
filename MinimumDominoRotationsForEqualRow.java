/**
 * Greedy solution: try making all values equal to tops[0] or bottoms[0].
 * For each target, count required rotations for top and bottom rows and take minimum valid result.
 * Time: O(n), Space: O(1) as we only scan arrays with constant extra variables.
 */
public class MinimumDOminoRotationsForEqualRow {
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
