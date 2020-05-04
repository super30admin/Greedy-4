// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
In this problem we have to find the min no of rortations required to make all the elements in row A or row B as equal.
so we start with first element in row A and calculate number of rotations to be done in row A or row B to make all the elements in the given row the same.If it gives -1 then we have to do the same procedure using the first element of row B.


# Time complexity --> o(n)
# space complexity --> o(1)
class Solution(object):
    def check(self,A,B,X):
        top=0
        bottom=0
        for i in range(len(A)):
        #we check if both are notk equal to the given element then we return -1
            if A[i]!=X and B[i]!=X:
                return -1
            #if not present in row A,it should definitely be in row B
            if A[i]!=X:
                top=top+1
            #If not present in row B then it should be present in row A.
            if B[i]!=X:
                bottom=bottom+1
        #we needed the min number of rotations required for to have the same elements in row A or in row B
        return min(top,bottom)
                
    def minDominoRotations(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: int
        """
        #we check with first element of row A,the element should be present in either of the two rows
        val=self.check(A,B,A[0])
        if val==-1:
        #else we check with the first element of row B.
            return self.check(A,B,B[0])
        else:
            return val
        
        