'''
Time Complexity : O(2N)
Space Complexity : O(1)
'''
class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:           
        result = self.findRot(A, B, A[0])
        if result != -1:
            return result
    
        return self.findRot(A, B, B[0])
        
    def findRot(self, A, B, target):
        aRot = 0
        bRot = 0
        l = len(A)
        for i in range(0,l):
            if A[i] != target and B[i] != target:
                return -1
            if A[i] != target:
                aRot +=1
            if B[i] != target:
                bRot +=1
        return min(aRot,bRot)