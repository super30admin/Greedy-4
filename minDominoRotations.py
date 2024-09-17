"""
Time complexity O(2N) --> O(N)
Space complexity O(1)

We can take A[0] and B[0] and start checking and increasing Arotation and Brotation and return the minimum. if A[0] or B[0] is not found in any other index of A and B , break and return -1
"""

class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        res = self.check(A, B, A[0])
        if res != -1:
            return res
        return self.check(A, B, B[0])

    def check(self, A, B, target):
        aRot, bRot = 0, 0
        l = len(A)
        for i in range(l):
            if A[i] != target and B[i] != target:
                return -1
            if A[i] != target:
                aRot += 1
            elif B[i] != target:
                bRot += 1
        return min(aRot, bRot)
        