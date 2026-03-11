# Time Complexity : O(N)  # We scan the domino arrays a constant number of times
# Space Complexity : O(1) # Only counters are used
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# The final uniform value must be either A[0] or B[0].
# We count rotations needed to make all elements equal to each candidate value.
# If neither candidate works for all dominoes, return -1.

class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        
        def check(x):
            rotate_top = 0
            rotate_bottom = 0
            
            for i in range(len(tops)):
                if tops[i] != x and bottoms[i] != x:
                    return float('inf')
                elif tops[i] != x:
                    rotate_top += 1
                elif bottoms[i] != x:
                    rotate_bottom += 1
            
            return min(rotate_top, rotate_bottom)
        
        ans = min(check(tops[0]), check(bottoms[0]))
        
        return -1 if ans == float('inf') else ans