class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        # T: O(m * k), S: O(k)
        source_set = set(source)  # To check for missing characters
        count = 0  # Number of times source is used
        i = 0  # Pointer for target

        while i < len(target):
            j = 0  # Pointer for source
            found = False  # To track if progress is made

            while j < len(source) and i < len(target):
                if target[i] == source[j]:  # Match found
                    i += 1
                    found = True
                j += 1

            if not found:
                return -1  # No progress means character missing

            count += 1  # Used source once

        return count
