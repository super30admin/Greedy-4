#Time Complexity:O(n)
#Spca Complexity:O(1)
#Ran successfully on Leetcode:Yes
#Apprach:
#1. Use two pointers check if teh character at each ptrs are matching or not. 
#2. If they are matching, increment both ptrs. Else just increment sptr only. 
#3. A current ptr is set a t ptr . 
#4. After sptr goes out of bound, if the tptr and curr ptr are at same location, we return -1 
#5. Thje result is incremented once the sptr goes out of bound and is set back to 0th index again.
#6. Return result

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        s=len(source)
        t=len(target)
        sptr=0
        tptr=0
        result=0
        while tptr<t:
            sptr=0
            result+=1
            curr=tptr
            while sptr<s and tptr<t:
                if source[sptr]==target[tptr]:
                    sptr+=1
                    tptr+=1
                else:
                    sptr+=1
            if curr==tptr:
                return -1
        return result
                    
                    
                
        
