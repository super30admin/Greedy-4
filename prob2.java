// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int [] freqT = new int[6+1];
        int [] freqB = new int[6+1];
        int [] freqM = new int [6+1];
        int matchedNo = -1;
        for(int i=0;i<n;i++){
            int valA = tops[i];
            int valB = bottoms[i];
            if(valA==valB){
                freqM[valA]++;
            }
            freqT[valA]++;
            freqB[valB]++;
        }
        for(int i=0;i<7;i++){
            if(freqT[i]+(freqB[i]-freqM[i]) == n){
                matchedNo=i;
                break;
            }
        }
        if(matchedNo==-1){
            return -1;
        }
        return Math.min(freqT[matchedNo]-freqM[matchedNo],freqB[matchedNo]-freqM[matchedNo]);
    }
}
