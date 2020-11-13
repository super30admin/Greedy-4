# // Time Complexity : O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
#  If the answer is valid, check if the num is present in every elment of A&B (cause it HAS to be present in order to give an answer)
# If A and B has two vals that are valid, the minimum rotation would be the same so we can skip checking rotations for second element

class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        
        retVal = self.getRotations(A,B,A[0])
        
        if retVal != -1 or A[0]==B[0]:
            return retVal
        return self.getRotations(A,B, B[0])
    
    def getRotations(self,A,B, val):
        a_rot = 0
        b_rot = 0
        for x in range(len(A)):
            if A[x] != val and B[x]!=val:
                return -1
            elif A[x]!= val:
                a_rot +=1
            elif B[x] != val:
                b_rot +=1
        return min(a_rot, b_rot)
        