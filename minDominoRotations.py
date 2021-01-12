class Solution:        
    def (self, A: List[int], B: List[int]) -> int:
            
            def check(num):
                
                first = 0
                second = 0
                
                
                for a, b in zip(A,B):
                    
                    if a!=num and b!=num:
                        return -1
                    elif a!=num:
                        first+=1
                    elif b!=num:
                        second+=1
                    
                return min(first, second)
        
            output = check(A[0])
            
            if output!=-1 or A[0]==B[0]:
                return output
            
            else:
                return check(B[0])

Time: O(N)
Space: O(1)
