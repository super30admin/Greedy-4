# Time Complexity : O((m*n)), Where m,n are length of target and source respectively
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        #Edge case
        if(len(source)==0):
            return -1
        
        hashset=set()#This will make the job easy
        for k in source:
            hashset.add(k)
        #print(hashset)
        
        count=0
        i=0
        while(i<len(target)):
            j=0
            while(j<len(source) and i<len(target)):
                if(target[i] not in hashset):
                    #Clearly it is never possible to complete
                    return -1
                else:
                    if(target[i]==source[j]):
                        i+=1
                        j+=1
                    else:
                        j+=1
            count+=1
        
        return count
                        