class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        num = 0
        t_p = 0
        while t_p < len(target):
            s_p = 0
            flag = False
            while s_p < len(source) and t_p < len(target):
                if source[s_p] == target[t_p]:
                    s_p += 1
                    t_p +=1
                    flag = True
                else:
                    s_p +=1
                    
            if flag == True:
                num +=1
            else:
                return -1
        return num 