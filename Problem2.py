"""
time : o(n)
space : o(1)

"""
class Solution(object):
    
    def check(self,A, B, target):
        rot_a, rot_b = 0,0
        for i in range(len(A)):
            if A[i] != target and B[i] != target: #if target not present in either of the arrays, no solution possible
                return -1
            
            elif A[i] != target: #if not in A, increment rotation
                rot_a += 1
            elif B[i] != target: #similarly for B
                rot_b += 1
        return min(rot_a, rot_b) #return minimum rotation

    def minDominoRotations(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: int
        """
        if len(A) == 1:
            return 0
        res = self.check(A,B, A[0]) #to check arow of A[0] can be formed
        if res != -1:
            return res 
        return self.check(A,B, B[0]) #to check arow of B[0] can be formed

        
        