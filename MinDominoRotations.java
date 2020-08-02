//time o(n)
//space o(1)
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        if(A == null || A.length == 0 || B== null || B.length == 0)
            return 0;
        int maxfreq = 0;
        
        for(int i=1; i<7; i++) {
            int count = 0;
            for(int j =0; j<A.length; j++) {
                if(A[j] == i)
                    count++;
                if(B[j] == i)
                    count++;
            }
            if(count >= A.length) {
                maxfreq = i;
                break;
            }
        }
        
        int aRot = 0, bRot =0;
        
        for(int i=0; i<A.length; i++) {
            if(A[i] != maxfreq && B[i] != maxfreq)
                return -1;
            
            if(A[i] != maxfreq) {
                aRot++;
            }
            if(B[i] != maxfreq) {
                bRot++;
            }
        }
        return Math.min(aRot, bRot);
    }
}