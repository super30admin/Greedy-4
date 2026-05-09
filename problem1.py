## Problem1: Minimum Path Form String formation

# https://leetcode.com/problems/shortest-way-to-form-string/

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        ip_source = set(source)
        i = 0 
        j = 0 
        count = 0
        while(j<len(target)):
            sChar = source[i]
            tChar = target[j]

            if tChar not in ip_source:
                return -1 

            if sChar == tChar:
                i+=1
                j+=1
                if j == len(target):
                    return count+1
            else:
                i+=1
            # reset
            if i == len(source):
                i = 0
                count+=1
        return -1