# TIME COMPLEXITY: O(s*t)
# SPACE COMPLEXITY: O(1)
class Solution(object):
    def shortestWay(self, source, target):
        """
        :type source: str
        :type target: str
        :rtype: int
        """
        # Initialize two pointers, one to keep track of the source and one for target string
        src_ptr, target_ptr = 0, 0
        count = 0
        s_len = len(source)
        t_len = len(target)
        # Scan over the target string and match all the subsequences of source string
        while target_ptr < t_len:
            # Start a new subsequence match
            count += 1
            # Reset src_ptr to the start of source
            src_ptr = 0
            start_t = target_ptr
            while src_ptr < s_len and target_ptr < t_len:
                # If the characters match, increment src_ptr & target_ptr
                if source[src_ptr] == target[target_ptr]:
                    target_ptr += 1
                src_ptr += 1
            # At any point if the start of target_ptr == target_ptr -> no susequence of the source matches target, return -1
            if start_t == target_ptr:
                return -1

        return count
