Time Complexity = O(m*n)
Space Complexity = O(1)

class Solution{
	public int shortestWay(String source, String target){

		int sCursor = 0, tCursor = 0;
		int count = 0;

		while(tCursor < target.length()){
			int currentPosition = tCursor;
			while(sCursor < source.length() && tCursor < target.length()){
				if(source.charAt(sCursor) == target.charAt(tCursor)){
					sCursor++;
					tCursor++;
				}else{
					sCursor++;
				}
			}
			//After entire pass tCursor is at same position
			if(tCursor == currentPosition) return -1;

			sCursor = 0;
			count++;
		}
		return count;
	}
}