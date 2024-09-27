// Problem 1 - Shortest Way to Form String
// Time Complexity: O(n * m)
// Space Complexity: O(1)

class Solution {
    public int shortestWay(String source, String target) {
        // initialize pointers
        int s = 0;
        int t = 0;
        
        int result = 0;
        // while condition until out of bounds for target
        while (t < target.length()) {
            s = 0;
            int prev = t;
            // while condition until out of bounds for target and source
            while (t < target.length() && s < source.length()) {
                if (source.charAt(s) == target.charAt(t)) { // if char same
                    t += 1; // increment target index
                }
                s += 1;// increment source index
            }
            
            if (prev == t) { // if target index did not increment, then invalid character
                return -1;
            }
            
            result += 1; // split found
        }
        
        return result; // return result
    }
}

// Problem 2 - Minimum Domino Rotations For Equal Row
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        // base condition
        if (A == null || A.length == 0 || B == null || B.length == 0 || A.length != B.length) {
            return -1;
        }
        // get rotations count for A[0]
        int result = getRotations(A, B, A[0]);
        if (result != -1 || A[0] == B[0]) { // if rotations not equal to -1 or first element of A and B are equal then return result
            return result;
        }
        // else return rotations count for B[0]
        return getRotations(A, B, B[0]);
    }
    
    private int getRotations(int[] A, int[] B, int num) {
        // initialize rotations for A and B
        int aRot = 0;
        int bRot = 0;
        // loop over array
        for (int i=0; i<A.length; i++) {
            if (A[i] != num && B[i] != num) { // if none of the elements match num, then return -1
                return -1;
            } else if (A[i] != num) { // if num not equal to A's element, then increment count 
                aRot += 1;
            } else if (B[i] != num) { // if num not equal to B's element, then increment count 
                bRot += 1;
            }
        }
        // return min
        return Math.min(aRot, bRot);
    }
}
