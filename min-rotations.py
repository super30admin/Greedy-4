# TIME COMPLEXITY: O(N)
# SPACE COMPLEXITY: O(1)

class Solution(object):
    def minDominoRotations(self, A, B):

        result = self.check(A, B, A[0])
        if result != -1:
            return result
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
