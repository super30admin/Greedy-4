class Solution:
    
    """
    Description: Find shortest ways to form string using a source and target
    
    Time Complexity: O(m*n)
    Space Complexity: O(1)
    
    Approach: Two Pointers
    1. with intention of traversing through target string; use the source in following way:
       - travserse through each element and check if they match
       - once match increase both source and target pointer, if not just move the source pointer
       - after going through source once; increase the number of ways
    2. for a non valid answer, ensure that the target pointer moves after each step in #1
       - if target pointer is stuck, return -1
    """
    
    def shortestWay(self, source: str, target: str) -> int:
        
        sl = len(source); tl = len(target)
        tp = 0; n_ways = 0
        
        while tp < tl:
            sp = 0
            n_ways += 1
            target_pos = tp
            while sp < sl and tp < tl:
                if source[sp] == target[tp]: 
                    tp += 1 
                sp += 1
            if tp == target_pos: return -1
            
        return n_ways
