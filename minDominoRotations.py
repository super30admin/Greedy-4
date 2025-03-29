class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        # T: O(n), S: O(1)
        def min_swaps(target):
            top_swaps = bottom_swaps = 0
            for i in range(len(tops)):
                if tops[i] != target and bottoms[i] != target:
                    return float("inf")  # Impossible to make all values 'target'
                elif tops[i] != target:
                    top_swaps += 1
                elif bottoms[i] != target:
                    bottom_swaps += 1
            return min(top_swaps, bottom_swaps)

        # Check for the first value in tops[0] or bottoms[0] as the dominant value
        swaps = min(min_swaps(tops[0]), min_swaps(bottoms[0]))
        return swaps if swaps != float("inf") else -1
