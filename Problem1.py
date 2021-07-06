"""
time : o(n^2)
space : o(1)

"""


class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        len_s = len(source)
        len_t = len(target)
        
        t_ptr = 0 #2 pointers to iterate over the source and target 
        s_ptr = 0
        
        ct = 0
        while t_ptr < len_t:
            s_ptr = 0
            ct += 1
            curr = t_ptr
            while t_ptr < len_t and s_ptr < len_s:
                
                
                if source[s_ptr] == target[t_ptr]: # if chars match, increment both pointers
                    t_ptr += 1
                    
                s_ptr += 1 #else just the pointer on source
                
            if t_ptr == curr: # if target pointer doesnt move, that means there was no matching char found in source
                return -1
            

        return ct
                