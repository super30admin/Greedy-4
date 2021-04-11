#Time Complexity:O(n)
#Space Complexity:O(1)
#Approach:check for the number of rotations required for the first element of A and B. if neither of the elements can be used for rotation , return -1
#if any one of them can be used for rotation return the minimum rotation required.
class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        if not A or not B:
            return 0
        result=self.check(A,B,A[0])                             
        if result!=-1:
            return result
        return self.check(A,B,B[0])
    
    def check(self,A:List[int],B:List[int],target:int)->int:
        aRot=0
        bRot=0
        for i in range(len(A)):
            if A[i]!=target and B[i]!=target:
                return -1
            if A[i]!=target:
                aRot+=1
            if B[i]!=target:
                bRot+=1
        return min(aRot,bRot)