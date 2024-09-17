#Time COmplexity:O(n)
#Space Complexity:O(n)
#Ran successfully on Leetcode:yes
#Approach:
#1. Create variable max frequency to keep a track of max repeated numbers on dice. 
#2. Iterate through A and B array to find put the maxFreq by checking if the freq is > length of A or B array.
#3. Iterate through A and B and check if that number is equal to maxfreq, and if both are not, return -1. Else if either of them is equal to maxfreq, rotate the other one. 
#4. Return the min(aRot and bRot)



class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        if A is None or len(A)==0:
            return 0
        maxFreq=0
        
        for i in range(1,7):
            freq=0
            for j in range(len(A)):
                if A[j]==i:
                    freq+=1
                if B[j]==i:
                    freq+=1
            if freq>=len(A):
                maxFreq=i
                break
        aRot=0
        bRot=0
        for i in range(len(A)):
            if A[i]!=maxFreq and B[i]!=maxFreq:
                return -1
            elif A[i]!=maxFreq:
                aRot+=1
            elif B[i]!=maxFreq:
                bRot+=1
        return min(aRot,bRot)
    
        
                    
                
