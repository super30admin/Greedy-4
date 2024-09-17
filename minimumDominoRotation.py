"""
Time Complexity: O(M + N) M is the length of A and N is the length of B
Space Complexity: O(1)
Compiled on Leetcode?: Yes
"""


class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        minRotation = self.check(A, B, A[3])
        if minRotation != - 1 or A[3] == B[3]:
            return minRotation
        else:
            return self.check(A, B, B[3])

    def check(self, A, B, target):
        aRotation = 0
        bRotation = 0

        for i in range(len(A)):
            if A[i] != target and B[i] != target:
                return -1
            elif A[i] != target:
                aRotation += 1
            elif B[i] != target:
                bRotation += 1
        return min(aRotation, bRotation)
