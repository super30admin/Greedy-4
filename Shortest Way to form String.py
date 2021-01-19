# Time:- O(mn)
# Space:- O(1)

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        i=0
        j=0
        seqs=0
        elementsmatched=0
        while(j<len(target)):
            # if source and target charachter match increment elements matched
            if source[i]==target[j]:
                elementsmatched+=1
                j+=1
            i+=1
            # if we have reached the end of the source we start another iteration from the start of the source
            if i==len(source):
                seqs+=1
                # while iterating through the source we couldnt match any element this means that 
                # the element doesnt exist in the source
                if elementsmatched==0:
                    return -1
                elementsmatched=0
                i=0
        if i>0:
            return seqs+1
        return seqs
        
            
            