#Time Complexity:O(mn)
#Space Complexity:O(1)
class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        s=len(source)
        t=len(target)
        SP=0                                #A pointer that parses source string
        TP=0                                #a pointer that parses target string
        result=0                            #final output
        while TP<t:                         #while parsing of target is not completed
            result+=1                       #increment result for every completed parse of source
            SP=0                            #bring the source pointer back to first index
            curr=TP                         #place a current pointer at the target which is same as the target pointer
            while (SP<s and TP<t):          
                sCh=source[SP]
                tCh=target[TP]
                if sCh==tCh:                #if the charcters at the source pointer and target pointer of their respective arrays are same
                    SP+=1                   #increment both pointers by one
                    TP+=1       
                else:
                    SP+=1                   #if different increment only source pointer
            if curr==TP:                    #if the target pointer is at the same position as before i.e the character doesnt exist in source
                return -1                   #return -1
        return result                       #else return the final result.