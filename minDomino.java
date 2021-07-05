//Time Complexity:O(N)
//Space Complexity:O(N)
//Approach- Two array to keep the count of all the elements from 1-6 in both A and B respectively and another array same to keep track of the number of same numbers in both the arrays. If countA[i]+countB[i]-same[i] becomes equal to n, return n-Math.max(countA[i],countB[i]) as it'll indicate the min domino rotations. Else, return -1.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int n=A.length;
        int[] countA= new int[7];
        int[] countB=new int[7];
        int[] same=new int[7];
        
        for(int i=0;i<n;i++){
            countA[A[i]]++;
            countB[B[i]]++;
            
            if(A[i]==B[i]){
                same[A[i]]++;
            }
        }
        
        for(int i=1;i<7;i++){
            if(countA[i]+countB[i]-same[i]==n){
                return n-Math.max(countA[i],countB[i]);
            }
        }
        return -1;
    }
}