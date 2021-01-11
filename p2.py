#Time: O(N)
#Space: O(1)

class Solution:

    def check(self, A: List[int], B: List[int], x: int) -> int:

       
        moveToTop = 0
        moveToBottom = 0

       
        for i in range(len(A)):

           
            if (A[i] != x and B[i] != x):
                return -1

            
            elif (A[i] != x):
                moveToTop += 1

          
            elif (B[i] != x):
                moveToBottom += 1

       
        return min(moveToTop, moveToBottom)

    def minDominoRotations(self, A: List[int], B: List[int]) -> int:

        
        rotations = self.check(A, B, A[0])
        if (rotations != -1):
            return rotations
        return self.check(A, B, B[0])
