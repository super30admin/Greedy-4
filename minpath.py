# Time complexity - O(n^2) worst case
# Space complexity - O(n) for hash table
# Did this solution run on leetcode? - yes
class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        # keep the track of last occurence of the current character.
        sourceHash = dict()
        for i, ch in enumerate(source):
            sourceHash[ch] = i
        
        idx, count = 0, 1
        for ch in target:
            if ch not in sourceHash: # if character is not in the source string, return -1.
                return -1
            
            # if the current index is greater than the index of the character in the source, reset the index.
            if idx>sourceHash[ch]:
                idx=0
                count += 1
            
            # check if the current index is less than the index of the character in the source hash table.
            while idx<=sourceHash[ch]:
                if ch == source[idx]:
                    idx+=1
                    break
                idx+=1
        
        return count
    
    
# Time complexity - O(n)
# Space complexity - O(1) no extra space
# Did this solution run on leetcode? - yes
# Using two pointers
class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        tptr, sptr, count = 0, 0, 0
        s, t = len(source), len(target)
        
        # traverse the target array using a target pointer.
        while tptr<t:
            sptr = 0
            count += 1
            curr = tptr
            
            while sptr<s and tptr<t:
                if source[sptr]==target[tptr]:
                    tptr+=1 # increment target pointer only if the character matches
                sptr+=1 # increment the source pointer in any case
                
            if tptr == curr: # if the character does not exist in the source string.
                return -1
            
        return count
        
        