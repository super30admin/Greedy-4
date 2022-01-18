# 1007. Minimum Domino Rotations For Equal Row
# https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

# Logic: We start at any pair of top and bottom element. 
# We then iterate with once top as target and then bottom 
# as target. We count and return the min count changes 
# for bottom and top. If the target is not equal to both, 
# return -1.

# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def _helper(self, tops, bottoms, target):
        topCount = 0
        bottomCount = 0
        
        for i in range(len(tops)):
            if tops[i] != target and bottoms[i] != target:
                return -1
            
            if tops[i] != target:
                topCount += 1
            elif bottoms[i] != target:
                bottomCount += 1
            
        return min(topCount, bottomCount)
    
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        result = self._helper(tops, bottoms, tops[0])
        
        if result != -1:
            return result
        return self._helper(tops, bottoms, bottoms[0])