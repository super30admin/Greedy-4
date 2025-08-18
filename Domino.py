# Time Complexity: O(n)
# Space Complexity: O(1)
# Approach: We count the number of swaps we need on each side and return the minimum
class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        re = self.helper(tops, bottoms, tops[0])
        if re != -1:
            return re
        return self.helper(tops, bottoms, bottoms[0])

    def helper(self, tops, bottoms, target):
        topR = 0
        botR = 0

        for i in range(len(tops)):
            if tops[i] != target and bottoms[i] != target:
                return -1
            if tops[i] == target and bottoms[i] == target:
                continue
            if tops[i] != target:
                topR += 1
            if bottoms[i] != target:
                botR += 1

        return min(topR, botR)