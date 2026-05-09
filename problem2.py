## Problem2:  Equal Row From Minimum Domino Rotations 


# https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        re = self.helper(tops,bottoms,tops[0])
        if re != -1:
            return re
        return self.helper(tops,bottoms,bottoms[0])

    def helper(self,tops,bottoms,target):
        tswap = 0
        bswap = 0 
        for i in range(len(tops)):
            if tops[i] != target and bottoms[i] != target:
                return -1 
            if tops[i] == target and bottoms[i] == target:
                continue 
            if tops[i] != target:
                tswap+=1 
            if bottoms[i] != target:
                bswap+=1
        return min(tswap,bswap)