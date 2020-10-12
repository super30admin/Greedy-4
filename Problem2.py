#Time complexity : O(n)
#Space complexity: O(1)
#Works on leetcode : yes
#Approach : Since either A or B needs to be all same, we just need to check for A[0] or B[0] as c in all further ith positions. 
#If at A[i] or B[i], we dont have A[0] or B[0] - we return -1. Otherwise we count how many times either A[0] or B[0] appear
#in top or bottom and use these count to get minimum number of flips. 

class Solution(object):
    def minDominoRotations(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: int
        """
        if len(A)!=len(B):
            return -1
        for c in {A[0],B[0]}:
            top,bottom = 0,0
            for i in range(len(A)):
                if c not in {A[i],B[i]}:
                    break
                top +=1 if c!=B[i] else 0
                bottom +=1 if c!=A[i] else 0
            else:
                return min(top,bottom)
        return -1