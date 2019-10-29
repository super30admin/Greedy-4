class Solution:
	def findSwaps(self, A, B):
		# Time Complexity : O(n/2) + O(n) using two pointers we are finding the intersection of all the dominos and then linear way to find the number of swaps needed for A and for B. return the min value
		# Space Complexity : O(2) because we are stong a pair of i, j values
		# Accepted on Leetcode
		if len(A) == 0 or len(A) == 1:
			return 0
		res_set = {A[0], B[0]}
		left = 1
		right = len(A) - 1
		while left < right:
			res_set = res_set.intersection({A[left], B[left]}, {A[right], B[right]})
			left += 1
			right -= 1
		if left == right:
			res_set = res_set.intersection({A[left], B[left]})

		if len(res_set) == 0:
			return -1
		temp = res_set.pop()
		swapA = 0
		swapB = 0
		for i in range(len(A)):
			if temp != A[i]:
				swapA += 1
			if temp != B[i]:
				swapB += 1
		return min(swapA, swapB)

if __name__ == '__main__':
	fs = Solution()
	print(fs.findSwaps([2,1,2,4,2,2], [5,2,6,2,3,2]))
	print(fs.findSwaps([3,5,1,2,3], [3,6,3,3,4]))