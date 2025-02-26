# Time complexity - O(n)
# Space complexity - O(1)

# Approach - The idea is for the equal row domino, either the first element of tops or first element of 
# bottoms HAS to be in all upcoming indices (either at the top/bottom). On basis of that we'll calculate
# number of rotations and return minimum of bottom versus top rotations required.

from typing import List
class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        ans = self.findMinRot(tops, bottoms, tops[0])
        if ans != -1:
            return ans
        return self.findMinRot(tops, bottoms, bottoms[0])

    def findMinRot(self, tops: List[int], bottoms: List[int], target: int) -> int:
        tRot = 0
        bRot = 0
        for i in range(len(tops)):
            if tops[i] != target and bottoms[i] != target:
                return -1
            if tops[i] != target:
                tRot += 1
            if bottoms[i] != target:
                bRot += 1
        return min(tRot, bRot)