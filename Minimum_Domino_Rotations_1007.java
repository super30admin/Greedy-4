//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.HashMap;

class Minimum_Domino_Rotations_1007 {
    public int minDominoRotations(int[] A, int[] B) {
        int result = helper(A, B, A[0]);
        if(result != -1) 
            return result;
        return helper(A, B, B[0]);
    }
    private int helper(int[] A, int[] B, int num)
    {
        int aCount = 0;
        int bCount = 0;
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] != num && B[i] != num)
                return -1;
            if(A[i] != num)
               aCount++; 
            if(B[i] != num)
               bCount++; 
        }
        return Math.min(aCount, bCount);
    }
//    Using HashMap
//    public int minDominoRotations(int[] A, int[] B) {
//        //if(A == null ||)
//        int freq = 0;
//        int num = -1;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i < A.length; i++)
//        {
//            map.put(A[i], map.getOrDefault(A[i], 0) +1);
//            freq = Math.max(map.get(A[i]), freq);
//            if(freq >= A.length)
//            {
//                num = A[i];
//                break;
//            }
//            map.put(B[i], map.getOrDefault(B[i], 0) +1);
//            freq = Math.max(map.get(B[i]), freq);
//            if(freq >= A.length)
//            {
//                num = B[i];
//                break;
//            }
//        }
//        if(num == -1)
//            return -1;
//        int aCount = 0;
//        int bCount = 0;
//        for(int i = 0; i < A.length; i++)
//        {
//            if(A[i] != num && B[i] != num)
//                return -1;
//            if(A[i] != num)
//               aCount++; 
//            if(B[i] != num)
//               bCount++; 
//        }
//        return Math.min(aCount, bCount);
//    }
}