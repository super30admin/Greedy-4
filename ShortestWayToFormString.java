/*
 * #1055. Shortest Way to Form String
 * 
 * From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).

Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. If the task is impossible, return -1.

 

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
 

Constraints:

1. Both the source and target strings consist of only lowercase English letters from "a"-"z".
2. The lengths of source and target string are between 1 and 1000.


*/

/*
 * Time Complexity: O (M * N)
 * 
 * Space Complexity: O (1) -> No extra space used
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.greedy4;

public class ShortestWayToFormString {
	public int shortestWay(String source, String target) {
        
        // #1. Get the length of both strings in variables
        int s = source.length();
        int t = target.length();
        
        // #2. Initialize the two pinters to traverse the source and target strings
        int SP = 0;
        int TP = 0;
        
        // #3. Initialize the minimum number of subsequences in source string to get target string
        int min_subsequences = 0;
        
        // #4. Do until TP goes out of bounds
        while(TP < t){
            
            // #4.1. When SP goes out of bounds, reset it to find another sunsequence 
            SP = 0;
            
            // #4.2. Keep track of where the TP pointer was previously
            int prev = TP;
            
            // #4.3. Traverse until TP < t and SP < s to find subsequences in 'source' string to form 'target' string
            /*
            *   Here, we check for TP < t as well because TP can go out of bounds
            *   e.g: source = "abc", target = "abcbca"
            */
            while(TP < t && SP < s){
                // #4.4. If character at SP = character at TP, increment both pointers, else just increment SP pointer
                if(source.charAt(SP) == target.charAt(TP)){
                    TP++;
                }
                SP++;
            }
            
            // #4.5. After SP goes out of bounds, If TP pointer did not move, means we 'target' string contains a character not present in 'source' string, so cannot form 'target' string from minimum number of subsequences in 'source' string, return -1
            if(prev == TP){
                return -1;
            }
            
            // 4.6. If TP pointer moved from its previous place, means we have a found a subsequence in 'source' string, increment the count of subsequences
            min_subsequences += 1;
        }
        
        // #5. return the output
        return min_subsequences;
        
    }

}
