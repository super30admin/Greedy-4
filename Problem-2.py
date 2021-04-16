#Time Complexity :o(n)
#Space Complexity :o(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    def minDominoRotations(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: int
        """
        
        ans1=self.check(A,B,A[0])
        ans2=self.check(A,B,B[0])
        return max(ans1,ans2)
    
    def check(self,A,B,num):
        cntA=0
        cntB=0
        for i in range(len(A)):
            if(A[i]!=num and B[i]!=num):
                return -1
            
            if(A[i]!=num):
                cntA+=1
            elif(B[i]!=num):
                cntB+=1
        return min(cntA,cntB)