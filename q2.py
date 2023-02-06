# Time Complexity : O(n), Where n is number of elements in tops
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from typing import List

class Solution:
    def minrotation(self,tops,bottoms,value):
        trot,brot=0,0
        n=len(tops)
        for i in range(n):
            if(tops[i]==value or bottoms[i]==value):
                if(tops[i]!=value):
                    trot+=1
                if(bottoms[i]!=value):
                    brot+=1
            else:
                return -1
        return min(trot,brot)
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        answer=self.minrotation(tops,bottoms,tops[0])
        if(answer==-1):
            return self.minrotation(tops,bottoms,bottoms[0])
        return answer