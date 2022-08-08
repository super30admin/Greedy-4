# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:

        num_rot = min(self.numRotations(A[0], A, B), self.numRotations(B[0], A, B))

        return num_rot if num_rot != 20000 else -1

    def numRotations(self, target, A, B):
        rotA, rotB = 0, 0

        for i in range(len(A)):
            if A[i] != target and B[i] != target:
                return 20000

            elif A[i] == target and B[i] == target:
                continue

            elif A[i] != target:
                rotA += 1
            else:
                rotB += 1

        return min(rotA, rotB)
