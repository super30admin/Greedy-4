class Solution {
    public int minDominoRotations(int[] A, int[] B) {

        if (A == null || B == null) {
            return -1;
        }

        int result = check(A, B, A[0]);

        if (result != -1) {
            return result;
        }

        return check(A, B, B[0]);

    }

    private int check(int[] A, int[] B, int x) {

        int top = 0;
        int bottom = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] != x && B[i] != x) {
                return -1;
            } else if (A[i] != x)
                top++;
            else if (B[i] != x)
                bottom++;

        }

        return Math.min(top, bottom);

    }

}