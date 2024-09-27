"""
Time Complexity : O(2N) - where N is length of the array given, but this would be worst case scenario
Space Complexity : O(1)- No extra space
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
For this problem, the number that needs to be rotated should be present on every index and in any one array or might be in both
the arrays. SO we would take advantage of this thought process and check if the first value for array A is the one that needs to be 
rotated. For that, if it is not in array A, a would be rotated or if not in b, then B would be rotated. If it is not in any of
them, we cannot rotate and return -1. In case, both arrays have the same value , we do not rotate. After that, if we see that first
value of array A was the right choice, we return the minimum rotation. If not we do the same processing for first value of
array B.
"""


class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:

        result = self.helper(A, B, A[0])
        if result != -1:
            return result
        return self.helper(A, B, B[0])

    def helper(self, A, B, value):
        aRot, bRot = 0, 0
        l = len(A)
        for i in range(l):
            if A[i] != value and B[i] != value:
                return -1
            if A[i] != value:
                aRot += 1
            elif B[i] != value:
                bRot += 1
        return min(aRot, bRot)
