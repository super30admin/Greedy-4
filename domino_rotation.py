# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        num1_rot = self.calc_min(tops[0], tops, bottoms)
        num2_rot = self.calc_min(bottoms[0], tops, bottoms)

        re = min(num1_rot,num2_rot)

        return re if re != float('inf') else -1
    
    def calc_min(self, num, tops, bottoms):
        up_count, down_count = 0,0
        for i in range(len(tops)):
            if tops[i] == num and bottoms[i] != num:
                down_count += 1
            elif bottoms[i] == num and tops[i] != num:
                up_count += 1
            elif tops[i] == num and bottoms[i] == num:
                continue
            else:
                return float('inf')
        
        return min(up_count, down_count)