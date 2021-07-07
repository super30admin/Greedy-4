 #leetcode 1055
 #time - O(n*m)
 #algo : 2 pointers with one pointer Iterate over source and other over target to find each char in the target, if found as sequence (omitting characters in between if does not match) till end of the source is reached add 1 to counter variable called result
#curr to check if a char in target not in source(this can even be done with hash set
class Solution:
    #def __init__(self):
    def shortestway(self,source,target):
        s = len(source)
        t = len(target)
        sp= 0 #source point
        tp= 0 #target point
        result = 0
        #print(s,t,'length')
        #print(source,target)
        while tp < t: #target posotion keeps changing
            sp = 0
            curr = tp
            while sp < s:
                #print(source[sp] == target[tp],sp,s,tp,t)
                if tp < t and source[sp] == target[tp]:
                    #print('----')
                    tp += 1
                sp += 1
            if curr == tp: #this for a case when target has char/  chars not in source

                #print(curr,tp)
                return -1
            result += 1 #one iteration of source is done, increment for another subset
        return result
j = Solution()
res =j.shortestway('xyz','zyx')
print(res)
