class Solution:
    
    """
    Description: Return the minimum number of rotations so that all the values in top and bottom halves of the dominos
    
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Approach:
    1. Define a function to take a candidate and check the nummber of rotations (considering candidate must be present in each pair of A and B)
       - if candidate is not viable return -1
       - if candidate is viable, return minimum number of rotations
    2. Check with candidate as first value of A, if it gives a viable output (!= -1), return the result
    3. if #2 fails, return result with candidate as first value of B
    """
    
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        
        result = self.findRotations(A[0], A, B)
        if result != -1: return result
        return self.findRotations(B[0], A, B)
            
    def findRotations(self, candidate, A, B):
        rotA = 0; rotB = 0
        for i in range(len(A)):
            if A[i] != candidate and B[i] != candidate: return -1
            elif A[i] != candidate: rotA += 1
            elif B[i] != candidate: rotB += 1
                
        return min(rotA, rotB)
