# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        if not A:
            return 0
        
        maxFreq = 0
        mx = -1
        mapping = {}
        
        for i in range(len(A)):
            first = A[i]
            if first not in mapping:
                mapping[first] = 1
            else:
                mapping[first] += 1
                
            fCount = mapping[first]
            
            if fCount >= len(A):
                mx = A[i]
            
            second = B[i]
            if second not in mapping:
                mapping[second] = 1
            else:
                mapping[second] += 1
            
            sCount = mapping[second]
            if sCount >= len(A):
                mx = B[i]
            
        aRot = bRot = 0
        
        for i in range(len(A)):
            if A[i] != mx and B[i] != mx:
                return -1
            elif A[i] != mx:
                aRot += 1
            elif B[i] != mx:
                bRot += 1
                
        return min(aRot, bRot)