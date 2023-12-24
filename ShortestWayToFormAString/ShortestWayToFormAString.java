/* Time Complexity : O(n log k) 
 *  n - length of target 
 *  k - Avg. number of occurences in src string */
/* Space Complexity : O(26*k) =~ O(k) */
// Did this code successfully run on Leetcode :  
// Any problem you faced while coding this :

class Solution{
	public int shortestWay(String source, String target){
		int count = 1;
		int m = source.length;
		int i = 0;//src pointer
		int n = target.length;
		int j = 0;//target pointer
		
		//Map - char and index of thier occurences
		HashMap<Character, List<Integer>> map = new HashMap<>();
		for(int k = 0; k < m; k++{
			char c = source.charAt(k);
			if(!map.containsKey(c)){
				map.put(c, new ArrayList<>());
			}
			map.get(c).add(i);
		}
		
		//Iterate over target string using map to find the index and occurences
		while(j < n){
			char t = source.charAt(j);
			if(!map.containsKey(t)) return -1;
			List<Integer> li = map.get(t);
			int k = Collections.binarySearch(li, i);
			if(k < 0){
				k = -k -1;
			}
			if(k == li.size()){
				i = 0;
				count++;
			} else {
				i = li.get(k);
				i++;
				j++;
			}
		}
		return count;
	}
}