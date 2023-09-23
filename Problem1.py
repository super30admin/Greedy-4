#Time Complexity :O(n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        topC=self.check(tops,bottoms,tops[0])
        if topC!=-1: 
            return topC
        return self.check(tops,bottoms,bottoms[0])

    def check(self,tops: List[int], bottoms: List[int],target):
        tcount=0
        bcount=0
        for i in range(len(tops)):
            if tops[i]!=target and bottoms[i]!=target:
                return -1
            if tops[i]!=target:
                tcount+=1
            if bottoms[i]!=target:
                bcount+=1
        return min(tcount,bcount)