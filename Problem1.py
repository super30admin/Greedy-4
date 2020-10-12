#Time complexity : O(M+N)
#Space complexity: O(M)
#Works on leetcode : yes
#Approach : We keep track of the following characters to the current one in a dictionary from the source. Then we go through
# the target characters. dic[0] will always have all characters from the source. If j is the length of source or the current 
#target character is not in dic[j], we reset j to 0 and add 1 to result. Also we update j by dic[j][character]. Finally we 
#return result+1 as after last increment, atleast one valid character has been observed 


class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        dic = {}
        for i in range(len(source))[::-1]:
            c = source[i]
            dic[i] = {} if i+1 not in dic else dic[i+1].copy()
            dic[i][c] = i+1
            
        res = 0
        j = 0
        for c in target:
            if c not in dic[0]:
                return -1
            if j==len(source) or c not in dic[j]:
                j = 0
                res +=1
            j = dic[j][c]
        return res+1