# solution 1
# Time:O(n)
# SpaceO(1)
# Works on Leet code

class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        minele = 0
        
        for i in range(1,7): # traversing between 1-6 as stated in the question
            freq=0
            for j in range(len(A)):
                if A[j] == i: # checking the frequency of every number in A and B array
                    freq+=1
                if B[j] == i:
                    freq+=1
                
            if freq>=len(A): # checking for the common number
                minele = i
        Arot = 0
        Brot = 0
        
        for i in range(len(A)):
            # checking if there is no common number
            if(A[i]!= minele and B[i]!= minele):
                return -1
            #Rotating the number
            if A[i]!=minele:
                Arot+=1
            if B[i]!=minele:
                Brot+=1
        mini = min(Arot, Brot)
        return mini

# Soultion 2

class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        
        rot = self.check(A, B, A[0]) # checking if A has a common element
    
        if (rot!=-1):
            return rot
        else:
            rot = self.check(A, B, B[0]) # checking if B has a common element
            return rot
        
    def check(self, A, B, x):
        Arot=0
        Brot =0
        
        for i in range(len(A)):
            # checking if there is no common number
            if A[i]!=x and B[i]!=x:
                return -1
            #Rotating the number
            if A[i]!=x:
                Arot+=1
            if B[i]!=x:
                Brot+=1
        mini = min(Arot, Brot)
        return mini
        