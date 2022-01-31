# Time: O(n*m)
# Space: O(1)
class Solution(object):
    def shortestWay(self, source, target):
        """
        :type source: str
        :type target: str
        :rtype: int
        """
        for i in target:
            if i not in source:
                return -1
        i = 0
        j = 0
        ans = 1
        while j < len(target):
            if source[i] == target[j]:
                i += 1
                j +=1
            else:
                i += 1
            if i == len(source) and j != len(target):
                i = 0
                ans += 1
        return ans
                
            
        
