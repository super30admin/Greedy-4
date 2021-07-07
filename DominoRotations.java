// 1007.
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        //edge
        if(A == null || B == null || A.length == 0 || A.length != B.length)
        {
            return 0;
        }
        
        return approach2(A, B);
    }
    
    //time - O(length of A or B)
    //space - constant
    private int approach1(int[] A, int[] B) {
        //find a potential candidate taht could be filled through out A or B
        //such a candidate must occure more than (length of 1 array) times
        int candidate = 0;
        for(int i = 1; i < 7; i++)
        {
            //i is a potentail candidate
            int count = 0;
            for(int j = 0; j < A.length; j++)
            {
                //if i is found either in A[] or B[] increment count
                if(A[j] == i)
                {
                    count++;
                }
                if(B[j] == i)
                {
                    count++;
                }
            }
            if(count >= A.length) //if count of i is above A's length, change candidate to i and break
            {
                candidate = i;
                break;
            }
        }
        
        int Arotations = 0;
        int Brotations = 0;
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] != candidate && B[i] != candidate)
            {
                //cant make all elements in either A or B to candidate
                return -1;
            }
            else if(A[i] != candidate)
            {
                //to make all elements in A as candidate rotate A[i]
                Arotations++;
            }
            else if(B[i] != candidate)
            {
                //to make all elements in B as candidate rotate B[i]
                Brotations++;
            }
        }
        
        return Math.min(Arotations, Brotations); //return min among both cases
    }
    
    //time - O(length of A)
    //space - constant
    private int approach2(int[] A, int[] B) {
        //the candidate should be either A[0] or B[0]
        int rotations = Math.min(findRotations(A, B, A[0]), findRotations(A, B, B[0]));
        return rotations == Integer.MAX_VALUE ? -1 : rotations; 
        
    }
    
    private int findRotations(int[] A, int[] B, int candidate) {
        int Arotations = 0;
        int Brotations = 0;
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] != candidate && B[i] != candidate)
            {
                //cant make all elements in either A or B to candidate
                return Integer.MAX_VALUE;
            }
            else if(A[i] != candidate)
            {
                //to make all elements in A as candidate rotate A[i]
                Arotations++;
            }
            else if(B[i] != candidate)
            {
                //to make all elements in B as candidate rotate B[i]
                Brotations++;
            }
        }
        
        return Math.min(Arotations, Brotations); //return min among both cases
    }
}
