// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        
        if(A == null || A.length == 0 || B == null || B.length == 0) {
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0, max = -1;
        
        for(int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(A[i]));
            if(maxFreq >= A.length) {
                max = A[i];
                break;
            }
            map.put(B[i], map.getOrDefault(B[i], 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(B[i]));
            if(maxFreq >= B.length) {
                max = B[i];
                break;
            }
        }
        
        if(max == -1) return -1;
        
        int aRot = 0, bRot = 0;
        
        for(int i = 0; i < A.length; i++) {
            if(A[i] != max && B[i] != max) {
                return -1;
            }
            if(A[i] != max) {
                aRot++;
            }
            if(B[i] != max) {
                bRot++;
            }
        }
        
        return Math.min(aRot, bRot);
    }
}