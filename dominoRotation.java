//time complexity O(7n) => O(n)
//space complexity O(1)

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        if(A == null || A.length == 0) return 0;
        int maxFreq = 0;
        for(int i = 1; i < 7; i++){
            int count = 0;
            for(int j = 0; j < A.length; j++){
                if(A[j] == i) count++;
                if(B[j] == i) count++;
            }
            if(count >= A.length) {
                maxFreq = i;
                break;
            }
        }
        
        int aRot = 0; int bRot = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != maxFreq && B[i] != maxFreq) return -1;            
            if(A[i] != maxFreq) aRot++;
            if(B[i] != maxFreq) bRot++;
        }
        return Math.min(aRot, bRot);
    }
}

//time complexity O(2n)
//space complexity O(1)

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        if(A == null || A.length == 0) return 0;
        int result = check(A, B, A[0]);
        if(result != -1) return result;
        return check(A, B, B[0]);

    }
    private int check(int[] A, int[] B, int target){
        int aRot = 0; int bRot = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != target && B[i] != target) return -1;
            if(A[i] != target) aRot++;
            if(B[i] != target) bRot++;
        }
        return Math.min(aRot, bRot);
    }
}
