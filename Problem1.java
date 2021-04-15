//time complexity-O(n)
//Space complexity-O(1)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        //possible solution only if either of arrays have their element equals to first element of either arrays.
        for(int i=0, a=0,b=0;i<A.length && (A[i]==A[0] || B[i]==A[0]);i++){
            if(B[i]!=A[0]) a++;
            if(A[i]!=A[0]) b++;
            if(i==A.length-1) return Math.min(a,b);
            
        }
        for(int i=0, a=0,b=0;i<A.length && (B[i]==B[0] || A[i]==B[0]);i++){
            if(A[i]!=B[0]) a++;
            if(B[i]!=B[0]) b++;
            if(i==A.length-1) return Math.min(a,b);
        }
        return -1;
    }
}