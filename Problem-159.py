'''
leetcode - 1007. Minimum Domino Rotations For Equal Row
time complexity - O(N)
space complexity -o(1)
approach - 1) first the x should present in all pairs
           2) first we check A[0] and then we go for B[0]
           
'''




class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        retval=self.check(A,B,A[0])
        if retval!=-1 or A[0]==B[0]:
            return retval
        return self.check(A,B,B[0])
            

        
        
        
    def check(self,A,B,x):
        a_rot=0
        b_rot=0
        for i in range(len(A)):
            if A[i]!=x and B[i]!=x:
                return -1
            elif A[i]!=x:
                a_rot+=1
            elif B[i]!=x:
                b_rot+=1
        return min(a_rot,b_rot)