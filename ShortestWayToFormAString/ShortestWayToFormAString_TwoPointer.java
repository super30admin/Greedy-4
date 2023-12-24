/* Time Complexity : O(m*n) 
 *  m - length of source
 *  n - length of target */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode :  
// Any problem you faced while coding this :

class Solution{
	public int shortestWay(String source, String target){
		int count = 1;
		int m = source.length;
		int i = 0;//src pointer
		int n = target.length;
		int j = 0;//target pointer
		HashSet<Character> set = new HashSet<>();
		for(int k = 0; k < m; k++{
			set.add(source.charAt(k))
		}
		
		while(j < n){
			if(!set.contains(target.charAt(j))) return -1;
			if(source.charAt(i) == target.charAt(j)){
				i++;
				j++;
				if(j == n){
					return count;
				}				
			} else{
				i++;
			}
			if(i == n){
				count++;
				i = 0;
			}
		}
		return -1;
	}
}