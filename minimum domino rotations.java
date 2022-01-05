//timecomplexity:- O(n).
//spacecomplexity:-O(1).

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int x=noofrotations(tops,bottoms,tops[0]);
        if(x!=-1|| tops[0]==bottoms[0]){
            return x;
            
        }
        return noofrotations(tops,bottoms,bottoms[0]);
            
        
    }           //greedy idea is here is the number that is repeating more
    //if we find answer for that there is no need to find for other number.
    //therefore sending only first value of tops if first values of both are same and there is no -1 in first array value.
    private int noofrotations(int[] A, int[] B,int val){
        int arotations=0;
        int brotations=0;
        for(int i=0;i<A.length;i++){
            if(A[i]!=val && B[i]!=val){
                return -1;
            }
            else if(A[i]!=val){
                arotations++;
            }
            else if(B[i]!=val){
                brotations++;
            }
            
            
        }
        return Math.min(arotations,brotations);
    }
}