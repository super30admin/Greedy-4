"""
Comparison/Greedy Approach Optimized --
TC - O(n)
SC - O(1)
"""

class Solution:
    def findMinRotations(self, tops, bottoms, target):
        topRotation = 0
        bottomRotation = 0

        for i in range(len(tops)):
            if tops[i] != target and bottoms[i] != target:
                return -1
            if tops[i] != target:
                topRotation += 1
            if bottoms[i] != target:
                bottomRotation += 1
        return min(topRotation, bottomRotation)

    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        if tops is None or len(tops) == 0 or bottoms is None or len(bottoms) == 0: return -1

        if len(tops) != len(bottoms): return -1

        value = self.findMinRotations(tops, bottoms, tops[0])
        if value == -1:
            return self.findMinRotations(tops, bottoms, bottoms[0])
            # OR
            # value = self.findMinRotations(tops, bottoms, bottoms[0])

        return value
