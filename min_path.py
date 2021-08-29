# Time Complexity: O(s*t)
# Space Complexity: O(1)
class Solution:
    def shortestWay(self, source: str, target: str) -> int:

        curr_index = 0
        min_dist = 1

        for ch in target:

            curr_index = source.find(ch, curr_index)

            if curr_index == -1:

                curr_index = source.find(ch)
                min_dist += 1

                if curr_index == -1:
                    return curr_index

            curr_index += 1

        return min_dist
