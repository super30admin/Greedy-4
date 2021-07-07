//time o(mn), m is the len of the source, n is the len of the target
//space o(1)
class Solution {
    public int shortestWay(String source, String target) {
        int len1 = source.length(), len2 = target.length();
        int res = 0;
        int sp=0, tp=0;
        
        while(tp < len2) {
            res++;
            sp=0;
            //for edge case, if the cur char doesn't exist in source string at all
            int cur = tp;
            while(sp < len1 && tp < len2) {
                char ch1 = source.charAt(sp);
                char ch2 = target.charAt(tp);
                if(ch1 == ch2) {
                    sp++;
                    tp++;
                }
                else {
                    sp++;
                }
            }
            if(cur == tp)
                return -1;
        }
        return res;
    }
}

//time o(n)
//space o(1)
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        if(A == null || A.length == 0 || B== null || B.length == 0)
            return 0;
        int res = check(A, B, A[0]);
        if(res != -1) {
            return res;
        }
        return check(A, B, B[0]);
    }
    
    private int check(int[] A, int[] B, int target) {
        int aRot = 0, bRot =0;
        
        for(int i=0; i<A.length; i++) {
            if(A[i] != target && B[i] != target)
                return -1;
            
            if(A[i] != target) {
                aRot++;
            }
            if(B[i] != target) {
                bRot++;
            }
        }
        return Math.min(aRot, bRot);
    }
}