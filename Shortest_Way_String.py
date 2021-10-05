#time:O(n)
#space:O(n)
class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        if target == None:
            return 0
        source_set = set(char for char in source)
        for char in target:
            if char not in source_set:
                return -1
        if source == None:
            return -1
        n=len(source)
        m=len(target)
        count = 0
        i=j=0
        while(i<m):
            while(j<n and i<m):
                if source[j]==target[i]:
                    j+=1
                    i+=1
                else:
                    j+=1
            count+=1
            j=0
        return count