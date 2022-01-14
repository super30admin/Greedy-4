#Time O(n*m), space O(1)
class Solution:
    def shortestWay(self, source: str, target: str) -> int:
    
        #target and source pointers   
        tgt=0
        src=0
        c=0
    #comparing target and source if equal increment pointers otherwise move src to 0
        while tgt<len(target):
            
            if target[tgt] not in source:
                return -1
            
            while src<len(source) and tgt<len(target):
                if source[src]==target[tgt]:
                    tgt+=1
                src+=1
                
            src=0
            c+=1
            
        return c
                
