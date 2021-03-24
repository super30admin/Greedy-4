"""
Time Complexity : O(mn)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
1. go through target until we find char in somurce more source pounter ahead
2. when source pointer goes out we increase count
3. if we get at same pointer again return -1

"""

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        sp, tp = 0,0
        count = 0
        
        while tp<len(target):
            count += 1
            sp = 0
            cur = tp
            
            while sp<len(source) and tp<len(target):
                if source[sp] == target[tp]:
                    tp += 1
                sp += 1
            if cur == tp:
                return -1
        return count
            
           
        