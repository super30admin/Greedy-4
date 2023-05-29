# Time Complexity : O(n), where n is the length of the tops or bottoms lists.
# Space Complexity : O(1)
from typing import List

class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        def checkRotations(target):
            rotations_a = rotations_b = 0
            for i in range(n):
                if tops[i] != target and bottoms[i] != target:
                    return -1
                elif tops[i] != target:
                    rotations_a += 1
                elif bottoms[i] != target:
                    rotations_b += 1
            return min(rotations_a, rotations_b)

        n = len(tops)
        rotations = checkRotations(tops[0])  # Check rotations with tops[0] as target
        if rotations != -1 or tops[0] == bottoms[0]:
            return rotations

        return checkRotations(bottoms[0])  # Check rotations with bottoms[0] as target