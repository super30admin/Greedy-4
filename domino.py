# https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:

        def check(tops,bottoms,target):
            top_rotations = 0
            bottom_rotations = 0

            for i in range(len(tops)):
                top = tops[i]
                bottom = bottoms[i]

                if top != target and bottom != target:
                    return -1
                
                if top != target:
                    top_rotations += 1
                
                if bottom != target:
                    bottom_rotations += 1
                
            return min(top_rotations,bottom_rotations)
        
        a = tops[0]
        result = check(tops,bottoms,a)
        if result != -1: 
            return result
        b = bottoms[0]
        result = check(tops,bottoms,b)
        return result

# TC: O(n)
# SC: O(1) 
        