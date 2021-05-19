class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        //trying to rotate with respect to tops[0]
        int result = rotations(tops, bottoms, tops[0]);
        
        if(result != -1 || tops[0] == bottoms[0]){
            return result;
        }
        
        //trying to rotate with respect to bottoms[0]
        return rotations(tops, bottoms, bottoms[0]);
    }
    
    public int rotations(int[] A, int[] B, int val){
        int aRotations = 0;
        int bRotations = 0;
        
        for(int i = 0; i < A.length; i++){
            //if both the values are not equal to the value, return -1
            if(A[i] != val && B[i] != val){
                return -1;
            }else if(A[i] != val){//if A[i] dosesnt match the value, we rotate A
                aRotations++;
            }else if(B[i] != val){//if B[i] dosent match the value, we rotate B
                bRotations++;
            }
        }
        
        //returning min of A and B rotations
        return Math.min(aRotations, bRotations);
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)