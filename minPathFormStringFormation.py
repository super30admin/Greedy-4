# Time Complexity : O(MN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :  No


# Your code here along with comments explaining your approach

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        sl = len(source)
        tl = len(target)
        sp = tp = 0
        count = 0
        while tp < tl:
            count += 1
            sp = 0
            curr = tp 
            while sp < sl and tp < tl:
                if source[sp] == target[tp]:
                    tp += 1
                
                sp += 1
            if curr == tp:
                return -1
            
        return count