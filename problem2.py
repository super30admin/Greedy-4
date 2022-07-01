#Equal Row From Minimum Domino Rotations
# // Time Complexity : O(N)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        
        def findRotations(tops, bottoms, target):
            t=0
            b=0
            for i in range(len(tops)):
                if tops[i]!= target and bottoms[i]!=target:
                    return -1
                    
                if tops[i]!=target:
                    t+=1
                if bottoms[i]!=target:
                    b+=1
            return min(t, b)
                    
                    
        
        t=findRotations(tops,bottoms,tops[0])               #first, make the target the first domino of the tops, then check the minimum rotation for it 
        if t!=-1:                                           #if the first returns an answer, then thats the answer
            return t
            
        return findRotations(tops,bottoms,bottoms[0])       #if not, try with the first one of bottoms list
        
        
        