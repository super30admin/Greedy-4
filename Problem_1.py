"""
Time Complexity : O(s*t) -This would be worst case, considering s is source length and t is target length
Space Complexity : O(1)- No extra space is being used
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
We would use a 2 pointer approach for this problem. We could start iterating source and the target simultaneously. As there can be
deletions in the source string, we keep on moving forward unless we reach end of it. Every iteration of source counts for an 
addition in the result. Also, there might be a situation where a character inside target does not exist inside source. In such a 
situation, we keep track of pointer inside target. If after one full iteration of source, the target pointer does not move, it means
there was no match inside the source, hence we could return from there.
"""


class Solution:
    def shortestWay(self, source: str, target: str) -> int:

        sl = len(source)
        tl = len(target)
        sp, tp, count = 0, 0, 0
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
