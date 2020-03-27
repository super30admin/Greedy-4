class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        """
            https://leetcode.com/problems/shortest-way-to-form-string/
            Time Complexity - O(mn)
            'm' is the length of source string
            'n' is the length of target string
            Space Complexity - O(1)
        """
        count = 0
        t_ptr = 0
        while t_ptr < len(target):
            s_ptr = 0
            cur_target = t_ptr
            while s_ptr < len(source) and t_ptr < len(target):
                if source[s_ptr] == target[t_ptr]:
                    s_ptr += 1
                    t_ptr += 1
                else:
                    s_ptr += 1
            if cur_target == t_ptr:
                return -1
            count += 1
        return count


if __name__ == '__main__':
    print(Solution().shortestWay("abc", "abcbc"))
    print(Solution().shortestWay("abc", "acdbc"))
