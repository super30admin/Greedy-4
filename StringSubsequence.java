// Time Complexity : O(mn)= O(n) where n is the number of elements in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Hashmap approach is only valid for unique characters not duplicates
/* Your code here along with comments explaining your approach: In approach 1, for each character in target, compare to the character whether it is equal
to the character in source, if it is, move both the pointers and if it isnt, only move source. We are trying to find the subsequence by moving continuously
the source pointer and target pointer only moves at equality. Whenever source moves out of the bounds increment the count of a subsequence and restart again.
In approach 2, it is only valid for unique characters, it is based on the idea if the character in target has occured at an index before the character in source,
if it has occured implies it forms a subsequence , increment the count. Use the hashmap to store source characters and its index.
*/
// APPROACH 1 : USE TWO POINTERS
class Solution {
    public int shortestWay(String source, String target) {
        if(source == null || target == null) return 0;
        int count = 0, p2 = 0, curr = 0;
        int i = 0;
        while(i < target.length()){                                                                             // As you traverse through target
            p2  = 0;
            curr = i;
            while(i < target.length() && p2 < source.length()){                                             // Move through the source again and again
                char c1 = source.charAt(p2);
                char c2 = target.charAt(i);                
                if(c1 == c2) {                                                                      // If the characters are equal move both pointers
                    i++;
                    p2++;
                } else {
                    p2++;                                                                               // unequal characters, move the source pointer
                }
            }
        if(curr == i) return -1;                                                                        // If the current is still at the same position at i implies no movement no equal characters
        count++;                                                                                        // Increment count as source reaches out of bounds
        }
        return count;
    }
}

// APPROACH 2 : USE HASHMAP
class Solution {
    public int shortestWay(String source, String target) {
        if(source == null || target == null) return 0;
        HashMap<Character, Integer> store = new HashMap<>();
        for(int i  = 0; i < source.length(); i++){
            store.put(source.charAt(i),  i);                                                                // Store the source characters and indices
        }
        int count = 1;
        int prev = store.get(target.charAt(0));                                                         // Keep the track of the previous character seen at source index
        for(int i = 1; i < target.length(); i++){
            char c = target.charAt(i);
            if(!store.containsKey(c)) return -1;                                                    // Map doesnt have the character implies -1
            if(store.get(c) < prev){                                                                // Compare the current character index in source with previous character seen in source's index
                count++;                                                                                // It is subsequence
            }
            prev = store.get(c);                                                                        // update the previous to current seen character in target
        }
        return count;
    }
}