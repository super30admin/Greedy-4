#Time Complexity : O(t*s) where t is length of the target and s is the length of the source
#Space Complexity : O(1) 
#Did this code successfully run on Leetcode : Yes

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        sLen, tLen = len(source), len(target)
        currT, currS = 0, 0
        result = 0

        while currT < tLen:
            result += 1
            startT = currT
            currS = 0
            while currS < sLen and currT < tLen:
                if source[currS] == target[currT]:
                    currT += 1
                currS += 1

            if currT == startT:
                return -1

        return result
