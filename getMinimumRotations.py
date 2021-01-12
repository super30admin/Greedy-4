#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def getMinimumRotations(self, A, B, num):
        aRotation, bRotation = 0, 0

        for i in range(len(A)):
            if A[i] != num and B[i] != num:
                return -1
            elif A[i] != num:
                aRotation += 1
            elif B[i] != num:
                bRotation += 1

        return min(aRotation, bRotation)

    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        if not A or not B:
            return -1

        rots = self.getMinimumRotations(A, B, A[0])
        if rots != -1:
            return rots
        return self.getMinimumRotations(A, B, B[0])
