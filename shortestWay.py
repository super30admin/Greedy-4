"""
Time Complexity O(len(source)*len(target))
Space complexity O(1)


Input: source = "xyz", target = "xzyxz"

Output: 3

Example 1:

Input: source = "abc", target = "abcbc"

Output: 2

Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".

Example 2:

Input: source = "abc", target = "acdbc"

Output: -1

Explanation: The target string cannot be constructed from the subsequences of source string due to the character "d" in target string.

Example 3:

Input: source = "xyz", target = "xzyxz"

Output: 3

Explanation: The target string can be constructed as follows "xz" + "y" + "xz".



"""
class Solution(object):
    def shortestWay(self, source, target):
        """
        :type source: str
        :type target: str
        :rtype: int
        """
        
        src_ptr, target_ptr = 0, 0
        count = 0
        sl = len(source)
        tl = len(target)
        
        while target_ptr < tl:
            
            count += 1
            # Reset src_ptr to the start of source
            src_ptr = 0
            curr = target_ptr
            while src_ptr < sl and target_ptr < tl:
                # when char match, increment src_ptr , target_ptr
                if source[src_ptr] == target[target_ptr]:
                    target_ptr += 1
                src_ptr += 1
            # if src =abc and trg=abdc , if src doesn't have a charc in target 
            if curr == target_ptr:
                return -1

        print(count)
        return count

s=Solution()
s.shortestWay("xyz","xzyxz")