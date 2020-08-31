# Time Complexity : O(mxn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def shortestway(self, s, target):
        if len(s) == 0:
            return 0 
        count = 0 
        i = 0 
        while i < len(target):
            j = 0 
            curr = i
            count += 1 
            while i < len(target) and j < len(s):
                if target[i] == s[j]:
                    i+=1
                j += 1
                    
            if curr == i:
                return -1
            # if i == len(target) or j == len(s):
            #     count += 1 
            
        return count 
                
            

if __name__ == "__main__":
    s = Solution()
    # test case 1 
    res = s.shortestway('xyz', 'xzyxz')
    print(res)
    # assert res == 2 
    
    # test case 2 
    res2 = s.shortestway('abc','abcb')
    print(res2)
    # # assert res2 == 2
    
    # test case 3 
    res2 = s.shortestway('abc', 'acdbc')
    print(res2)
    
    