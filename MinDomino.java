// TC: O(n)
// SC: O(1)

public class MinDomino {
    public int minDominoRotations(int[] A, int[] B) {
        // checking for A[0] first
        int x = getRot(A,B,A[0]);
        // if val is not -1 or A[0] is same as B[0] directly return the val
        if(x != -1 || A[0] == B[0])
            return x;
        return getRot(A,B,B[0]);
    }
    // getting the rotation count and returning minimum rotations
    private int getRot(int[] A, int[] B, int val){
        int a = 0;
        int b = 0;
        for(int i=0; i<A.length; i++){
            // if val is not in a and b both return -1
            if(A[i] != val && val != B[i]){
                return -1;
            }
            // if not in a rotation is needed
            else if(A[i] != val){
                a++;
            }
            // if not in b rotation is needed
            else if(B[i] != val){
                b++;
            }
        }
        System.out.println(a+","+b);
        return Math.min(a, b);
    }
}
