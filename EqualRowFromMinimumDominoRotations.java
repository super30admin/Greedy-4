class EqualRowFromMinimumDominoRotations {
    
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = getRot(tops, bottoms, tops[0]);
        
        if(result != -1 || tops[0] == bottoms[0])
            return result;
        
        return getRot(tops, bottoms, bottoms[0]);
    }
    
    private int getRot(int[] A, int[] B, int val){
        int aRot = 0;
        int bRot = 0;
        
        for(int i = 0; i < A.length; i++){
            if(A[i] != val && B[i] != val)
                return -1;
            else if(A[i] != val)
                aRot++;
            else if(B[i] != val)
                bRot++;
        }
        return Math.min(aRot, bRot);
    }
}