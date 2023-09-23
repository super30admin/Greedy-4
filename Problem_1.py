# Time Complexity: O(m * n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
  def shortestWay(self, source, target):
    ans = 0
    i = 0
    while (i < len(target)):
      j = 0
      prevIndex = i
      while (j < len(source)):
        if ((i < len(target)) and (source[j] == target[i])):
          i += 1
        j += 1
      if i == prevIndex:
        return -1
      ans += 1
    return ans